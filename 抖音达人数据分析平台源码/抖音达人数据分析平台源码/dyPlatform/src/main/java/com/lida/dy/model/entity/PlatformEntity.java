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
@Table(name = "platform", schema = "dy")
@Data
public class PlatformEntity {
    @Id
    private Integer id;
    private String platformName;
}
