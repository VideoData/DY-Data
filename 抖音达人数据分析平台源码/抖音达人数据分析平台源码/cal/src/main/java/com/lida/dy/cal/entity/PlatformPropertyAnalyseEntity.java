package com.lida.dy.cal.entity;

import com.opencsv.bean.CsvBindByName;
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
    @CsvBindByName(column = "all_fans")
    private Integer allFansNum;
    @CsvBindByName(column = "real_fans")
    private Integer realFansNum;
    @CsvBindByName(column = "prdict_play_num")
    private Integer predictVideoPlayNum;
    private Float interactionRate;
    @CsvBindByName(column = "price")
    private Integer price;
    private Integer workNum;
    private Integer dynamicNum;
    @CsvBindByName(column = "max_play")
    private Integer maxVideoPlayNum;
    @CsvBindByName(column = "min_play")
    private Integer minVideoPlayNum;
    @CsvBindByName(column = "ave_play")
    private Integer avgVideoPlayNum;
    @CsvBindByName(column = "predict_cpm")
    private Float predictCpm;
    @CsvBindByName(column = "max_dianzan")
    private Integer maxLikeNum;
    @CsvBindByName(column = "min_dianzan")
    private Integer minLikeNum;
    @CsvBindByName(column = "ave_dianzan")
    private Integer avgLikeNum;
    @CsvBindByName(column = "max_comment")
    private Integer maxCommentNum;
    @CsvBindByName(column = "min_comment")
    private Integer minCommentNum;
    @CsvBindByName(column = "ave_comment")
    private Integer avgCommentNum;
    @CsvBindByName(column = "max_share")
    private Integer minShareNum;
    @CsvBindByName(column = "min_share")
    private Integer avgShareNum;
    @CsvBindByName(column = "ave_share")
    private Integer maxShareNum;
}
