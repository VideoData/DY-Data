package com.lida.dy.schedle.linuxSpider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.schedle.dao.*;
import com.lida.dy.schedle.entity.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/3 0003 18:04
 * @Version: 1.0
 */
@Component
public class Save {
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    TalentTypeRepository talentTypeRepository;
    @Autowired
    TalentTypeUnioRepository talentTypeUnioRepository;
    @Autowired
    FanChangeRepository fanChangeRepository;
    @Autowired
    PriceRepository priceRepository;
    private List<TalentTypeEntity> talentTypeEntities = null;

    public void updateTalentTypeEntity() {
        talentTypeEntities = talentTypeRepository.findAll();
    }

    public void saveData(TalentUserInfoEntity talentUserInfoEntity, ArrayList<VideoEntity> videos) {
        TalentUserInfoEntity user = talentUserRepository.findByUniqueId(talentUserInfoEntity.getUniqueId());
        if (user != null) {
//            talentUserInfoEntity.setId(user.getId());
//            updateUserValue(talentUserInfoEntity, user);
            user.setUid(talentUserInfoEntity.getUid());
            user.setUniqueId(talentUserInfoEntity.getUniqueId());
            user.setNickName(talentUserInfoEntity.getNickName());
            user.setAvatarLink(talentUserInfoEntity.getAvatarLink());
            user.setProvince(talentUserInfoEntity.getProvince());
            user.setCity(talentUserInfoEntity.getCity());
            user.setGender(talentUserInfoEntity.getGender());
            user.setAvgLike(talentUserInfoEntity.getAvgLike());
            user.setFansCount(talentUserInfoEntity.getFansCount());
            user.setAvgPlayNum(talentUserInfoEntity.getAvgPlayNum());
            user.setAvgComment(talentUserInfoEntity.getAvgComment());
            user.setXtCpm(talentUserInfoEntity.getXtCpm());
            user.setXtPrePlayNum(talentUserInfoEntity.getXtPrePlayNum());
            user.setAvgShareNum(talentUserInfoEntity.getAvgShareNum());
            user.setDatafrom("schedle:saveData");
            talentUserInfoEntity = talentUserRepository.save(user);
        } else {
            talentUserInfoEntity.setOther("1");
            talentUserInfoEntity.setDatafrom("schedle:saveData");
            talentUserInfoEntity = talentUserRepository.save(talentUserInfoEntity);
            saveTag(talentUserInfoEntity);
            savePrice(talentUserInfoEntity.getId(), talentUserInfoEntity.getPriceEntities());
        }
        saveTalenFansChange(talentUserInfoEntity.getId(), talentUserInfoEntity.getFansCount());
        System.out.println("======video++++++++=");
        saveVideo(talentUserInfoEntity.getId(), talentUserInfoEntity.getUid(), videos);
    }

    /**
     * 手动添加更新的值
     *
     * @param source
     * @param target
     */
    private void updateUserValue(TalentUserInfoEntity source, TalentUserInfoEntity target) {
        target.setAvgLike(source.getAvgLike());
        target.setFansCount(source.getFansCount());
        target.setAvgPlayNum(source.getAvgPlayNum());
        target.setAvgComment(source.getAvgComment());
        target.setAvgShareNum(source.getAvgShareNum());
        target.setProvince(source.getProvince());
        target.setCity(source.getCity());
        target.setXtPrePlayNum(source.getXtPrePlayNum());
        target.setXtCpm(source.getXtCpm());
        target.setUid(source.getUid());
    }

    /**
     * 保存视频
     *
     * @param id
     * @param videos
     */
    public void saveVideo(int id, String uid, ArrayList<VideoEntity> videos) {
        for (VideoEntity videoEntity : videos) {
            videoEntity.setUserInfoId(id);
            videoEntity.setUid(uid);
            videoEntity.setDescription(videoEntity.getVideoTitle());
            if (videoEntity.getVid().isEmpty()) {
                continue;
            }
            VideoEntity byVid = videoRepository.findByVid(videoEntity.getVid());
            if (byVid == null) {
                byVid = videoRepository.findByVid(videoEntity.getItem_id());
            }
            if (byVid != null) {
                byVid.setPlayNum(videoEntity.getPlayNum());
                byVid.setUid(uid);
                videoRepository.save(byVid);
            }else{
                videoRepository.save(videoEntity);
            }
        }
    }
    public void saveVideoWithFixError(int id, String uid, ArrayList<VideoEntity> videos) {
        for (VideoEntity videoEntity : videos) {
            videoEntity.setUserInfoId(id);
            videoEntity.setUid(uid);
            videoEntity.setDescription(videoEntity.getVideoTitle());
            if (videoEntity.getVid().isEmpty()) {
                continue;
            }
            VideoEntity byVid = videoRepository.findByVid(videoEntity.getVid());
            if (byVid == null) {
                byVid = videoRepository.findByVid(videoEntity.getItem_id());
            }
            if (byVid != null) {
                byVid.setPlayNum(videoEntity.getPlayNum());
                byVid.setUid(uid);
                videoRepository.save(byVid);
            }else{
                videoRepository.save(videoEntity);
            }
        }
    }

