package com.lida.dy.schedle.liudataset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.schedle.entity.FanChangeEntity;
import com.lida.dy.schedle.entity.VideoEntity;
import com.lida.dy.schedle.linuxSpider.LinuxUtil;
import com.lida.dy.schedle.linuxSpider.MyException;
import com.lida.dy.schedle.linuxSpider.Spider;
import com.lida.dy.schedle.util.SpiderUtil;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataSetSpFromXingtu {
    @Autowired
    DriverUtil driverUtil;
    @Autowired
    Spider spider;
    WebDriver driver;
    Iterable<CSVRecord> csvRecords;
    private int offset = 0;

    public void start(boolean hasUI) {
        driver = driverUtil.createDriver(hasUI);
        try {
            driverUtil.mockLogin(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> ids;
        while ((ids = getNext2()) != null) {
            try {
                for (String id : ids) {
                    Thread.sleep(2000);
                    System.out.println(id+"::"+new Date().toString());
                    String myid = id.split("-")[0];
                    String uid = id.split("-")[1];
                    ArrayList<VideoEntity> videoAndAvg = getVideoAndAvg(myid);
                    JSONArray active = getActive(myid);
                    JSONArray fansChange = getFansChange(myid);
                    save(uid, videoAndAvg, active, fansChange);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (  MyException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<VideoEntity> getVideoAndAvg(String authorid) throws InterruptedException, MyException {
        // todo
        String url = "https://star.toutiao.com/v/api/demand/author_item_data/?author_id=" + authorid + "&platform_source=1&item_cnt=";
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
                ArrayList<VideoEntity> videoEntities = new ArrayList<>();
                for (int i = 0; i < videos.size(); i++) {
                    VideoEntity videoEntity = new VideoEntity();
                    JSONObject video = videos.getJSONObject(i);
                    videoEntity.setCommentNum(video.getInteger("comment"));
                    videoEntity.setPlayNum(video.getInteger("play"));
                    videoEntity.setFavoritedNum(video.getInteger("like"));
                    videoEntity.setWorkerLink(video.getString("url"));
                    videoEntity.setVid(video.getString("url").split("mid=")[1]);
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

    private void save(String uid, ArrayList<VideoEntity> videos, JSONArray active, JSONArray fansChange) {
        float light = 0, mid = 0, high = 0, sum;
        for (int i = 0; i < active.size(); i++) {
            if (active.getJSONObject(i).getString("distribution_key").equals("中度")) {
                mid = active.getJSONObject(i).getFloatValue("distribution_value");
            } else if (active.getJSONObject(i).getString("distribution_key").equals("轻度")) {
                light = active.getJSONObject(i).getFloatValue("distribution_value");
            } else {
                high = active.getJSONObject(i).getFloatValue("distribution_value");
            }
        }
        sum = light + mid + high;
        light = light / sum;
        mid = mid / sum;
        high = high / sum;
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (VideoEntity videoEntity : videos) {
            String createTime = String.valueOf(videoEntity.getCreateTime());
            int fansPoint = getFansPoint(createTime, fansChange);
            ArrayList<String> strings = new ArrayList<>();

            strings.add(uid);
            strings.add(videoEntity.getVid());
            strings.add(String.valueOf(videoEntity.getPlayNum()));
            strings.add(String.valueOf(videoEntity.getCommentNum()));
            strings.add(String.valueOf(videoEntity.getFavoritedNum()));
            strings.add("0");
            strings.add("0");
            strings.add(String.valueOf(videoEntity.getShareNum()));
            strings.add(createTime);
            strings.add("0");
            strings.add(String.valueOf(videoEntity.getDuration()));
            strings.add("0");
            strings.add("0");
            strings.add(fansPoint + "");

            strings.add(((int) (light * fansPoint)) + "");
            strings.add(((int) (mid * fansPoint)) + "");
            strings.add(((int) (high * fansPoint)) + "");
            arrayLists.add(strings);
        }
        CSVUtils.writeCsvFile("D:\\dy\\临时数据\\D2.csv", arrayLists);
    }


    private int getFansPoint(String createTime, JSONArray fansChange) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        long lt = new Long(createTime + "000");
        Date date = new Date(lt);
        String datestr = simpleDateFormat.format(date);
        for (int i = 0; i < fansChange.size(); i++) {
            if (fansChange.getJSONObject(i).getString("date").equals(datestr)) {
                return fansChange.getJSONObject(i).getIntValue("fans_cnt");
            }
        }
        return 0;
    }

    public JSONArray getFansChange(String authorid) {
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String url = "https://star.toutiao.com/v/api/demand/author_daily_fans/?author_id=" + authorid + "&platform_source=1&start_date=2017-12-05&end_date=" + endDate;
        driver.get(url);
        String data = LinuxUtil.cleanHtml(driver.getPageSource());
        JSONObject jsonObject = JSON.parseObject(data);
        if (jsonObject.getString("msg").equals("成功")) {
            ArrayList<FanChangeEntity> fanChangeEntities = new ArrayList<>();
            return jsonObject.getJSONObject("data").getJSONArray("daily");
        }
        return null;
    }

    private JSONObject getByUid(String uid) throws InterruptedException, UnsupportedEncodingException {
        String searchBaseUrl = "https://star.toutiao.com/v/api/demand/author_list/?page=1&limit=20&need_detail=true&only_nick_name=true&platform_source=1&task_category=1&key=";
        String key = URLEncoder.encode(uid, "UTF8");
        String searchURL = searchBaseUrl + key + "&order_by=score";
        Thread.sleep(1000);
        driver.get(searchURL);
        String pageSource = driver.getPageSource();
        pageSource = SpiderUtil.cleanHtml(pageSource);
        JSONObject jsonObject = JSON.parseObject(pageSource);
        if (jsonObject.getInteger("code") == 0) {
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("authors");
            for (int i = 0; i < jsonArray.size(); i++) {
                if (jsonArray.getJSONObject(i).getString("core_user_id").trim().equals(uid.trim())) {
                    System.out.println("ok");
                    return jsonArray.getJSONObject(i);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    private String skipUid = "132204911";
    private boolean addSwitch = false;


    int page = 5;

    public List<String> getNext2() {
        page++;
        String url = "https://star.toutiao.com/v/api/demand/author_list/?page= " + page + "&limit=20&need_detail=true&platform_source=1&task_category=1&price_min=5000&price_max=10000&order_by=score";
        driver.get(url);
        String pageSource = driver.getPageSource();
        pageSource = LinuxUtil.cleanHtml(pageSource);
        JSONObject jsonObject = JSON.parseObject(pageSource);
        if (jsonObject.getInteger("code") == 0) {
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("authors");
            ArrayList<String> ids = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                ids.add(jsonArray.getJSONObject(i).getString("id") + "-" + jsonArray.getJSONObject(i).getString("core_user_id"));
            }
            return ids;
        }
        return null;
    }

    public JSONArray getActive(String authorid) {
        String url = "https://star.toutiao.com/v/api/demand/author_fans_distribution/?author_id=" + authorid + "&scope=0&platform_source=1";
        driver.get(url);
        String pageSource = driver.getPageSource();
        pageSource = SpiderUtil.cleanHtml(pageSource);
        JSONObject jsonObject = JSON.parseObject(pageSource);
        if (jsonObject.getString("msg").equals("成功")) {
            JSONArray data = jsonObject.getJSONArray("data");
            for (int i = 0; i < data.size(); i++) {
                if (data.getJSONObject(i).getString("type_display").trim().startsWith("活跃度")) {
                    return data.getJSONObject(i).getJSONArray("distribution_list");
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        long lt = new Long("1578128811000");
        Date date = new Date(lt);
        System.out.println(simpleDateFormat.format(date));
    }
}
