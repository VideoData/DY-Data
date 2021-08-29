package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "fan_change", schema = "dy")
@Data
public class FanChangeEntity {
    @Id
    private Integer id;
    private Integer userInfoId;
    private Integer fanNum;
    private Long checkTime;
}
