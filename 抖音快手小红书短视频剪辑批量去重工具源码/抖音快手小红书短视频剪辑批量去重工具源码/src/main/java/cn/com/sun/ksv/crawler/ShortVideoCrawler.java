package cn.com.sun.ksv.crawler;

import cn.com.sun.ksv.model.Video;
import cn.com.sun.ksv.util.FFMPEG;
import cn.com.sun.ksv.util.FileAccessManager;
import cn.com.sun.ksv.util.HttpClient;
import cn.com.sun.ksv.util.ImageHistogram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.info.MultimediaInfo;
import ws.schild.jave.info.VideoSize;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBeNotEmpty;

/**
 * @Description :
 * @Author : mockingbird
 * @Date : 2021/3/9 14:09
 */
public class ShortVideoCrawler implements VideoCrawler {

    private static Logger logger = LoggerFactory.getLogger(ShortVideoCrawler.class);

    private List<String> urlList;

    private List<Video> filteredVideoList = new ArrayList<>();

    private List<Video> downloadVideoList = new ArrayList<>();

    private List<Video> successVideoList = new ArrayList<>();
    private List<Video> failedList = new ArrayList<>();

    private File outputDir;

    private WebDriver driver;

    private String date;

    private static String regEx = "[0-9]*.mp4";

    private File baseImage;

    public ShortVideoCrawler(List<String> urlList) {
        this.urlList = urlList;
        initWebDriver();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.format(new Date());
        String path = CrawlerConfig.getProperties("rootDir") + "//output" + File.separator + date;
        this.outputDir = new File(path);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        // 基准图片
        this.baseImage = new File(CrawlerConfig.getProperties("rootDir") + "//base.jpg");
    }

