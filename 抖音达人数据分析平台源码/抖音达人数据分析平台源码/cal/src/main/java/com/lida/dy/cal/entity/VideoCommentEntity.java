package com.lida.dy.cal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "video_comment", schema = "dy")
@Data
public class VideoCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Long createTime;
    private Integer diggCount;
    private Integer isReply;
    private Integer replyId;
    private Integer replyCommentTotal;
    private Integer uid;
    private Integer vid;
    private Integer authorId;
    private String extra;
    private String cid;
    @Transient
    private FansUserInfoEntity fansUserInfoEntity;
    @Transient
    private List<VideoCommentEntity> replys;

}
