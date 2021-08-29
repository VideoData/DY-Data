package com.lida.dy.cal.spiderDy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.dao.TalentUserRepository;
import com.lida.dy.cal.entity.TalentUserInfoEntity;
import com.lida.dy.cal.entity.VideoEntity;
import com.lida.dy.cal.interfaces.DYInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 爬取抖音详细数据
 * @Auther: lida
 * @Description:
 * @Date 2020/3/27 0027 16:27
 * @Version: 1.0
 */
@Component
public class Video {
    @Value("${my.skip}")
    private int skip = 0;

    @Autowired
    CommentService commentService;
    @Autowired
    Comment comment;
    @Autowired
    DYInterface dyInterface;
    @Autowired
    TalentUserRepository talentUserRepository;
    private String maxCursor = "";
    private int myskip = 0;
    public void start() throws IOException {
        dyInterface.init();
        for (; ; ) {
            List<TalentUserInfoEntity> talentUserInfoEntities = commentService.getNextTalent();
            if (talentUserInfoEntities == null || talentUserInfoEntities.size() < 2) {
                return;
            }

            System.out.println(Utils.getNowDate()+":"+talentUserInfoEntities.size()+"sf");
            for (TalentUserInfoEntity talentUserInfoEntity : talentUserInfoEntities) {

                try {
                    System.out.println("达人昵称：" + talentUserInfoEntity.getNickName()+"uid :"+talentUserInfoEntity.getUid());

                    updateTalentUserInfoEntity(talentUserInfoEntity);
                    List<VideoEntity> videoEntities = getAllVideo(talentUserInfoEntity.getUid());
                    for (VideoEntity videoEntity : videoEntities) {
                        videoEntity.setUserInfoId(talentUserInfoEntity.getId());
                        videoEntity.setUid(talentUserInfoEntity.getUid());
                    }
                    videoEntities = commentService.saveVideo(videoEntities);
                    int index = 0;
                    for (VideoEntity videoEntity : videoEntities) {
                        if(skip>0){
                            System.out.println("略过视频数量："+skip);
                            skip--;
                            continue;
                        }
                        index++;
                        System.out.println(Utils.getNowDate()+":"+index+"视频标题：" + videoEntity.getVideoTitle());
//                        comment.start(videoEntity, talentUserInfoEntity);
                    }
//                    comment.start(talentUserInfoEntity);
                    talentUserInfoEntity.setOther("3");
                    System.out.println(Utils.getNowDate()+":"+"存入：" + talentUserInfoEntity.getNickName());
                    talentUserRepository.save(talentUserInfoEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    System.out.println("评论数量a：" + commentService.commentNum);

                    System.out.println(e.getMessage());
                    if (e instanceof RuntimeException) {
                        return;
                    }
                    if(commentService.commentNum>1000){
                        talentUserInfoEntity.setOther("3");
                        System.out.println(getDate()+"存入：" + talentUserInfoEntity.getNickName());
                        talentUserRepository.save(talentUserInfoEntity);
                    }
                    commentService.commentNum = 0;

                }
            }

        }
    }
    public String getDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
    /**
     * 根据抖音扒一些大人的数据
     *
     * @param talentUserInfoEntity
     * @return
     */
    private void updateTalentUserInfoEntity(TalentUserInfoEntity talentUserInfoEntity) throws IOException {
        String s = dyInterface.getTalentUserInfo(talentUserInfoEntity.getUid());
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (jsonObject.getInteger("status_code") == 0) {
            JSONObject user = jsonObject.getJSONObject("user");
            if(user.size()>0) {
                talentUserInfoEntity.setCity(user.getString("city"));
                talentUserInfoEntity.setGender(user.getIntValue("gender"));
                talentUserInfoEntity.setProvince(user.getString("province"));
                talentUserInfoEntity.setTotalLike(user.getInteger("total_favorited"));
                talentUserInfoEntity.setFansCount(user.getInteger("follower_count"));
                talentUserInfoEntity.setTotalDynaicNum(user.getInteger("dongtai_count"));
                talentUserInfoEntity.setSignature(user.getString("signature"));
                talentUserInfoEntity.setVideoCount(user.getInteger("aweme_count"));
                talentUserInfoEntity.setBirthday(user.getDate("birthday"));
                talentUserInfoEntity.setFavoritingCount(user.getInteger("favoriting_count"));
                talentUserInfoEntity.setFocusCount(user.getIntValue("following_count"));
            }
        }
        talentUserInfoEntity.setDatafrom("cal:video");
        talentUserInfoEntity =   talentUserRepository.save(talentUserInfoEntity);
    }

    private List<VideoEntity> getAllVideo(String uid) {
        boolean isFirstStep = true;
        HashMap<String, VideoEntity> map = new HashMap<>();
        for (; ; ) {
            String s = null;
            try {
                s = getHttpVideo(isFirstStep,uid,maxCursor,"0");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                s = "1";
            }
            if (s.equals("1")) {
                break;
            }

            List<VideoEntity> videoEntities = parseVideo(s);
            for (VideoEntity videoEntity : videoEntities) {
                map.put(videoEntity.getVid(), videoEntity);
            }
            JSONObject jsonObject = JSONObject.parseObject(s);
            maxCursor = jsonObject.getString("max_cursor");
            isFirstStep = false;
            if (jsonObject.getInteger("has_more") == 0) {
                break;
            }
        }
        maxCursor = "0";
        Collection<VideoEntity> values = map.values();
        ArrayList<VideoEntity> videoEntities = new ArrayList<>();
        for (VideoEntity value : values) {
            videoEntities.add(value);
        }
        return videoEntities;
    }
    private String getHttpVideo(boolean isFirstStep, String uid, String maxCursor, String minCursor) throws IOException {
        String video_list = dyInterface.get_video_list(isFirstStep == true ? 0 : 1, uid, maxCursor, minCursor);
        if(video_list.equals("false")){
            return "1";
        }
        return video_list;
    }
    public String nowTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    private List<VideoEntity> parseVideo(String s) {
        List<VideoEntity> videoEntities = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (jsonObject.getInteger("status_code") == 0) {
            JSONArray array = jsonObject.getJSONArray("aweme_list");
            for (int i = 0; i < array.size(); i++) {
                VideoEntity entity = new VideoEntity();
                JSONObject videoObject = array.getJSONObject(i);
                entity.setVid(videoObject.getString("aweme_id"));
                entity.setWorkerLink(videoObject.getString("share_url"));
                entity.setUid(videoObject.getJSONObject("author").getString("short_id"));
                entity.setCreateTime(videoObject.getLong("create_time"));
                entity.setVideoTitle(videoObject.getString("desc"));
                entity.setDescription(videoObject.getString("desc"));
                entity.setDuration(videoObject.getInteger("duration"));
                JSONObject statistics = videoObject.getJSONObject("statistics");
                entity.setPlayNum(statistics.getInteger("play_count"));
                entity.setFavoritedNum(statistics.getInteger("digg_count"));
                entity.setShareNum(statistics.getInteger("share_count"));
                entity.setDownloadCount(statistics.getInteger("download_count"));
                entity.setCommentNum(statistics.getInteger("comment_count"));
                entity.setForwardCount(statistics.getInteger("forward_count"));
                videoEntities.add(entity);
            }
        }
        return videoEntities;
    }
}
