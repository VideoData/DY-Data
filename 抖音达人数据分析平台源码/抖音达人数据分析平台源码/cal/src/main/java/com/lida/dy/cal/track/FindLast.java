package com.lida.dy.cal.track;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.interfaces.DYInterface2;
import com.lida.dy.cal.interfaces.WebDyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class FindLast {
    @Autowired
    DYInterface2 dyInterface2;
    @Autowired
    WebDyInterface webDyInterface;
    @Autowired
    TrackMinute trackMinute;
    private int videoNum = 40;

    public void findLastVideo(int addnewNum) {
        videoNum = addnewNum - trackMinute.ids.size();
        while (videoNum > 0) {
            try {
                String fansUserInfo = dyInterface2.getLastVideo();
                ArrayList<String> urls = dyInterface2.dealUrl(fansUserInfo);
                checkPerUrl(urls);
//                checkPerUrlWithWEB(urls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int checkPerUrlNum = 0;

    private void checkPerUrl(ArrayList<String> urls) throws IOException, InterruptedException {
//        Thread.sleep(50_000);
        for (String url : urls) {
            Thread.sleep(5_000);
            String s = webDyInterface.getByUrl(url, true);
            System.out.println(s.length());
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONArray("item_list").getJSONObject(0);
            checkPerUrlNum++;

            String uid = jsonObject.getJSONObject("author").getString("uid");
            String short_id = jsonObject.getJSONObject("author").getString("short_id");
            String aweme_id = jsonObject.getString("aweme_id");
            ArrayList<String> video = new ArrayList<>();
            String videos = dyInterface2.getVideos(uid);
            if (dealVideosWithCheck(videos, video, aweme_id)) {
                String talent = dyInterface2.getTalent(uid);
                String create_time = video.get(video.size() - 1);
                String secuid = dealTalent(talent, video);
                CSVUtils.writeCsvFile(trackMinute.resultCsvFile, video);
                trackMinute.ids.add(uid + "-" + aweme_id + "-" + short_id + "-" + create_time);
                trackMinute.addVidToFile(uid + "-" + aweme_id + "-" + short_id + "-" + create_time);
                videoNum--;
            }
        }
    }
    public String dealTalent(String talent, ArrayList<String> video) {
        JSONObject user = JSONObject.parseObject(talent).getJSONObject("user");
        video.add(user.getString("mplatform_followers_count"));
        video.add(user.getString("total_favorited"));   //总赞
        return user.getString("sec_uid");
    }
    private boolean dealVideosWithCheck(String videos, ArrayList<String> video, String aweme_id) {
        JSONArray aweme_list = JSONObject.parseObject(videos).getJSONArray("aweme_list");
        for (int i = 0; i < aweme_list.size(); i++) {
            JSONObject jsonObject = aweme_list.getJSONObject(i);
            int create_time = jsonObject.getIntValue("create_time");
            int now = (int) (System.currentTimeMillis() / 1000);
            System.out.println(checkPerUrlNum + "次， 大人界面: now:" + now + "create_time:" + create_time + " 差：" + (now - create_time) + "  :" + (now - create_time < 300));
            if (now - create_time < 600) {
                video.add(jsonObject.getString("create_time"));
                video.add((int) (System.currentTimeMillis() / 1000) + "");
                video.add(jsonObject.getJSONObject("author").getString("uid"));
                video.add(jsonObject.getString("aweme_id"));
                video.add(jsonObject.getString("duration"));
                video.add(jsonObject.getString("rate"));
                video.add(jsonObject.getJSONObject("statistics").getString("comment_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("digg_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("download_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("share_count"));
                video.add(jsonObject.getJSONObject("statistics").getString("forward_count"));
                return true;
            }
        }
        return false;
    }
}
