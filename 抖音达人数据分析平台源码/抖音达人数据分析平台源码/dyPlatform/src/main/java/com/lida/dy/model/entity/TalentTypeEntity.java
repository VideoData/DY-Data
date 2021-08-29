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
@Table(name = "talent_type", schema = "dy")
@Data
public class TalentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeName;
    private String typeSubName;

    //多对多的关系
//    @JsonIgnoreProperties(value = {"types"})
//    @ManyToMany(mappedBy = "types")
//    private Set<TalentUserInfoEntity> talentUserInfoEntities;

}
