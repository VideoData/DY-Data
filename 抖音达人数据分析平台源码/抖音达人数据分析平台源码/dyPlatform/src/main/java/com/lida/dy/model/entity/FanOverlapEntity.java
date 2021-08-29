package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "fan_overlap", schema = "dy")
@Data
public class FanOverlapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer talentaId;
    private Integer talentbId;
    private Integer overlapValue;
    private Integer talendaFanNum;
    private Integer talendbFanNum;
}
