package com.lida.dy.cal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "fans_user_info"  )
@Data
public class FansUserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uid;
    private String nickName;
    private String avatarHref;
    private Integer age;
    private Integer gender;
    private String loginDevice;
    private Integer followerCount;
    private Integer followingCount;
    private Integer totalFavorited;
    private Integer totalCommentNum;
    private Integer totalShareNum;
    private Integer totalDynaicNum;
    private Integer awemeCount;
    private String signature;
    private Date birthday;
    private String dyNum;
    private String province;
    private String city;
    private Integer favoritingCount;

}
