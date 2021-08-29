package com.lida.dy.cal.spiderDy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.dao.VideoRepository;
import com.lida.dy.cal.dao.mongo.MComment;
import com.lida.dy.cal.dao.mongo.Reply_comment;
import com.lida.dy.cal.entity.FansUserInfoEntity;
import com.lida.dy.cal.entity.TalentUserInfoEntity;
import com.lida.dy.cal.entity.VideoCommentEntity;
import com.lida.dy.cal.entity.VideoEntity;
import com.lida.dy.cal.interfaces.DYInterface;
import com.lida.dy.cal.spider.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/27 0027 15:15
 * @Version: 1.0
 */
@Component
public class Comment {
    //https://www.iesdouyin.com/share/video/6755392321174506756/?region=CN&amp;mid=6755335139531918088
    @Autowired
    CommentService commentService;
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    DYInterface dyInterface;
    static int cursor = 0;
    static int totalComment = 0;
    static boolean hasmore = true;

    public void start(TalentUserInfoEntity talentUserInfoEntity) throws IOException {
        List<VideoEntity> allByUserInfoId = videoRepository.findAllByUserInfoId(talentUserInfoEntity.getId());
        for (VideoEntity videoEntity : allByUserInfoId) {
            start(videoEntity, talentUserInfoEntity);
        }
    }

    private int nullTimes = 0;

    public void start(VideoEntity videoEntity, TalentUserInfoEntity talentUserInfoEntity) throws IOException {
        cursor = 0;
        System.out.println(videoEntity.getVideoTitle() + ": " + videoEntity.getDescription());
        hasmore = true;
        int realTotalComment = 0;
        do {
            String s = getHttpComment(videoEntity.getVid(), cursor);
            if (s.equals("1")) {
                cursor = 0;
                break;
            }
            ArrayList<MComment> mComments;
            try {
                mComments = parseMComment(s);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                break;
            }
            if (mComments.size() == 0) {
                nullTimes++;
                if (nullTimes > 15) {
                    throw new RuntimeException("获取评论数据为空次数太多");
                }
            }
            realTotalComment += mComments.size();
            for (MComment mComment : mComments) {
                mComment.setMy_video_id(videoEntity.getId());
            }
            commentService.saveVideoMCommentEntity(mComments, videoEntity.getId(), talentUserInfoEntity.getId());
        } while (hasmore);
        System.out.println("数量： " + cursor + " total:" + totalComment + " real total comment:" + realTotalComment);
        cursor = 0;
        totalComment = 0;
        videoEntity.setExtren("1");
    }

    private static int faileTimes = 0;
    private String tempVid = "";

