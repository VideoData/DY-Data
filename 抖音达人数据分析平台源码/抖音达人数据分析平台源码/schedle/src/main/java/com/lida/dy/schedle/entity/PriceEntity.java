package com.lida.dy.schedle.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "price", schema = "dy")
@Data
@ToString
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer talentUserId;
    private Integer price;
    private String type;
    private String timeRange;

}