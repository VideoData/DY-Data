package com.lida.dy.schedle.linuxSpider;

import com.lida.dy.schedle.dao.FanChangeRepository;
import com.lida.dy.schedle.dao.TalentUserRepository;
import com.lida.dy.schedle.entity.FanChangeEntity;
import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 修复粉丝数据
 */
@Component
public class FixFansCount {
    @Autowired
    FanChangeRepository fanChangeRepository;
    @Autowired
    TalentUserRepository talentUserRepository;
    public  void main(){
        ArrayList<Integer> allByDistinct = fanChangeRepository.findAllByDistinct();
        for (Integer integer : allByDistinct) {
            FanChangeEntity fanChangeEntity = fanChangeRepository.findAllByDistinctById(integer);
            TalentUserInfoEntity talentUserInfoEntity = talentUserRepository.findById(fanChangeEntity.getUserInfoId()).get();
            talentUserInfoEntity.setFansCount(fanChangeEntity.getFanNum());
            talentUserRepository.save(talentUserInfoEntity);
        }
    }
}
