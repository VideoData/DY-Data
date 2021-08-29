package com.lida.dy.cal.track;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.interfaces.DYInterface2;
import com.lida.dy.cal.interfaces.WEBSpiderDy;
import com.lida.dy.cal.interfaces.WebDyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时启动追踪视频数据变化
 */
@Component
public class TrackMinute {
    @Autowired
    WebDyInterface webDyInterface;
    @Autowired
    DYInterface2 dyInterface2;
    //    @Autowired
//    PythonDyInterface pythonDyInterface;
    @Autowired
    FindLast findLast;
    @Value("${my.isaddnew}")
    private boolean isaddnew;
    @Value("${my.addnewNum}")
    private int addnewNum;
    public CopyOnWriteArrayList<String> ids = new CopyOnWriteArrayList<>();
    @Value("${my.trackvid}")
    public String tempVidFile = "C:/Users/Administrator/Desktop/抖音临时/爬取每30s追踪/vid7.txt";
    @Value("${my.trackvideo}")
    public String resultCsvFile = "C:/Users/Administrator/Desktop/抖音临时/爬取每30s追踪/testtxt";

    public void start() {
        System.out.println(tempVidFile);
        System.out.println(resultCsvFile);
        readIds();
        webDyInterface.init();
        long timeInterval = 70_000;
        AtomicInteger times = new AtomicInteger();
        //创建定时器
        new Thread(() -> {
            while (true) {
                times.getAndIncrement();
                new Thread(() -> {
                    System.out.println("定时启动");
//                    startSpiderTime();
                    try {
                        startSpiderTimeWithWEB();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }, "startSpiderTime:" + times).start();
                try {
                    Thread.sleep(timeInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        if (isaddnew) {
            findLast.findLastVideo(addnewNum);
        }
    }

    public void startSpiderTimeWithWEB() throws InterruptedException {
        if (ids.size() < 1) {
            return;
        }
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (String id : ids) {
            Thread.sleep(10_000);
            startSpiderTimePerNum++;
            System.out.println("startSpiderTimePerNum次数:" + startSpiderTimePerNum + "  id:" + id);
            try {
                ArrayList<String> video = dealVideoObjectWithWeb(id);
                if (video != null) {
                    arrayLists.add(video);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        CSVUtils.writeCsvFile(resultCsvFile, arrayLists);
    }

    public ArrayList<String> dealVideoObjectWithWeb(String id) {
        String uid = id.split("-")[0];
        String aweme_id = id.split("-")[1];
        String short_id = id.split("-")[2];
        String create_time = id.split("-")[3];
        ArrayList<String> video = new ArrayList<>();
        video.add(create_time);
        video.add((int) (System.currentTimeMillis() / 1000) + "");
//        JSONArray videosJson = webDyInterface.getVideo(uid, short_id);
//        if (videosJson == null) {
//            return null;
//        }
        if (dealVideosWithCheck2(video, aweme_id)) {
            String talent = webDyInterface.getTalent(uid);
            WEBSpiderDy.dealTalentWithWeb(talent, video);
            return video;
        }
        return null;
    }

    public boolean dealVideosWithCheck(JSONArray videosJson, ArrayList<String> video, String aweme_id) {
        for (int i = 0; i < videosJson.size(); i++) {
            JSONObject jsonObject = videosJson.getJSONObject(i);
            String myaweme_id = jsonObject.getString("aweme_id");
            if (myaweme_id.equals(aweme_id)) {
                video.add(jsonObject.getJSONObject("author").getString("uid"));
                video.add(jsonObject.getString("aweme_id"));
                video.add(jsonObject.getJSONObject("video").getString("duration"));
                video.add(jsonObject.getString("rate"));
                video.add(jsonObject.getJSONObject("statistics").getString("comment_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("digg_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("download_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("share_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("forward_count"));
//                video.add((int) (System.currentTimeMillis() / 1000) + "");
                return true;
            }
        }
        return false;
    }

    public boolean dealVideosWithCheck2(ArrayList<String> video, String aweme_id) {
        String url = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=" + aweme_id + "&dytk=8e6d5332f47b8fdc54c7bb9efef490d5f2e6747193f1473b788e8f1f1b38b341";
        String byUrl = webDyInterface.getByUrl(url, true);
        JSONObject jsonObject1 = JSONObject.parseObject(byUrl);
        JSONObject jsonObject = jsonObject1.getJSONArray("item_list").getJSONObject(0);
        String myaweme_id = jsonObject.getString("aweme_id");
        if (myaweme_id.equals(aweme_id)) {
            video.add(jsonObject.getJSONObject("author").getString("uid"));
            video.add(jsonObject.getString("aweme_id"));
            video.add(jsonObject.getJSONObject("video").getString("duration"));
            video.add(jsonObject.getString("rate"));
            video.add(jsonObject.getJSONObject("statistics").getString("comment_count"));
            video.add(jsonObject.getJSONObject("statistics").getString("digg_count"));
            video.add(jsonObject.getJSONObject("statistics").getString("download_count"));
            video.add(jsonObject.getJSONObject("statistics").getString("share_count"));
            video.add(jsonObject.getJSONObject("statistics").getString("forward_count"));
            return true;
        }
        return false;
    }

    public void readIds() {
        try {
            File file = new File(tempVidFile);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(tempVidFile))));
                while (bufferedReader.ready()) {
                    ids.add(bufferedReader.readLine());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:/Users/Administrator/Desktop/抖音临时/爬取每30s追踪/vid.txt"))));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
    }

    public int startSpiderTimePerNum = 0;

    public void startSpiderTime() {
        if (ids.size() < 1) {
            return;
        }
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (String id : ids) {
            startSpiderTimePerNum++;
            System.out.println("startSpiderTimePerNum次数:" + startSpiderTimePerNum + "  id:" + id);
            String uid = id.split("-")[0];
            String aweme_id = id.split("-")[1];
            try {
                ArrayList<String> video = dealVideoObject(uid, aweme_id);
                arrayLists.add(video);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        CSVUtils.writeCsvFile(resultCsvFile, arrayLists);
    }

    public void videoJson2List(ArrayList<String> video, JSONObject jsonObject, JSONObject author, String uid, String aweme_id2, String duration, String rate, JSONObject statistics, String comment_count, String digg_count, String download_count) {
        video.add(author.getString(uid));
        video.add(jsonObject.getString(aweme_id2));
        video.add(jsonObject.getString(duration));
        video.add(jsonObject.getString(rate));
        video.add(statistics.getString(comment_count));
        video.add(jsonObject.getJSONObject("statistics").getString(digg_count));
        video.add(jsonObject.getJSONObject("statistics").getString(download_count));
        video.add(jsonObject.getJSONObject("statistics").getString("share_count"));
        video.add(jsonObject.getJSONObject("statistics").getString("forward_count"));
        video.add((int) (System.currentTimeMillis() / 1000) + "");
    }

    public ArrayList<String> dealVideoObject(String uid, String aweme_id) throws IOException {
        ArrayList<String> video = new ArrayList<>();
        String talent = dyInterface2.getTalent(uid);
        String secuid = dealTalent(talent, video);
        String videos = dyInterface2.getVideos(secuid.trim());
        dealVideos(videos, video, aweme_id);
        return video;
    }

    public void dealVideos(String videos, ArrayList<String> video, String aweme_id) {
        JSONArray aweme_list = JSONObject.parseObject(videos).getJSONArray("aweme_list");
        for (int i = 0; i < aweme_list.size(); i++) {
            JSONObject jsonObject = aweme_list.getJSONObject(i);
            if (jsonObject.getString("aweme_id").equals(aweme_id)) {
                video.add(jsonObject.getJSONObject("author").getString("uid"));
                videoJson2List(video, jsonObject, jsonObject, "aweme_id", "duration", "create_time", "rate", jsonObject.getJSONObject("statistics"), "comment_count", "digg_count", "download_count");
                break;
            }
        }
    }

    public String dealTalent(String talent, ArrayList<String> video) {
        JSONObject user = JSONObject.parseObject(talent).getJSONObject("user");
        video.add(user.getString("mplatform_followers_count"));
        video.add(user.getString("total_favorited"));   //总赞
        return user.getString("sec_uid");
    }

    public void addVidToFile(String s) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(tempVidFile), true)));
            writer.write(s);
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
