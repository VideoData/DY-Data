package com.lida.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/18 0018 12:03
 * @Version: 1.0
 */
@Entity
@Table(name = "talent_user_info", schema = "dy")
@Data
public class FTalentUserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uid;
    @CsvBindByName(column = "unique_id")
    private String uniqueId;
    @CsvBindByName(column = "nick_name")
    private String nickName;
    private String avatarLink;
    private String province;
    @CsvBindByName(column = "city")
    private String city;
    @CsvBindByName(column = "gender")
    private Integer gender;
    private Integer totalLike;
    private Integer avgLike;
    private Integer fansCount;
    private Integer focusCount;
    private Integer realFansCount;
    @CsvBindByName(column = "price")
    private String price;
    private Float value;
    private String type;
    private Integer totalPlayNum;
    private Integer avgPlayNum;
    private Integer prePlayNum;
    private Float playNumUnit;
    private Float interactionNum;
    private Integer totalCommentNum;
    private Integer avgComment;
    private Integer totalShareNum;
    private Integer avgShareNum;
    private Integer totalDynaicNum;
    private Float communicationValue;
    private String fansFeature;
    private Integer age;
    private String signature;
    private Integer videoCount;
    private Integer isVerified;
    private Date birthday;
    private  Float xtCpm;
    private Integer xtPrePlayNum;
    private Float cpm;
    private Integer xtOrderCompleteNum;
    private String other;
    @Transient
    @CsvBindByName(column = "tags")
    private String tags;
}
