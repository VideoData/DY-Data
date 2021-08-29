package com.lida.dy.schedle.liudataset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.schedle.entity.FanChangeEntity;
import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import com.lida.dy.schedle.linuxSpider.LinuxUtil;
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
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DataSetSp {
    //    https://star.toutiao.com/v/api/demand/author_list/?page=1&limit=30&need_detail=true&platform_source=1&task_category=1&order_by=score
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
        List<CSVRecord> csvRecords;
        while ((csvRecords = getNext()) != null) {
            try {
                if (csvRecords.size() == 0) {
                    continue;
                }
                String uid = csvRecords.get(0).get(0);
                JSONObject byUid = getByUid(uid);
                if (byUid == null || byUid.size() < 1) {
                    continue;
                }
                TalentUserInfoEntity talentUserInfoEntity1 = spider.dealAuthorWithFixError(byUid);
                JSONArray active = getActive(talentUserInfoEntity1.getAuthorid());
                JSONArray fansChange = getFansChange(talentUserInfoEntity1.getAuthorid());
                save(csvRecords, active, fansChange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    private void save(List<CSVRecord> csvRecords, JSONArray active, JSONArray fansChange) {
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
        for (CSVRecord csvRecord : csvRecords) {
            String createTime = csvRecord.get(8);
            int fansPoint = getFansPoint(createTime, fansChange);
            ArrayList<String> strings = new ArrayList<>();
            for (String s : csvRecord) {
                strings.add(s);
            }
            strings.add(fansPoint + "");

            strings.add(((int) (light * fansPoint)) + "");
            strings.add(((int) (mid * fansPoint)) + "");
            strings.add(((int) (high * fansPoint)) + "");
            arrayLists.add(strings);
        }
        CSVUtils.writeCsvFile("D:\\dy\\临时数据\\B.csv", arrayLists);
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
    private CSVRecord csvRecordtemp;

    public List<CSVRecord> getNext() {
        if (csvRecords == null) {
            csvRecords = CSVUtils.readCsvFile("D:\\dy\\临时数据\\D.csv");
        }
        ArrayList<CSVRecord> myCsvRecords = new ArrayList<>();
        String tempVid2 = null;
        int num = 0;
        if (csvRecordtemp != null) {
            myCsvRecords.add(csvRecordtemp);
        }
        for (CSVRecord csvRecord : csvRecords) {
            if (!addSwitch) {
                System.out.println(num++);
                if (csvRecord.get(0).equals(skipUid)) {
                    addSwitch = true;
                }
            } else {
                if (csvRecord.get(0).equals(skipUid)) {
                    num = 0;
                    continue;
                }
                if (tempVid2 == null) {
                    tempVid2 = csvRecord.get(0);
                }
                if (tempVid2.equals(csvRecord.get(0))) {
                    myCsvRecords.add(csvRecord);
                } else {
                    csvRecordtemp = csvRecord;
                    break;
                }
            }
        }
        System.out.println(num + "批次");
        if (myCsvRecords.size() == 0) {
            return null;
        }
        List<CSVRecord> collect = myCsvRecords.stream().filter(item -> {
            System.out.println(item.get(3));
            return item.get(3) != null && item.get(3).trim().length() > 1;
        }).sorted(Comparator.comparing(item -> {
            return Long.parseLong(item.get(8));
        }, Comparator.reverseOrder())).collect(Collectors.toList());
        return collect;
    }

    int page = 0;

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

    static Set<String> ids = new HashSet<>();

    public static void main(String[] args) throws ParseException {
        DataSetSp dataSetSp = new DataSetSp();
        dataSetSp.addSwitch = true;
        List<CSVRecord> next;
        do {
            next = dataSetSp.getNext();
            if (next.size() <= 15) {
                continue;
            }
            if (ids.add(next.get(0).get(0))) {
                List<CSVRecord> limit = new ArrayList<>();
                for (int i = 0; i < 15; i++) {
                    limit.add(next.get(i));
                }
                CSVUtils.writeCsvFile2("D:\\dy\\临时数据\\D_out.csv", limit);
            }else{
                System.out.println("error:"+next.get(0).get(0));
            }
        } while (next.size() > 1);
    }
}
