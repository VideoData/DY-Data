package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "fans_user_info", schema = "dy" )
@Data
public class UserInfoEntity {
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
    private Integer favoritingCount;

}
