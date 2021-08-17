package cn.com.sun.ksv.crawler;

import cn.com.sun.ksv.util.FFMPEG;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.info.MultimediaInfo;
import ws.schild.jave.info.VideoSize;

import java.io.File;

/**
 * @Description :
 * @Author : mockingbird
 * @Date : 2021/3/11 20:45
 */
public class FFMPEGTest {
    private static final Logger logger = LoggerFactory.getLogger(FFMPEGTest.class);

    @Test
    public void resize() {
        File source = new File("D:\\output\\2021-03-11\\9.mp4");
        FFMPEG.resize(source.getAbsolutePath(), new VideoSize(720, 1280).asEncoderArgument(), getTempPath(source));
    }

    @Test
    public void cut() {
        File source = new File("D:\\output\\2021-03-11\\9.mp4");
        FFMPEG.cut(source.getAbsolutePath(), "00:00:00", "00:00:08", getTempPath(source));
    }

    @Test
    public void processDouYin() {
        File source = new File("E:\\dev\\ksv-crawler\\output\\2021-06-02\\3.mp4");
        //1.获取视频长度信息 计算起止时间
        MultimediaInfo info = FFMPEG.getVideoInfo(source);
        String endTime = calEndTime(info.getDuration(), source);
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

    private String getPartPath(File source, String part) {
        // 获取temp文件
        String partPath = source.getParent() + File.separator + source.getName().replace(".mp4", part + ".mp4");
        File temp = new File(partPath);
        return temp.getAbsolutePath();
    }

    private String calEndTime(long total, File source) {
        // 去除片尾
        long duration = total - 3500l;
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
            logger.error("video {} duration over 60 min", source);
        }
        return endTime.toString();
    }

    @Test
    public void extend() {
        File source = new File("D:\\output\\2021-03-11\\9.mp4");
        float expect = 12;
        MultimediaInfo info = FFMPEG.getVideoInfo(source);
        float actual = info.getDuration() / 1000;
        if (actual < 12) {
            float factor = expect / actual;
            FFMPEG.extend(source.getAbsolutePath(), factor, getTempPath(source));
        }
    }

    @Test
    public void resizeAndExtend() {

    }

    private String getTempPath(File source) {
        // 获取temp文件
        String tempPath = source.getParent() + File.separator + source.getName().replace(".mp4", "temp.mp4");
        File temp = new File(tempPath);
        return temp.getAbsolutePath();
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
}