    /**
     * 保存达人价格信息
     *
     * @param id
     * @param priceEntities
     */
    private void savePrice(int id, List<PriceEntity> priceEntities) {
        for (PriceEntity priceEntity : priceEntities) {
            priceEntity.setTalentUserId(id);
        }
        priceRepository.saveAll(priceEntities);
    }

    /**
     * 新增一次大人粉丝变化记录
     *
     * @param userInfoId
     * @param fansCount
     */
    private void saveTalenFansChange(int userInfoId, Integer fansCount) {
        FanChangeEntity fanChangeEntity = new FanChangeEntity();
        fanChangeEntity.setUserInfoId(userInfoId);
        fanChangeEntity.setFanNum(fansCount);
        fanChangeEntity.setCheckTime(System.currentTimeMillis());
        fanChangeRepository.save(fanChangeEntity);
    }


    private void saveTag(TalentUserInfoEntity talentUserInfoEntity) {
        List<Tag> tags = talentUserInfoEntity.getTags();
        if (tags == null) {
            return;
        }
        ArrayList<Tag> temptags = new ArrayList<>(tags);
        boolean flag = false;
        for (Tag tag : tags) {
            if (tag.getSubTag() != null) {
                for (String subtag : tag.getSubTag()) {
                    boolean flag1 = false;
                    for (TalentTypeEntity talentTypeEntity : talentTypeEntities) {
                        if (talentTypeEntity.getTypeSubName() != null && talentTypeEntity.getTypeName() != null) {
                            if (talentTypeEntity.getTypeName().equals(tag.getTag()) && talentTypeEntity.getTypeSubName().equals(subtag)) {
                                savetags(talentTypeEntity.getId(), talentUserInfoEntity.getId());
                                flag1 = true;
                                break;
                            }
                        }
                    }
                    if (!flag1) {
                        flag = true;
                        TalentTypeEntity talentTypeEntity1 = new TalentTypeEntity();
                        talentTypeEntity1.setTypeName(tag.getTag());
                        talentTypeEntity1.setTypeSubName(subtag);
                        talentTypeEntity1 = talentTypeRepository.save(talentTypeEntity1);
                        savetags(talentTypeEntity1.getId(), talentUserInfoEntity.getId());
                    }
                }
            }
        }
        if (flag) {
            updateTalentTypeEntity();
        }
    }

    private void savetags(Integer id, Integer id1) {
        TalentTypeUnionEntity talentTypeUnionEntity = new TalentTypeUnionEntity();
        talentTypeUnionEntity.setTalentTypeId(id);
        talentTypeUnionEntity.setTalentUserInfoId(id1);
        talentTypeUnioRepository.save(talentTypeUnionEntity);
    }

    //添加粉丝变化爬取并保存
    public void addFansChange(String authorid, String uid, int id, WebDriver driver) {
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String url ="https://star.toutiao.com/v/api/demand/author_daily_fans/?author_id="+authorid+"&platform_source=1&start_date=2017-12-05&end_date="+endDate;
        driver.get(url);
        String data = LinuxUtil.cleanHtml(driver.getPageSource());
        JSONObject jsonObject = JSON.parseObject(data);
        if(jsonObject.getString("msg").equals("成功")){
            ArrayList<FanChangeEntity> fanChangeEntities = new ArrayList<>();
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("daily");
            for (int i = 0; i < jsonArray.size(); i++) {
                FanChangeEntity fanChangeEntity = new FanChangeEntity();
                fanChangeEntity.setUid(uid);
                fanChangeEntity.setUserInfoId(id);
                fanChangeEntity.setFanNum(jsonArray.getJSONObject(i).getIntValue("fans_cnt"));
                try {
                    Date date = new SimpleDateFormat("yyyyMMdd").parse(jsonArray.getJSONObject(i).getString("date"));
                    Long timestamp=date.getTime();
                    timestamp = timestamp /1000;
                    fanChangeEntity.setCheckTime(timestamp);
                    List<FanChangeEntity> checks = fanChangeRepository.findAllByUserInfoIdAndCheckTime(fanChangeEntity.getUserInfoId(), fanChangeEntity.getCheckTime());
                    if(checks!=null&&checks.size()>0){
                        continue;
                    }else{
                        fanChangeEntities.add(fanChangeEntity);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            fanChangeRepository.saveAll(fanChangeEntities);
        }
    }
}
