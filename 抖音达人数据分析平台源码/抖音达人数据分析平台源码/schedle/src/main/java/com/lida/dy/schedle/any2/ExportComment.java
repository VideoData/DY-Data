package com.lida.dy.schedle.any2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.schedle.dao.TalentUserRepository;
import com.lida.dy.schedle.dao.VideoRepository;
import com.lida.dy.schedle.dao.mongo.MComment;
import com.lida.dy.schedle.dao.mongo.MCommentRepositry;
import com.lida.dy.schedle.dao.mongo.Reply_comment;
import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import com.lida.dy.schedle.entity.VideoEntity;
import com.lida.dy.schedle.linuxSpider.LinuxUtil;
import com.lida.dy.schedle.linuxSpider.MyException;
import com.lida.dy.schedle.linuxSpider.Spider;
import com.lida.dy.schedle.util.SpiderUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 *  从mongodb中导出评论
 */
@Component
public class ExportComment {
    @Autowired
    MCommentRepositry mCommentRepositry;
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    Spider spider;
    private String path = "D:\\dy\\临时数据2\\commentOut4.txt";
    private WebDriver driver;
    private String tempNickName = "";

    public void test() {
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<MComment> pageMComment = mCommentRepositry.findByMyVideoIds(82502, pageRequest);
        System.out.println(pageMComment.getContent().size());
    }

    private int num = 0;

    public void  start(WebDriver driver) {
        this.driver = driver;
        init();
        int page = -1;
        Page<MComment> pageMComment;
        String path1 = "D:\\dy\\临时数据2\\dy.resultset2.json";
        List<Integer> videoIds2 = getVideoIds(path1);
        String path2 = "D:\\dy\\临时数据2\\dy.resultset4.json";
        List<Integer> videoIds = getVideoIds(path2);
        for (Integer integer : videoIds2) {
            videoIds.remove(integer);
        }
        int skip = 3070;
        boolean tempFlag = false;
        for (Integer videoId : videoIds) {
            if (skip > 0) {
                skip--;
                continue;
            }
            VideoEntity videoEntity = videoRepository.findById(videoId).get();
            if(videoEntity.getVideoTitle().contains("家人永远是你的避风港。#抖音车王争霸赛")){
                tempFlag = true;
                continue;
            }
            if(!tempFlag){
                continue;
            }
            TalentUserInfoEntity talentUserInfoEntity = talentUserRepository.findById(videoEntity.getUserInfoId()).get();
            //////////////// 播放量入库
            System.out.println(LinuxUtil.getNowDate() + videoEntity.getVideoTitle());
            System.out.println(num);
            num++;
            int playcount;
            if (videoEntity.getPlayNum() < 1) {
                playcount = dealSearch2(talentUserInfoEntity.getNickName(), videoEntity.getVideoTitle());
                if (playcount > 0) {
                    System.out.println("success:" + videoEntity.getVideoTitle());
                    videoEntity.setPlayNum(playcount);
                    videoRepository.save(videoEntity);
                }
            } else {
                playcount = videoEntity.getPlayNum();
            }
            //////////////////
            if (playcount > 0) {
                System.out.println("===========playcount：" + playcount);
                write("title:" + videoEntity.getVideoTitle() + " playnum:" + playcount + "\n");
                System.out.println(videoEntity.getVideoTitle());
                page = -1;
                int replysNum = 0;
                do {
                    page++;
                    PageRequest pageRequest = PageRequest.of(page, 1000);
                    pageMComment = mCommentRepositry.findByMyVideoIds(videoId, pageRequest);
                    StringBuilder sb = new StringBuilder();
                    for (MComment mComment : pageMComment.getContent()) {
                        replysNum += mComment.getReply_comment_total();
                        sb.append("-:" + mComment.getText() + "\n");
                        if (mComment.getReply_comment() != null && mComment.getReply_comment().size() > 0) {
                            for (Reply_comment reply_comment : mComment.getReply_comment()) {
                                sb.append(reply_comment.getText() + "\n");
                            }
                        }
                    }
                    System.out.println(pageMComment.getContent().size() + "條");
                    write(sb.toString());
                } while (pageMComment.hasNext());
                write("replysNum:" + replysNum + "\n");
                page = -1;
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    JSONArray videos;

    private int dealSearch2(String name, String videoTitle) {
        if (name.equals(tempNickName)) {
            return find(videos, videoTitle);
        }
        tempNickName = name;
        JSONObject author = null;
        try {
            author = getByNickname(name);
            if (author != null) {
                String id = author.getString("id");
                return getVideoAndAvg(id, videoTitle);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException | MyException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getVideoAndAvg(String authorid, String videoTitle) throws InterruptedException, MyException {
        String url = "https://star.toutiao.com/v/api/demand/author_item_data/?author_id=" + authorid + "&platform_source=1&item_cnt=";
        String lasturl;
        int num = 50;
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
                videos = jsonObject.getJSONObject("data").getJSONArray("ltm_item_statics");
                return find(videos, videoTitle);
            }
        }
        if (num <= 3) {
            return -1;
        }
        return -1;
    }

    private int find(JSONArray videos, String videoTitle) {
        for (int i = 0; i < videos.size(); i++) {
            JSONObject video = videos.getJSONObject(i);
            String item_title = video.getString("item_title");
//            System.out.println("videoTitle" + videoTitle + "----item_title" + item_title);
            if (item_title.equals(videoTitle)) {
                System.out.println("======================");
                System.out.println("======================");
                System.out.println("======================");
                System.out.println("======================");
                return video.getInteger("play");
            }
        }
        return -1;
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
                if (jsonArray.getJSONObject(i).getString("nick_name").equals(name)) {
                    System.out.println("ok");
                    return jsonArray.getJSONObject(i);
                }
                if (i == jsonArray.size() - 1) {
                    System.out.println("error : " + name);
                }
            }
        }
        return null;
    }

    BufferedWriter writer;

    public void init() {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String s) {
        try {

            writer.write(s);
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getVideoIds(String path) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            ArrayList<Integer> integers = new ArrayList<>();
            while (reader.ready()) {
                integers.add(Integer.parseInt(reader.readLine()));
            }
            reader.close();
            return integers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
