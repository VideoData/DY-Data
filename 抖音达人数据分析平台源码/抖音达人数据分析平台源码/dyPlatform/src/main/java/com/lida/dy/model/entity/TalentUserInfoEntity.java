package com.lida.dy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 10:50
 * @Version: 1.0
 */
@Entity
@Table(name = "talent_user_info", schema = "dy")
public class TalentUserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uid;
    private Integer platformId;
    private String uniqueId;
    private String nickName;
    private String avatarLink;
    private String province;
    private String city;
    private Integer gender;
    private Integer totalLike;
    private Integer avgLike;
    private Integer fansCount;
    private Integer focusCount;
    private Integer realFansCount;
    private String price;
    private Float value;
    private String type;
    private Integer totalPlayNum;
    private Integer avgPlayNum;
    private Integer prePlayNum;
    private Float playNumUnit;
    private Float interactionNum;
    private Integer totalCommentNum;
    private Integer avgComment;
    private Integer totalShareNum;
    private Integer avgShareNum;
    private Integer totalDynaicNum;
    private Float communicationValue;
    private String fansFeature;
    private Integer age;
    private String signature;
    private Integer videoCount;
    private Integer isVerified;
    private Date birthday;
    private Float xtCpm;
    private Integer xtPrePlayNum;
    private Float cpm;
    private Integer xtOrderCompleteNum;
    private String other;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "talent_type_union",
            joinColumns = {@JoinColumn(name = "talentUserInfoId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "talentTypeId", referencedColumnName = "id")})
    private Set<TalentTypeEntity> types;


    @Transient
    private boolean isCandidate;
    @Transient
    private boolean isChong;
    /*是否是手动选定*/
    @Transient
    private boolean isLastCandidate;

    /*计算选定*/
    @Transient
    private boolean isLastCandidateByAuto;
    @Transient
    private String showLocation;
    @Transient
    private String predicatePlayUnit;
    @Transient
    private double tempCpm;
    @Transient
    private Integer showMainPrice = 0;
    // 放弃外键的维护权，拥有mappedBy注解的实体类为关系被维护端
    //删除达人时，会级联删除价格，，，延迟加载
    @OneToMany(mappedBy = "talentUserInfoEntity")
    private List<PriceEntity> priceEntities;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
    }

    public Integer getAvgLike() {
        return avgLike;
    }

    public void setAvgLike(Integer avgLike) {
        this.avgLike = avgLike;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(Integer focusCount) {
        this.focusCount = focusCount;
    }

    public Integer getRealFansCount() {
        return realFansCount;
    }

    public void setRealFansCount(Integer realFansCount) {
        this.realFansCount = realFansCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotalPlayNum() {
        return totalPlayNum;
    }

    public void setTotalPlayNum(Integer totalPlayNum) {
        this.totalPlayNum = totalPlayNum;
    }

    public Integer getAvgPlayNum() {
        return avgPlayNum;
    }

    public void setAvgPlayNum(Integer avgPlayNum) {
        this.avgPlayNum = avgPlayNum;
    }

    public Integer getPrePlayNum() {
        return prePlayNum;
    }

    public void setPrePlayNum(Integer prePlayNum) {
        this.prePlayNum = prePlayNum;
    }

    public Float getPlayNumUnit() {
        return playNumUnit;
    }

    public void setPlayNumUnit(Float playNumUnit) {
        this.playNumUnit = playNumUnit;
    }

    public Float getInteractionNum() {
        return interactionNum;
    }

    public void setInteractionNum(Float interactionNum) {
        this.interactionNum = interactionNum;
    }

    public Integer getTotalCommentNum() {
        return totalCommentNum;
    }

    public void setTotalCommentNum(Integer totalCommentNum) {
        this.totalCommentNum = totalCommentNum;
    }

    public Integer getAvgComment() {
        return avgComment;
    }

    public void setAvgComment(Integer avgComment) {
        this.avgComment = avgComment;
    }

    public Integer getTotalShareNum() {
        return totalShareNum;
    }

    public void setTotalShareNum(Integer totalShareNum) {
        this.totalShareNum = totalShareNum;
    }

    public Integer getAvgShareNum() {
        return avgShareNum;
    }

    public void setAvgShareNum(Integer avgShareNum) {
        this.avgShareNum = avgShareNum;
    }

    public Integer getTotalDynaicNum() {
        return totalDynaicNum;
    }

    public void setTotalDynaicNum(Integer totalDynaicNum) {
        this.totalDynaicNum = totalDynaicNum;
    }

    public Float getCommunicationValue() {
        return communicationValue;
    }

    public void setCommunicationValue(Float communicationValue) {
        this.communicationValue = communicationValue;
    }

    public String getFansFeature() {
        return fansFeature;
    }

    public void setFansFeature(String fansFeature) {
        this.fansFeature = fansFeature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getXtCpm() {
        return xtCpm;
    }

    public void setXtCpm(Float xtCpm) {
        this.xtCpm = xtCpm;
    }

    public Integer getXtPrePlayNum() {
        return xtPrePlayNum;
    }

    public void setXtPrePlayNum(Integer xtPrePlayNum) {
        this.xtPrePlayNum = xtPrePlayNum;
    }

    public Float getCpm() {
        return cpm;
    }

    public void setCpm(Float cpm) {
        this.cpm = cpm;
    }

    public Integer getXtOrderCompleteNum() {
        return xtOrderCompleteNum;
    }

    public void setXtOrderCompleteNum(Integer xtOrderCompleteNum) {
        this.xtOrderCompleteNum = xtOrderCompleteNum;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Set<TalentTypeEntity> getTypes() {
        return types;
    }

    public void setTypes(Set<TalentTypeEntity> types) {
        this.types = types;
    }

    public boolean isCandidate() {
        return isCandidate;
    }

    public void setCandidate(boolean candidate) {
        isCandidate = candidate;
    }

    public boolean isChong() {
        return isChong;
    }

    public void setChong(boolean chong) {
        isChong = chong;
    }

    public boolean isLastCandidate() {
        return isLastCandidate;
    }

    public void setLastCandidate(boolean lastCandidate) {
        isLastCandidate = lastCandidate;
    }

    public boolean isLastCandidateByAuto() {
        return isLastCandidateByAuto;
    }

    public void setLastCandidateByAuto(boolean lastCandidateByAuto) {
        isLastCandidateByAuto = lastCandidateByAuto;
    }

    public String getShowLocation() {
        return showLocation;
    }

    public void setShowLocation(String showLocation) {
        this.showLocation = showLocation;
    }

    public String getPredicatePlayUnit() {
        return predicatePlayUnit;
    }

    public void setPredicatePlayUnit(String predicatePlayUnit) {
        this.predicatePlayUnit = predicatePlayUnit;
    }

    public double getTempCpm() {
        return tempCpm;
    }

    public void setTempCpm(double tempCpm) {
        this.tempCpm = tempCpm;
    }

    public Integer getShowMainPrice() {
        return showMainPrice;
    }

    public void setShowMainPrice(Integer showMainPrice) {
        this.showMainPrice = showMainPrice;
    }

    public List<PriceEntity> getPriceEntities() {
        return priceEntities;
    }

    public void setPriceEntities(List<PriceEntity> priceEntities) {
        this.priceEntities = priceEntities;
    }
}