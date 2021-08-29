package com.lida.dy.schedle.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 15:32
 * @Version: 1.0
 */
@Entity
@Data
@Table(name = "talent_type_union")
public class TalentTypeUnionEntity {
    @Id
    private Integer talentUserInfoId;
    private Integer talentTypeId;
}
