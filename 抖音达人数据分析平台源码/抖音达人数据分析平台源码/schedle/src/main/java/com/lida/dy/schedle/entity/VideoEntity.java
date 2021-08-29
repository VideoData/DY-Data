package com.lida.dy.schedle.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "video", schema = "dy")
@Data
@ToString
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vid;
    private String workerLink;
    private String uid;
    private Integer userInfoId;
    private String videoTitle;
    private String description;
    private Integer playNum;
    private Integer commentNum;
    private Integer shareNum;
    private Integer favoritedNum;
    private Long createTime;
    private Integer duration;
    private Integer forwardCount;
    private Integer downloadCount;
    private String headImageUri;

    @Transient
    private String item_id;
}