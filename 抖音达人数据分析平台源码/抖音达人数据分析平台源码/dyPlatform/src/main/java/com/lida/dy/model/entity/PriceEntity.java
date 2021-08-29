package com.lida.dy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/6 0006 21:14
 * @Version: 1.0
 */
@Entity
@Table(name = "price", schema = "dy")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;
    private String type;
    private String timeRange;
    //可选属性optional=false,表示talentUserInfoEntity不能为空。删除价格，不影响达人
    @ManyToOne(targetEntity = TalentUserInfoEntity.class)
    @JoinColumn(name = "talent_user_id", referencedColumnName = "id")
    @Ignore
    private TalentUserInfoEntity talentUserInfoEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    @JsonIgnore
    public TalentUserInfoEntity getTalentUserInfoEntity() {
        return talentUserInfoEntity;
    }

    public void setTalentUserInfoEntity(TalentUserInfoEntity talentUserInfoEntity) {
        this.talentUserInfoEntity = talentUserInfoEntity;
    }
}
