package com.lida.dy.cal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "video_change", schema = "dy")
@Data
public class VideoChangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vid;
    private String uid;
    private Integer myvid;
    private Integer myuid;
    private String createTime;
    private String recordTime;
    private String videoTitle;
    private Integer playNum;
    private Integer commentNum;
    private Integer shareNum;
    private Integer favoritedNum;
    private Integer downloadCount;
    private String extren;

}
