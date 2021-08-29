package com.lida.dy.cal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/18 0018 12:03
 * @Version: 1.0
 */
@Entity
@Table(name = "talent_user_info", schema = "dy")
@Data
public class TalentUserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer platformId;
    private String uid;
    private Float xtCpm;
    private Integer xtPrePlayNum;
    private String uniqueId;
    private String nickName;
    private String avatarLink;
    private String province;
    private String city;
    private Integer gender;
    private Integer totalLike;
    private Integer avgLike;
    private Integer fansCount;
    private Integer focusCount;
    private Integer favoritingCount;
    private Integer realFansCount;
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
    private Float cpm;
    private Integer xtOrderCompleteNum;
    private String other;
    private String datafrom;
    @Transient
    private String tags;
}
