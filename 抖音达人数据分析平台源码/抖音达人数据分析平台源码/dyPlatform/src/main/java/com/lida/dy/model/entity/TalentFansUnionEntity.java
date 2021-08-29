package com.lida.dy.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/5 0005 16:22
 * @Version: 1.0
 */
@Entity
@Data
@Table(name = "talent_fans_union", schema = "dy")
public class TalentFansUnionEntity {
    @Id
    private Integer id;
    private Integer talentId;
    private Integer fansId;
}
