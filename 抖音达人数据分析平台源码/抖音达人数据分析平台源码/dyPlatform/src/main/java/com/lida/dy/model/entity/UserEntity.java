package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/9 0009 18:32
 * @Version: 1.0
 */
@Entity
@Table(name = "user", schema = "dy")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nickName;
    private String accountNumber;
    private String passwd;
    private String phone;
    private String email;
    private Integer orderId;
    private String other;

    @Transient
    private String remember;

}
