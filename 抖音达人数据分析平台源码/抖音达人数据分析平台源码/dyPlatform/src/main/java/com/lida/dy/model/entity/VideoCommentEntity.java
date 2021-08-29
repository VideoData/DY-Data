package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.*;

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
    private String cid;
    private String text;
    private Long createTime;
    private Integer diggCount;
    private Integer isReply;
    private Integer replyId;
    private Integer replyCommentTotal;
    private Integer uid;
    private String extra;
    private Integer vid;
    private Integer authorId;

}