    private String getHttpComment(String vid, int cursor) {
        tempVid = vid;
        faileTimes++;
        String myComment = dyInterface.getMyComment(vid, cursor + "");
        if (myComment.equals("false")) {
            if (cursor > 400) {
                return "1";
            }
            if (faileTimes > 4) {
                faileTimes = 0;
                return "1";
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            faileTimes++;
            return getHttpComment(vid, cursor);
        }
        faileTimes = 0;
        return myComment;
    }

    private ArrayList<MComment> parseMComment(String s) {
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println("test total comment:" + jsonObject.getString("total"));
        ArrayList<MComment> mComments = new ArrayList<>();
        if (jsonObject.getInteger("status_code") == 0) {
            cursor = jsonObject.getIntValue("cursor");
            totalComment = jsonObject.getIntValue("total");
            hasmore = jsonObject.getIntValue("has_more") == 0 ? false : true;
            JSONArray commentsJSONArray = jsonObject.getJSONArray("comments");
            for (int i = 0; i < commentsJSONArray.size(); i++) {
                MComment comment = commentsJSONArray.getObject(i, MComment.class);
                String userId = commentsJSONArray.getJSONObject(i).getJSONObject("user").getString("uid");
                Integer fid = commentService.getFansUserinfoId(userId);
                if (fid > -1) {
                    comment.setMy_user_id(fid);
                } else {
                    String serUserId = commentsJSONArray.getJSONObject(i).getJSONObject("user").getString("sec_uid");

                    FansUserInfoEntity fansUserInfoEntity = dealFansUserInfo(userId, serUserId);
                    comment.setMy_user_id(commentService.saveFansUserInfoEntity(fansUserInfoEntity));
                }
                if (comment.getReply_comment_total() > 0 && !tempVid.equals("")) {
                    dealReply(comment, tempVid);
                }
                mComments.add(comment);
            }

        }
        return mComments;
    }

    /**
     * 处理回复
     *
     * @param comment
     * @param tempVid
     */
    private void dealReply(MComment comment, String tempVid) {
        String cursor = "0";
        int hasMore = 1;
        ArrayList<Reply_comment> reply_comments = new ArrayList<>();
        do {
            String response = dyInterface.searchReply(comment.getCid(), tempVid, cursor, 20);
            JSONObject jsonObject = JSONObject.parseObject(response);
            hasMore = jsonObject.getIntValue("has_more");
            cursor = jsonObject.getString("cursor");
            JSONArray comments = jsonObject.getJSONArray("comments");

            for (int i = 0; i < comments.size(); i++) {
                Reply_comment replyComment = comments.getObject(i, Reply_comment.class);
                String userId = replyComment.getUser().getUid();
                Integer fid = commentService.getFansUserinfoId(userId);
                if (fid > -1) {
                    replyComment.setMy_user_id(fid);
                } else {
                    String serUserId = replyComment.getUser().getSec_uid();

                    FansUserInfoEntity fansUserInfoEntity = dealFansUserInfo(userId, serUserId);
                    replyComment.setMy_user_id(commentService.saveFansUserInfoEntity(fansUserInfoEntity));
                }
                reply_comments.add(replyComment);
            }
        } while (hasMore == 1);
        comment.setReply_comment(reply_comments);
    }


    private List<VideoCommentEntity> parseComment(String s) {
        List<VideoCommentEntity> videoCommentEntities = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (jsonObject.getInteger("status_code") == 0) {
            cursor = jsonObject.getInteger("cursor");
            totalComment = jsonObject.getInteger("total");
            JSONArray array = jsonObject.getJSONArray("comments");
            if (array == null || array.size() == 0) {
                return null;
            }
            for (int i = 0; i < array.size(); i++) {
                VideoCommentEntity entity = new VideoCommentEntity();
                JSONObject commentObject = array.getJSONObject(i);
                entity.setCid(commentObject.getString("cid"));
                entity.setCreateTime(commentObject.getLong("create_time"));
                entity.setText(commentObject.getString("text"));
                entity.setDiggCount(commentObject.getInteger("digg_count"));
                entity.setReplyCommentTotal(commentObject.getInteger("reply_comment_total"));
                String fansUid = commentObject.getJSONObject("user").getString("uid");
                Integer fid = commentService.getFansUserinfoId(fansUid);
                if (fid > -1) {
                    entity.setUid(fid);
                } else {
                    String userId = commentObject.getJSONObject("user").getString("uid");
                    String serUserId = commentObject.getJSONObject("user").getString("sec_uid");
                    FansUserInfoEntity fansUserInfoEntity = dealFansUserInfo(userId, serUserId);
                    try {
                        entity.setUid(commentService.saveFansUserInfoEntity(fansUserInfoEntity));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                JSONArray reply_comment = commentObject.getJSONArray("reply_comment");
                if (reply_comment != null && reply_comment.size() > 0) {
                    parseReplyComment(reply_comment, entity);
                }
                videoCommentEntities.add(entity);
            }
        }
        return videoCommentEntities;
    }

    private FansUserInfoEntity dealFansUserInfo(String userId, String serUserId) {
        try {
            String resutlStr = dyInterface.getFansUserInfo(userId, serUserId);
            if (resutlStr != null) {
                return parseFansUserInfo(resutlStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //解析
    private FansUserInfoEntity parseFansUserInfo(String resutlStr) {
        JSONObject jsonObject = JSONObject.parseObject(resutlStr);
        if (jsonObject.getInteger("status_code") == 0) {
            FansUserInfoEntity fansUserInfoEntity = new FansUserInfoEntity();
            JSONObject user = jsonObject.getJSONObject("user");
            fansUserInfoEntity.setGender(user.getInteger("gender"));
            fansUserInfoEntity.setNickName(user.getString("nickname"));
            fansUserInfoEntity.setSignature(user.getString("signature"));
            fansUserInfoEntity.setAwemeCount(user.getInteger("aweme_count"));
            fansUserInfoEntity.setFollowerCount(user.getInteger("follower_count"));
            fansUserInfoEntity.setFavoritingCount(user.getInteger("favoriting_count"));
            fansUserInfoEntity.setTotalFavorited(user.getInteger("total_favorited"));
            fansUserInfoEntity.setDyNum(user.getString("unique_id"));
            fansUserInfoEntity.setBirthday(user.getDate("birthday"));
            fansUserInfoEntity.setUid(user.getString("uid"));
            String avatar = null;
            for (String s : user.keySet()) {
                if (s.startsWith("avatar")) {
                    avatar = user.getJSONObject(s).getString("url_list");
                    break;
                }
            }
            if (avatar != null) {
                avatar = avatar.replace("[\"", "");
                fansUserInfoEntity.setAvatarHref(avatar.split("\",")[0]);
            }

            fansUserInfoEntity.setFollowingCount(user.getInteger("following_count"));
            fansUserInfoEntity.setTotalDynaicNum(user.getInteger("dongtai_count"));
            fansUserInfoEntity.setProvince(user.getString("province"));
            fansUserInfoEntity.setCity(user.getString("city"));
            return fansUserInfoEntity;
        }
        return null;

    }


    /**
     * 解析评论的回复
     *
     * @param reply_comment
     * @param videoCommentEntity
     */
    private void parseReplyComment(JSONArray reply_comment, VideoCommentEntity videoCommentEntity) {
        ArrayList<VideoCommentEntity> replyCommentRntities = new ArrayList<>();
        for (int i = 0; i < reply_comment.size(); i++) {
            VideoCommentEntity entity = new VideoCommentEntity();
            JSONObject commentObject = reply_comment.getJSONObject(i);
            entity.setCreateTime(commentObject.getLong("create_time"));
            entity.setText(commentObject.getString("text"));
            entity.setDiggCount(commentObject.getInteger("digg_count"));
            entity.setReplyCommentTotal(commentObject.getInteger("reply_comment_total"));
            entity.setCid(commentObject.getString("cid"));
            String fansUid = commentObject.getJSONObject("user").getString("uid");
            Integer fid = commentService.getFansUserinfoId(fansUid);
            if (fid > -1) {
                entity.setUid(fid);
            } else {
                String userId = commentObject.getJSONObject("user").getString("uid");
                String serUserId = commentObject.getJSONObject("user").getString("sec_uid");
                FansUserInfoEntity fansUserInfoEntity = dealFansUserInfo(userId, serUserId);
                entity.setUid(commentService.saveFansUserInfoEntity(fansUserInfoEntity));
            }
            replyCommentRntities.add(entity);
        }
        videoCommentEntity.setReplys(replyCommentRntities);
    }

    public static void main(String[] args) throws IOException {
        Comment comment = new Comment();
        comment.test();

    }


    public void test() {
        String url = "http://localhost:8081/commentDetail?aweme_id=6773059657956117768&cursor=0";
        String s = HttpClientUtil.get(url);
        if (s.equals("1")) {
            cursor = 0;
//            break;
        }
        ArrayList<MComment> mComments = null;
        try {
            mComments = parseMComment(s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
//            break;
        }
        if (mComments.size() == 0) {
            nullTimes++;
            if (nullTimes > 15) {
                throw new RuntimeException("获取评论数据为空次数太多");
            }
        }
    }
}
