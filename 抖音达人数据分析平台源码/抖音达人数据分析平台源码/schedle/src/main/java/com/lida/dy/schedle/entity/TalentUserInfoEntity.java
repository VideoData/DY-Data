package com.lida.dy.schedle.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/18 0018 12:03
 * @Version: 1.0
 */
@Entity
@Table(name = "talent_user_info", schema = "dy")
@Data
@ToString
public class TalentUserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer platformId;
    private String uid;
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
    private Float xtCpm;
    private Integer xtPrePlayNum;
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
    private List<Tag> tags;
    @Transient
    private String tags_id;
    @Transient
    private String authorid;
    @Transient
    private List<PriceEntity> priceEntities;

}
