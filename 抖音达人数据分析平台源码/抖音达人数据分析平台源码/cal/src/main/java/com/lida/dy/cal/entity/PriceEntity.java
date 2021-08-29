package com.lida.dy.cal.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/6 0006 21:14
 * @Version: 1.0
 */
@Entity
@Data
@Table(name = "price", schema = "dy")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer talentUserId;
    private Integer price;
    private String type;
    private String timeRange;
}
