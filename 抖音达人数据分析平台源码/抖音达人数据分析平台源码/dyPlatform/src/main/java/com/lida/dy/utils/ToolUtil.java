package com.lida.dy.utils;

import com.lida.dy.dao.TalentUserRepository;
import com.lida.dy.model.entity.PriceEntity;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.serviceImpl.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 15:43
 * @Version: 1.0
 */
@Component
@Slf4j
public class ToolUtil {
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    PriceService priceService;

    /**
     * w -> 数字
     *
     * @param s
     */
    public int WToInt(String s) {
        if (s.indexOf("w") > -1) {
            s = s.replace("w", "");
            return (int) Float.parseFloat(s) * 10000;
        } else {
            return Integer.parseInt(s);
        }
    }

    /**
     * 将talentUser返回前端时，做的一些处理
     *
     * @param user
     */
    public void wrapperTanlentUserInfo(TalentUserInfoEntity user) {
        if (user.getFansCount() == null || user.getFansCount() == 0) {
            if (user.getOther().equals("1")) {
                int fans = new Random().nextInt(1000000);
                if (fans < 10) {
                    fans = fans * 1000;
                }
                user.setFansCount(fans);
                talentUserRepository.save(user);
            }
        }
        CalcUtil.calcPlayUnit(user);
        List<PriceEntity> priceEntities = user.getPriceEntities();
        for (PriceEntity priceEntity : priceEntities) {
            if (priceEntity.getTimeRange().contains("20s") && priceEntity.getPrice() > 0) {
                if(user.getPrePlayNum()==null||user.getPrePlayNum()==0){
                    break;
                }
                float cpm = ((float) priceEntity.getPrice() / user.getPrePlayNum()) * 1000;
                float temp = new BigDecimal(cpm).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                log.info("TempCpma {} , price {} , playnum {}", temp, priceEntity.getPrice(), user.getPrePlayNum());
                user.setTempCpm(temp);
                user.setShowMainPrice(priceEntity.getPrice());
                break;
            }
        }

        /*格式化城市*/
        String temp = "-";
        String city = user.getCity();
        String province = user.getProvince();
        if (province == null || province.isEmpty() || city == null || city.isEmpty()) {
            temp = "";
        }
        user.setShowLocation(province + temp + city);

        CalcUtil.calcPlayUnit(user);
    }

    public void wrapperTanlentUserInfo(Collection<TalentUserInfoEntity> users) {
        for (TalentUserInfoEntity user : users) {
            wrapperTanlentUserInfo(user);
        }
    }

    public void wrapperTanlentUserInfo(Page<TalentUserInfoEntity> users) {
        List<TalentUserInfoEntity> content = users.getContent();
        for (TalentUserInfoEntity talentUserInfoEntity : content) {
            wrapperTanlentUserInfo(talentUserInfoEntity);
        }
    }

    public void dealDieFor(Page<TalentUserInfoEntity> page) {
        List<TalentUserInfoEntity> content = page.getContent();
        for (TalentUserInfoEntity talentUserInfoEntity : content) {
            for (PriceEntity priceEntity : talentUserInfoEntity.getPriceEntities()) {
                priceEntity.setTalentUserInfoEntity(null);
            }
        }
    }
}