    private void initWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--headless");
        options.setBinary(new File(CrawlerConfig.getProperties("browserPath")));
        this.driver = new ChromeDriver(options);
    }

    @Override
    public VideoCrawler parseVideoBaseInfo() {
        return null;
    }

    @Override
    public VideoCrawler parseVideoExtInfo() {
        return null;
    }

    @Override
    public VideoCrawler parseDownloadUrl() {
        Map<String, Video> downloadedMap = FileAccessManager.getInstance().read();
        // id title pageUrl
        urlList.stream().forEach(url -> {
            String id = url.substring(url.length() - 8, url.length() - 1);
            if (downloadedMap.keySet().contains(id)) {
                logger.info("filter downloaded video:{}", url);
            } else {
                Video video = new Video();
                video.setUrl(url);
                video.setId(id);
                video.setDate(date);
                filteredVideoList.add(video);
            }
        });

        if (!filteredVideoList.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            logger.info("开始解析视频下载地址 总视频数量：{}", filteredVideoList.size());
            Random random = new Random();
            for (Video video : filteredVideoList) {
                float seed = random.nextFloat();
                float second = (seed / 0.5f) + 2;
                String videoUrl = "";
                try {
                    Thread.sleep((long) (second * 1000f));
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
                driver.get(video.getUrl());
                boolean videoPresence = false;
                int tryCount = 0;
                WebElement videoElement = null;
                // 循环获取video
                do {
                    // 尝试5次
                    tryCount++;
                    if (tryCount > 5) {
                        logger.warn("get {} failed ", video.getUrl());
                        break;
                    }
                    try {
                        videoElement = driver.findElement(By.cssSelector("video"));
                        videoPresence = true;
                    } catch (Exception e) {
                        logger.info("video element not presence find again");
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException interruptedException) {
                            logger.error(e.getMessage(), e);
                        }
                    }
                } while (!videoPresence);
                try {
                    if (videoElement != null) {
                        WebElement source = videoElement.findElement(By.cssSelector("source"));
                        if (source != null) {
                            wait.until(attributeToBeNotEmpty(source, "src"));
                            videoUrl = source.getAttribute("src");
                        } else {
                            throw new Exception("get video element failed : source tag is null ");
                        }
                    } else throw new Exception("get video element failed : video tag is null ");
                } catch (Exception e) {
                    logger.info("获取视频下载地址失败：{} Error: {}", video.getUrl(), e.getMessage());
                }
                if (!videoUrl.isEmpty()) {
                    video.setDownloadUrl(videoUrl);
                    downloadVideoList.add(video);
                    logger.info("获取视频下载地址成功：{}", video.getUrl());
                }
                //System.out.println(video.getAttribute("src"));
            }
            logger.info("解析视频下载地址完成 解析成功视频数量:{}", downloadVideoList.size());
            // 关闭driver
            driver.quit();
        }
        return this;
    }

    @Override
    public VideoCrawler download() {
        if (!downloadVideoList.isEmpty()) {
            AtomicInteger num = new AtomicInteger(0);
            ThreadFactory threadFactory = r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName("download-processor-" + num.incrementAndGet());
                return t;
            };
            // 无限任务队列
            BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(16, Integer.MAX_VALUE, 5, TimeUnit.MINUTES,
                    linkedBlockingQueue, threadFactory);
            AtomicInteger succeeded = new AtomicInteger(0);
            AtomicInteger failed = new AtomicInteger(0);
            logger.info("开始下载视频 视频数量：{}", downloadVideoList.size());
            for (int i = 0; i < downloadVideoList.size(); i++) {
                Video video = downloadVideoList.get(i);
                String filePath = outputDir + File.separator + video.getId() + ".mp4";
                Callable<Boolean> downloadTask = () -> HttpClient.downloadVideoToFs(video.getDownloadUrl(), filePath);
                Future<Boolean> result = executor.submit(downloadTask);
                Runnable monitorTask = () -> {
                    try {
                        if (result.get().booleanValue()) {
                            logger.info("下载视频成功,地址:{}", video.getDownloadUrl());
                            video.setPath(filePath);
                            FileAccessManager.getInstance().write(video);
                            successVideoList.add(video);
                            succeeded.incrementAndGet();
                        } else {
                            // 删除失败的视频
                            File file = new File(filePath);
                            if (file.exists()) {
                                file.delete();
                            }
                            failedList.add(video);
                            failed.incrementAndGet();
                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                };
                executor.submit(monitorTask);
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread downloadMonitor = new Thread(() -> {
                while (executor.getActiveCount() != 0) {
                    try {
                        Thread.sleep(10000);
                        logger.info("全部视频数量:{}; 成功:{}; 失败:{}", downloadVideoList.size(), succeeded, failed);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
                countDownLatch.countDown();
            });
            downloadMonitor.setName("download-monitor");
            downloadMonitor.start();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
        failedList.forEach(url -> logger.error("下载失败: {}", url));
        return this;
    }

    /**
     * 用于兼容处理下载好的视频
     *
     * @param path
     */
    public void processVideo(String path) {
        // 兼容直接处理视频
        if (path != null) {
            successVideoList.clear();
            File dir = new File(path);
            for (File file : dir.listFiles()) {
                Video video = new Video();
                video.setPath(file.getAbsolutePath());
                successVideoList.add(video);
                logger.info("add video {}", video.getPath());
            }
            outputDir = dir;
        }

        // 文件名修改为数字编号
        int currentMaxNum = findMax();
        for (Video video : successVideoList) {
            File source = new File(video.getPath());
            //1.分辨率处理
            MultimediaInfo multimediaInfo = FFMPEG.getVideoInfo(source);
            // 如果视频小于5s删掉
            if (multimediaInfo.getDuration() < 5000l) {
                source.delete();
                logger.warn("视频{}长度小于5s，删除不予处理", source);
                continue;
            }
            VideoSize expectSize = new VideoSize(720, 1280);
            VideoSize actualSize = multimediaInfo.getVideo().getSize();
            // 实际分辨率太离谱的话直接跳过该视频处理  TODO 横向的的视频添加上下黑框转换成竖向视频
            if (actualSize.getWidth() > actualSize.getHeight()) {
                logger.warn("视频{}分辨率异常，删除不予处理", source);
                continue;
            }
            if (!expectSize.asEncoderArgument().equals(actualSize.asEncoderArgument())) {
                String tempPath = getTempPath(source);
                FFMPEG.resize(source.getAbsolutePath(), expectSize.asEncoderArgument(), tempPath);
                deleteAndRename(source, new File(tempPath));
                logger.info("视频{}分辨率修改成功", source.getName());
            }
            //2.针对抖音视频去水印去片尾处理
            processDouyin(source);
            //3.时长处理
            if (!source.exists()) {
                return;
            }
            MultimediaInfo info = FFMPEG.getVideoInfo(source);
            float actualDuration = (float) info.getDuration() / 1000f;
            if (actualDuration < 12.0f) {
                float factor = 12.5f / actualDuration;
                FFMPEG.extend(source.getAbsolutePath(), factor, getTempPath(source));
                deleteAndRename(source, new File(getTempPath(source)));
                logger.info("视频{}加长成功", source.getName());
            } else if (actualDuration > 120f) {
                FFMPEG.cut(source.getAbsolutePath(), "00:00:00", "00:00:119", getTempPath(source));
                deleteAndRename(source, new File(getTempPath(source)));
                logger.info("视频{}减短成功", source.getName());
            }

            //4.编号
            // 英文 修改文件名
            File target = new File(outputDir + File.separator + (++currentMaxNum) + ".mp4");
            if (source.renameTo(target)) logger.info("{}重命名为{}", source.getName(), target.getName());

        }
    }

    private int findMax() {
        int maxNum = 0;
        for (File file : outputDir.listFiles()) {
            String fileName = file.getName();
            if (Pattern.matches(regEx, fileName)) {
                // 数字判断最大值
                int num = Integer.parseInt(fileName.replaceAll(".mp4", ""));
                maxNum = num > maxNum ? num : maxNum;
            }
        }
        return maxNum;
    }

    public void processDouyin(File source) {
        MultimediaInfo info = FFMPEG.getVideoInfo(source);
        // 获取视频结束前2s的画面帧 判断是否有片尾
        long duration = info.getDuration();
        String sampleImage = source.getParentFile().getAbsolutePath() + "\\sampleImage.jpg";
        FFMPEG.getFrame(formatInstant(duration - 2000l), source.getAbsolutePath(), sampleImage);
        // 判断相似度以判断是否含有抖音专用片尾
        File sampleImageFile = new File(sampleImage);
        double similarity = 0;
        try {
            similarity = ImageHistogram.getInstance().match(baseImage, sampleImageFile);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        // 删除
        sampleImageFile.delete();
        String endTime = null;
        if (similarity > 0.95d) {
            // 如果去掉片尾不足5s则删除
            if (duration < 8500l) {
                logger.warn("视频{}删除片尾不足5s，删除不予处理", source);
                return;
            }
            // 含有片尾 砍去最后3.5s
            endTime = formatInstant(duration - 3500);
        }

        try {
            String first = getPartPath(source, "firstPart");
            String second = getPartPath(source, "secondPart");
            String out = getTempPath(source);
            //2.去除左上角水印
            FFMPEG.delogoFirstPart(source.getAbsolutePath(), first);
            //3.去除右下角水印
            FFMPEG.delogoSecondPart(source.getAbsolutePath(), endTime, second);
            //4.合并视频
            FFMPEG.mergeDouYin(first, second, out);
            deleteAndRename(source, new File(out));
            if (new File(first).delete() && new File(second).delete()) {
                logger.info("process douyin video {} success", source.getAbsolutePath());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void deleteAndRename(File source, File temp) {
        // 重命名文件
        File target = new File(temp.getAbsolutePath().replace("temp.mp4", ".mp4"));
        if (source.delete()) {
            temp.renameTo(target);
            //logger.info("视频{}修改成功", source.getName());
        } else
            logger.error("视频重命名失败");
    }

    private String getPartPath(File source, String part) {
        // 获取temp文件
        String partPath = source.getParent() + File.separator + source.getName().replace(".mp4", part + ".mp4");
        File temp = new File(partPath);
        return temp.getAbsolutePath();
    }

    private String formatInstant(long duration) {
        StringBuilder endTime = new StringBuilder();
        long mill = duration % 1000;
        long sec;
        long min;
        if (duration >= 60000) {
            min = duration / 60000;
            sec = (duration - min * 60000) / 1000;
            endTime.append(min).append(":").append(sec).append(".").append(mill);
        } else if (duration < 60000) {
            min = 0;
            sec = duration / 1000;
            endTime.append("00").append(":").append(sec).append(".").append(mill);
        } else {
            logger.error("duration over 60 min");
        }
        return endTime.toString();
    }


    private String getTempPath(File source) {
        // 获取temp文件
        String tempPath = source.getParent() + File.separator + source.getName().replace(".mp4", "temp.mp4");
        File temp = new File(tempPath);
        return temp.getAbsolutePath();
    }
}
