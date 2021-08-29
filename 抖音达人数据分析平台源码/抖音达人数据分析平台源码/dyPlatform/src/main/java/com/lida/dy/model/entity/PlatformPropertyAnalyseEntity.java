package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/7 0007 22:47
 * @Version: 1.0
 */
@Entity
@Table(name = "platform_property_analyse", schema = "dy")
@Data
public class PlatformPropertyAnalyseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer platformId;
    private Integer allFansNum;
    private Integer realFansNum;
    private Integer predictVideoPlayNum;
    private Float interactionRate;
    private Integer price;
    private Integer workNum;
    private Integer dynamicNum;
    private Integer maxVideoPlayNum;
    private Integer minVideoPlayNum;
    private Integer avgVideoPlayNum;
    private Float predictCpm;
    private Integer maxLikeNum;
    private Integer minLikeNum;
    private Integer avgLikeNum;
    private Integer maxCommentNum;
    private Integer minCommentNum;
    private Integer avgCommentNum;
    private Integer minShareNum;
    private Integer avgShareNum;
    private Integer maxShareNum;

}
