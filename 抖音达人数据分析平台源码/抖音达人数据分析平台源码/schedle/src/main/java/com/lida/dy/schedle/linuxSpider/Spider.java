package com.lida.dy.schedle.linuxSpider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.schedle.dao.TalentUserRepository;
import com.lida.dy.schedle.entity.PriceEntity;
import com.lida.dy.schedle.entity.Tag;
import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import com.lida.dy.schedle.entity.VideoEntity;
import com.lida.dy.schedle.util.SpiderUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 星图批量爬取
 * @Auther: lida
 * @Description:
 * @Date 2020/3/2 0002 11:41
 * @Version: 1.0
 */
@Component
public class Spider {
    @Autowired
    LinuxConf linuxConf;
    @Autowired
    Save save;
    @Autowired
    MessageNotifed messageNotifed;
    @Autowired
    State state;
    @Autowired
    TalentUserRepository talentUserRepository;

    public WebDriver driver;

    public void main(boolean hasUI) {
        createDriver(hasUI);
        //模拟登录
        try {
            mockLogin(driver);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("超时");
        }
        startTask(driver);
//        addErrorData(driver);
    }

    /**
     * 修复异常缺少的数据
     *
     * @param driver
     */
    private void addErrorData(WebDriver driver) {
        for (; ; ) {
            List<TalentUserInfoEntity> talentUserInfoEntities = talentUserRepository.findAllByOtherWithError(PageRequest.of(0, 20));
            if (talentUserInfoEntities == null || talentUserInfoEntities.size() < 2) {
                return;
            }
            for (TalentUserInfoEntity talentUserInfoEntity : talentUserInfoEntities) {
                if (talentUserInfoEntity.getDatafrom() != null && talentUserInfoEntity.getDatafrom().startsWith("spider:")) {
                    continue;
                }
                talentUserInfoEntity.setDatafrom("spider:addErrorData:修复");
                talentUserRepository.save(talentUserInfoEntity);
                try {
                    String nickName = talentUserInfoEntity.getNickName();
                    System.out.println(nickName);
                    JSONObject byNickname = getByNickname(nickName);
                    if (byNickname == null || byNickname.size() < 1) {
                        if (!messageNotifed.add("无法爬取")) {
                            return;
                        }
                        continue;
                    }
                    TalentUserInfoEntity talentUserInfoEntity1 = dealAuthorWithFixError(byNickname);
                    ArrayList<VideoEntity> video = getVideoAndAvg(talentUserInfoEntity1.getAuthorid(), talentUserInfoEntity1);
                    talentUserInfoEntity.setXtPrePlayNum(talentUserInfoEntity1.getXtPrePlayNum());
                    talentUserInfoEntity.setXtCpm(talentUserInfoEntity1.getXtCpm());
                    talentUserInfoEntity.setXtOrderCompleteNum(talentUserInfoEntity1.getXtOrderCompleteNum());
                    talentUserInfoEntity.setAvgPlayNum(talentUserInfoEntity1.getAvgPlayNum());
                    talentUserInfoEntity.setAvgShareNum(talentUserInfoEntity1.getAvgShareNum());
                    talentUserInfoEntity.setAvgComment(talentUserInfoEntity1.getAvgComment());
                    talentUserInfoEntity.setAvgLike(talentUserInfoEntity1.getAvgLike());
                    if (talentUserInfoEntity.getUid() == null) {
                        talentUserInfoEntity.setUid(talentUserInfoEntity1.getUid());
                    }
                    if (talentUserInfoEntity.getFansCount() == null) {
                        talentUserInfoEntity.setFansCount(talentUserInfoEntity1.getFansCount());
                    }
                    talentUserInfoEntity.setDatafrom("spider:addErrorData:修复");
                    talentUserRepository.save(talentUserInfoEntity);
                    if (video == null || video.size() < 1) {
                        state.setTalentFailNum(state.getTalentFailNum() + 1);
                        if (!messageNotifed.add("无法爬取")) {
                            return;
                        }
                        continue;
                    } else {
                        for (VideoEntity videoEntity : video) {
                            System.out.println("video vid:" + videoEntity.getVid() + "title:" + videoEntity.getVideoTitle());
                        }
                    }
                    save.saveVideo(talentUserInfoEntity.getId(), talentUserInfoEntity.getUid(), video);
                    save.addFansChange(talentUserInfoEntity1.getAuthorid(), talentUserInfoEntity.getUid(), talentUserInfoEntity.getId(), driver);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (!messageNotifed.add(e.getMessage())) {
                        return;
                    }
                }
            }
        }
    }

    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5A-Za-z]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    private JSONObject getByNickname(String name) throws InterruptedException, UnsupportedEncodingException {
        String searchBaseUrl = "https://star.toutiao.com/v/api/demand/author_list/?page=1&limit=20&need_detail=true&only_nick_name=true&platform_source=1&task_category=1&key=";
        String key = URLEncoder.encode(name, "UTF8");
        String searchURL = searchBaseUrl + key + "&order_by=score";
        Thread.sleep(1000);
        driver.get(searchURL);
        String pageSource = driver.getPageSource();
        pageSource = SpiderUtil.cleanHtml(pageSource);
        JSONObject jsonObject = JSON.parseObject(pageSource);
        if (jsonObject.getInteger("code") == 0) {
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("authors");
            for (int i = 0; i < jsonArray.size(); i++) {
                System.out.println("nickname:" + jsonArray.getJSONObject(i).getString("nick_name"));
                if (jsonArray.getJSONObject(i).getString("nick_name").trim().equals(name.trim())) {
                    System.out.println("ok");
                    return jsonArray.getJSONObject(i);
                }
                if (i == jsonArray.size() - 1) {
                    System.out.println("error : " + name);
                }
            }
            if (jsonArray.size() > 0) {
                return jsonArray.getJSONObject(0);
            }
        }
        return null;
    }

    public WebDriver createDriver(boolean hasUi) {
        if (driver != null) {
            driver.close();
        }
        System.out.println("start ....................");
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置为 headless 模式 （无头浏览器）
        if (!hasUi) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    public void close() {
        if (driver != null) {
            driver.close();
        }
        LinuxUtil.saveLinuxData();
    }

    private void startTask(WebDriver driver) {
        CategoryData.init(linuxConf);
        LinuxUtil.init(linuxConf);
        save.updateTalentTypeEntity();
        while (!LinuxUtil.linuxData.end) {

            ArrayList<TalentUserInfoEntity> author = null;
            try {
                author = getAuthor();
            } catch (MyException e) {
                return;
            }

            if (author != null) {
                try {
                    for (TalentUserInfoEntity talentUserInfoEntity : author) {
                        System.out.println(LinuxUtil.getNowDate() + ":" + state.toString());
                        ArrayList<VideoEntity> video = getVideoAndAvg(talentUserInfoEntity.getAuthorid(), talentUserInfoEntity);
                        if (video == null || video.size() < 1) {
                            state.setTalentFailNum(state.getTalentFailNum() + 1);
                            if (!messageNotifed.add("无法爬取")) {
                                return;
                            }
                            continue;
                        } else {
                            for (VideoEntity videoEntity : video) {
                                System.out.println("video vid:" + videoEntity.getVid() + "title:" + videoEntity.getVideoTitle());
                            }
                        }
                        talentUserInfoEntity.setDatafrom("spider:新入库");
                        save.saveData(talentUserInfoEntity, video);
                        save.addFansChange(talentUserInfoEntity.getAuthorid(), talentUserInfoEntity.getUid(), talentUserInfoEntity.getId(), driver);
                        state.setTalentAllNum(state.getTalentAllNum() + 1);
                        state.setVideoAllNum(state.getVideoAllNum() + video.size());
                        messageNotifed.subFailSpideTimes();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (!messageNotifed.add(e.getMessage())) {
                        return;
                    }
                } finally {

                }
            } else {
                return;
            }
            LinuxUtil.saveLinuxData();

        }
    }

    public ArrayList<VideoEntity> getVideoAndAvg(String authorid, TalentUserInfoEntity talentUserInfoEntity) throws InterruptedException, MyException {
        // todo
        String url = LinuxUtil.getVideoUrl(authorid, "1");
        String lasturl;
        int num = 45;
        while (num > 3) {
            Thread.sleep(1000);
            lasturl = url + num;
            driver.get(lasturl);
            String data = LinuxUtil.cleanHtml(driver.getPageSource());
            JSONObject jsonObject = JSON.parseObject(data);
            if (jsonObject.getInteger("code") != 0) {
                num = num - num / 3;
                continue;
            } else {
                System.out.println("parsevideo  okokok");
                JSONArray videos = jsonObject.getJSONObject("data").getJSONArray("ltm_item_statics");
                dealAvgData(jsonObject.getJSONObject("data").getJSONObject("description"), talentUserInfoEntity);
                ArrayList<VideoEntity> videoEntities = new ArrayList<>();
                for (int i = 0; i < videos.size(); i++) {
                    VideoEntity videoEntity = new VideoEntity();
                    JSONObject video = videos.getJSONObject(i);
                    videoEntity.setCommentNum(video.getInteger("comment"));
                    videoEntity.setPlayNum(video.getInteger("play"));
                    videoEntity.setFavoritedNum(video.getInteger("like"));
                    videoEntity.setWorkerLink(video.getString("url"));
                    videoEntity.setVid(video.getString("video_id"));
                    videoEntity.setShareNum(video.getInteger("share"));
                    videoEntity.setVideoTitle(video.getString("item_title"));
                    videoEntity.setCreateTime(video.getLong("create_time"));
                    videoEntity.setItem_id(video.getString("item_id"));
                    String imgurl = "https://sf1-ttcdn-tos.pstatp.com/obj/" + video.getString("head_image_uri");
                    videoEntity.setHeadImageUri(imgurl);
                    videoEntities.add(videoEntity);
                }
                return videoEntities;
            }
        }
        if (num <= 3) {
            throw new MyException("作品接口无法爬取");
        }
        return null;
    }

    private void dealAvgData(JSONObject jsonObject, TalentUserInfoEntity talentUserInfoEntity) {
        talentUserInfoEntity.setAvgLike(jsonObject.getInteger("medium_like"));
        talentUserInfoEntity.setAvgComment(jsonObject.getInteger("medium_comment"));
        talentUserInfoEntity.setAvgPlayNum(jsonObject.getInteger("medium_play"));
        talentUserInfoEntity.setAvgShareNum(jsonObject.getInteger("medium_share"));
    }

    private ArrayList<TalentUserInfoEntity> getAuthor() throws MyException {
        String category = CategoryData.getCategory(LinuxUtil.linuxData.getPlatformSource(), LinuxUtil.linuxData.getCurrentCatagoryNum());
        String authorListUrl = getUrl();
        driver.get(authorListUrl);
        String pageSource = driver.getPageSource();
        pageSource = LinuxUtil.cleanHtml(pageSource);
        JSONObject jsonObject = JSON.parseObject(pageSource);
        if (jsonObject.getInteger("code") == 0) {
            checkRefreshTalentNum(jsonObject);
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("authors");
            hasMore = jsonObject.getJSONObject("data").getJSONObject("pagination").getBooleanValue("has_more");
            ArrayList<TalentUserInfoEntity> authorList = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                TalentUserInfoEntity author = dealAuthor(jsonArray.getJSONObject(i));
                if (author == null) {
                    continue;
                }
                author.setPlatformId(LinuxUtil.linuxData.getPlatformSource());
                authorList.add(author);
                LinuxUtil.linuxData.addTalent();
            }
            return authorList;
        } else {
            throw new MyException("无法爬取");
        }
    }

    boolean hasMore = true;

    private String getUrl() {
//        if(!hasMore){
//            throw new RuntimeException("結束");
//        }
        String category = CategoryData.getCategory(LinuxUtil.linuxData.getPlatformSource(), LinuxUtil.linuxData.currentCatagoryNum);
        return LinuxUtil.getOtherAuthorList(LinuxUtil.linuxData.getPlatformSource(), LinuxUtil.linuxData.getPage(), LinuxUtil.linuxData.getLimit(), category);
    }

    /**
     * 获取当前分类下达人总数量
     *
     * @param jsonObject
     */
    private void checkRefreshTalentNum(JSONObject jsonObject) {
        if (LinuxUtil.linuxData.isRefreshTotalCount) {
            LinuxUtil.linuxData.setTotalCount(jsonObject.getJSONObject("data").getJSONObject("pagination").getInteger("total_count"));
            LinuxUtil.linuxData.setisRefreshTotalCount(false);
        }
    }


    private TalentUserInfoEntity dealAuthor(JSONObject author) {
        if (!author.getBooleanValue("is_star")) {
            return null;
        }
        TalentUserInfoEntity userInfo = new TalentUserInfoEntity();
        userInfo.setUid(author.getString("core_user_id"));
        userInfo.setGender(author.getInteger("gender"));
        userInfo.setUniqueId(author.getString("unique_id"));
        userInfo.setNickName(author.getString("nick_name"));
        userInfo.setAvatarLink(author.getString("avatar_uri"));
        userInfo.setProvince(author.getString("province"));
        userInfo.setCity(author.getString("city"));
        userInfo.setOther("1");
        userInfo.setAuthorid(author.getString("id"));
        System.out.println("达人id:" + userInfo.getUid());
        userInfo.setFansCount(author.getInteger("follower"));
        if (LinuxUtil.linuxData.getPlatformSource() == 1) {
            userInfo.setXtPrePlayNum(author.getInteger("expected_play_num"));
            userInfo.setXtCpm(author.getFloat("expected_cpm"));
            userInfo.setXtOrderCompleteNum(author.getIntValue("order_cnt"));
        }
        JSONObject tags_relation = author.getJSONObject("tags_relation");
        Set<String> keySet = tags_relation.keySet();
        ArrayList<Tag> tags = new ArrayList<>();
        for (String key : keySet) {
            Tag tag = new Tag();
            JSONArray jsonArray = tags_relation.getJSONArray(key);
            ArrayList<String> subtags = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                subtags.add(jsonArray.getString(i));
            }
            tag.setSubTag(subtags);
            tag.setTag(key);
            tags.add(tag);
        }
        userInfo.setTags(tags);
        JSONArray price_info = author.getJSONArray("price_info");
        ArrayList<PriceEntity> priceEntities = new ArrayList<>();
        for (int i = 0; i < price_info.size(); i++) {
            PriceEntity priceEntity = new PriceEntity();
            JSONObject jsonObject = price_info.getJSONObject(i);

            priceEntity.setTimeRange(jsonObject.getString("desc"));
            priceEntity.setType(jsonObject.getString("settlement_desc"));
            if (jsonObject.getString("desc").indexOf("按播放量付费") < 0) {
                priceEntity.setPrice(jsonObject.getInteger("price"));
            } else {
                priceEntity.setPrice(-1);
            }
            priceEntities.add(priceEntity);
        }
        userInfo.setPriceEntities(priceEntities);
        return userInfo;
    }

    public TalentUserInfoEntity dealAuthorWithFixError(JSONObject author) {
        TalentUserInfoEntity userInfo = new TalentUserInfoEntity();
        userInfo.setUid(author.getString("core_user_id"));
        userInfo.setGender(author.getInteger("gender"));
        userInfo.setUniqueId(author.getString("unique_id"));
        userInfo.setNickName(author.getString("nick_name"));
        userInfo.setAvatarLink(author.getString("avatar_uri"));
        userInfo.setProvince(author.getString("province"));
        userInfo.setCity(author.getString("city"));

        userInfo.setOther("1");
        userInfo.setAuthorid(author.getString("id"));
        System.out.println("达人id:" + userInfo.getUid());
        userInfo.setFansCount(author.getInteger("follower"));
        JSONObject tags_relation = author.getJSONObject("tags_relation");
        Set<String> keySet = tags_relation.keySet();
        ArrayList<Tag> tags = new ArrayList<>();
        userInfo.setTags(tags);
        JSONArray price_info = author.getJSONArray("price_info");
        ArrayList<PriceEntity> priceEntities = new ArrayList<>();
        userInfo.setPriceEntities(priceEntities);
        userInfo.setXtPrePlayNum(author.getIntValue("expected_play_num"));
        userInfo.setXtOrderCompleteNum(author.getIntValue("order_cnt"));
        userInfo.setXtCpm(author.getFloatValue("expected_cpm"));
        return userInfo;
    }


    public boolean mockLogin(WebDriver driver) throws Exception {
        driver.get("https://star.toutiao.com/");
//        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div[4]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("information")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("wangzichao@YIXIforce.com");
        Thread.sleep(300);
        driver.findElement(By.id("password")).sendKeys("13910073557");
        Thread.sleep(300);
//        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.findElement(By.id("bytedance-SubmitStatic")).click();
        Thread.sleep(2000);
        dealCheckCode();
        Thread.sleep(1000);
        return true;
    }

    /*处理滑动验证码*/
    private void dealCheckCode() throws IOException, InterruptedException {
        WebElement dragBtn = driver.findElement(By.xpath("//*[@id=\"validate-drag-wrapper\"]/div[2]/img"));
        while (dragBtn != null) {
            Thread.sleep(1000);
            BufferedImage bgImage = getImage("//*[@id=\"validate-big\"]");
            int left = getLeft(bgImage);
            System.out.println("left:" + left);
            move(driver, dragBtn, left);
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/index")) {
                return;
            }
            dragBtn = driver.findElement(By.xpath("//*[@id=\"validate-drag-wrapper\"]/div[2]/img"));
//            System.out.println(dragBtn == null);
        }
    }

    private BufferedImage getImage(String xPath) throws IOException {
        WebElement ele = driver.findElement(By.xpath(xPath));
        String url = ele.getAttribute("src");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        BufferedImage fullImg = null;
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            fullImg = ImageIO.read(inputStream);
        }
        return fullImg;
    }

    private static int getLeft(BufferedImage bgimage) {
        int width = bgimage.getWidth();
        int height = bgimage.getHeight();
        for (int i = width / 5; i < width - 2; i++) {
            for (int j = 0; j < height - 8; j++) {
                int rgb = bgimage.getRGB(i, j);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int sum = red + green + blue;
//                System.out.println(rgb +" "+red+" "+green+" "+blue+"  "+sum);
                boolean b = checkPoint(bgimage, i, j);
                if (b) {
                    System.out.println(i + " " + j);
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean checkPoint(BufferedImage bgimage, int i, int j) {
        int rgb = bgimage.getRGB(i, j);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        int temp = 28;
        if (Math.abs(red - green) > temp || Math.abs(red - blue) > temp || Math.abs(blue - green) > temp) {
            return false;
        }
        if (red + green + blue < 50 * 3 || red + green + blue > 210 * 3) {
            return false;
        }

        int mix = 25;
        int all = 0;
        for (int k = 0; k < 7; k++) {
            for (int l = 0; l < 2; l++) {
                int testrgb = bgimage.getRGB(i + l, j + k);
                int testred = (testrgb >> 16) & 0xFF;
                int testgreen = (testrgb >> 8) & 0xFF;
                int testblue = testrgb & 0xFF;
                int flag = 0;
                if (red - mix < testred && testred < red + mix) {
                    flag++;
                }
                if (blue - mix < testblue && testblue < blue + mix) {
                    flag++;
                }
                if (green - mix < testgreen && testgreen < green + mix) {
                    flag++;
                }
                if (flag == 3) {
                    all++;
                }
            }
        }
        if (all >= 11) {
            mix = 60;
            all = 0;
            for (int k = 0; k < 7; k++) {
                int testrgb = bgimage.getRGB(i + 2, j + k);
                int testred = (testrgb >> 16) & 0xFF;
                int testgreen = (testrgb >> 8) & 0xFF;
                int testblue = testrgb & 0xFF;
                int flag = 0;
                if (red - mix > testred || testred > red + mix) {
                    flag++;
                }
                if (blue - mix > testblue || testblue > blue + mix) {
                    flag++;
                }
                if (green - mix > testgreen || testgreen > green + mix) {
                    flag++;
                }
                if (flag > 0) {
                    all++;
                }
            }
            if (all >= 6) {
                return true;
            }
        }
        return false;
    }

    public static void move(WebDriver driver, WebElement element, int distance) throws InterruptedException {
        int xDis = distance;
        System.out.println("应平移距离：" + xDis);
        Actions actions = new Actions(driver);
        new Actions(driver).clickAndHold(element).perform();
        Thread.sleep(200);
        printLocation(element);
        for (int i = 0; i < 5; i++) {
            int temp = (xDis / 5);
            actions.moveByOffset(temp, 1).perform();
            Thread.sleep(200);
            printLocation(element);
        }
//        actions.moveByOffset(xDis, 1).perform();
        printLocation(element);
        Thread.sleep(4000);
        actions.release(element).perform();
    }

    private static void printLocation(WebElement element) {
        Point location = element.getLocation();
        System.out.println(location.getX() + "____" + location.getY());
    }

}
