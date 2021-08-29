package com.lida.dy.cal.spiderDy;

import com.lida.dy.cal.dao.FansUserInfoRepositiory;
import com.lida.dy.cal.dao.TalentUserRepository;
import com.lida.dy.cal.dao.VideoCommentRepository;
import com.lida.dy.cal.dao.VideoRepository;
import com.lida.dy.cal.dao.mongo.MComment;
import com.lida.dy.cal.dao.mongo.MCommentRepositry;
import com.lida.dy.cal.entity.FansUserInfoEntity;
import com.lida.dy.cal.entity.TalentUserInfoEntity;
import com.lida.dy.cal.entity.VideoCommentEntity;
import com.lida.dy.cal.entity.VideoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/27 0027 15:55
 * @Version: 1.0
 */
@Component
public class CommentService {
    @Autowired
    FansUserInfoRepositiory fansUserInfoRepositiory;
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    VideoCommentRepository videoCommentRepository;
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    MCommentRepositry mCommentRepositry;
    @Autowired
    MongoService mongoService;
    private int page = 0;
    public int commentNum = 0;

    /**
     * 查找数据库是否存在该粉丝信息，
     *
     * @param fansUid
     * @return 返回id
     */
    public Integer getFansUserinfoId(String fansUid) {
        FansUserInfoEntity byUid = fansUserInfoRepositiory.findByUid(fansUid);
        if (byUid != null) {
            return byUid.getId();
        }
        return -1;
    }

    /**
     * 新增一条粉丝信息
     *
     * @param fansUserInfoEntity
     * @return
     */
    public Integer saveFansUserInfoEntity(FansUserInfoEntity fansUserInfoEntity) {
        if (fansUserInfoEntity != null) {
            return fansUserInfoRepositiory.save(fansUserInfoEntity).getId();
        }
        return -1;
    }

    /**
     * 获取20个视频
     *
     * @return
     */
    public List<VideoEntity> getNext() {
        PageRequest request = PageRequest.of(page, 20);
        page++;
        return videoRepository.findByExtrenNot("1", request);
    }

    /**
     * 保存评论
     *
     * @param videoCommentEntities
     */
    public void saveVideoCommentEntity(List<VideoCommentEntity> videoCommentEntities, int vid, int authorId) {

        for (VideoCommentEntity videoCommentEntity : videoCommentEntities) {
            videoCommentEntity.setVid(vid);
            videoCommentEntity.setAuthorId(authorId);
            videoCommentEntity.setIsReply(0);
            List<VideoCommentEntity> replys = videoCommentEntity.getReplys();
            videoCommentEntity = savePerVideoCommentEntity(videoCommentEntity);
            if (replys != null) {
                for (VideoCommentEntity reply : replys) {
                    reply.setVid(vid);
                    reply.setAuthorId(authorId);
                    reply.setIsReply(1);
                    reply.setReplyId(videoCommentEntity.getId());
                    savePerVideoCommentEntity(reply);
                }
            }
        }
    }

    public void saveVideoMCommentEntity(List<MComment> videoCommentEntities, int vid, int authorId) {
        commentNum += videoCommentEntities.size();
        System.out.println(Utils.getNowDate() + ":" + "存入数量：" + commentNum);
        for (MComment videoCommentEntity : videoCommentEntities) {
            videoCommentEntity.setMy_author_id(authorId);
            videoCommentEntity.setMy_video_id(vid);
            List<MComment> replys = videoCommentEntity.getReplys();
            videoCommentEntity = savePerVideoMCommentEntity(videoCommentEntity);
//            if (replys != null) {
//                for (MComment reply : replys) {
//                    reply.setMy_author_id(authorId);
//                    reply.setMy_video_id(vid);
//                    reply.setMy_reply_id(videoCommentEntity.getAweme_id());
//                    savePerVideoMCommentEntity(reply);
//                }
//            }
        }
    }

    public MComment savePerVideoMCommentEntity(MComment videoCommentEntity) {
//        mongoService.save(videoCommentEntity);
        List<MComment> byCid = mCommentRepositry.findAllByCid(videoCommentEntity.getCid());
        MComment entity = null;
        if (byCid != null && byCid.size() > 0) {
//            entity = byCid.get(0);
//            String id = entity.getId();
//            BeanUtils.copyProperties(videoCommentEntity, entity);
//            entity.setId(id);
//            entity = mCommentRepositry.save(entity);
        } else {
            entity = mCommentRepositry.save(videoCommentEntity);
        }
        return videoCommentEntity;
    }

    public VideoCommentEntity savePerVideoCommentEntity(VideoCommentEntity videoCommentEntity) {
        commentNum++;
        System.out.println("videoCommentEntity的cid:" + videoCommentEntity.getCid() + "存入数量：" + commentNum);
        List<VideoCommentEntity> byCid = videoCommentRepository.findByCid(videoCommentEntity.getCid());
        VideoCommentEntity entity;
        if (byCid != null && byCid.size() > 0) {
            entity = byCid.get(0);
            Integer id = entity.getId();
            BeanUtils.copyProperties(videoCommentEntity, entity);
            entity.setId(id);
            entity = videoCommentRepository.save(entity);
        } else {
            entity = videoCommentRepository.save(videoCommentEntity);
        }
        return entity;
    }

    public List<TalentUserInfoEntity> getNextTalent() {
//        page = pageDao.getPage();
//        page++;
        PageRequest request = PageRequest.of(page, 20);
        return talentUserRepository.findAllByUids(request);
    }

    public List<VideoEntity> saveVideo(List<VideoEntity> videoEntities) {
        ArrayList<VideoEntity> list = new ArrayList<>();
        for (VideoEntity videoEntity : videoEntities) {
            VideoEntity byVid = videoRepository.findByVid(videoEntity.getVid());
            if (byVid == null) {
                byVid = videoRepository.save(videoEntity);
            } else {
                int id = byVid.getId();
                int playnum = byVid.getPlayNum();
                BeanUtils.copyProperties(videoEntity, byVid);
                byVid.setPlayNum(playnum);
                byVid.setId(id);
                byVid = videoRepository.save(byVid);
            }
            list.add(byVid);
        }
        return list;
    }
}
