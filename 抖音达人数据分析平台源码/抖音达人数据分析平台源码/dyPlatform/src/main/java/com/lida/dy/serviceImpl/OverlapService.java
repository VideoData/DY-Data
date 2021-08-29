package com.lida.dy.serviceImpl;

import com.lida.dy.dao.OverlapRepostitory;
import com.lida.dy.dao.TalentFansUnionRepository;
import com.lida.dy.dao.TalentUserRepository;
import com.lida.dy.model.entity.FanOverlapEntity;
import com.lida.dy.model.vo.OverlapVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 22:16
 * @Version: 1.0
 * 计算达人粉丝重合度服务
 */
@Service
@Slf4j
public class OverlapService {
    @Autowired
    OverlapRepostitory overlapRepostitory;
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    TalentFansUnionRepository talentFansUnionRepository;
    @Autowired
    CoreService coreService;

    public OverlapVo getOverlap(int ida, int idb) {
        OverlapVo overlapVo = new OverlapVo();
        overlapVo.setUserInfoEntitya(talentUserRepository.findById(ida).get());
        overlapVo.setUserInfoEntityb(talentUserRepository.findById(idb).get());
        FanOverlapEntity fanOverlapEntity = overlapRepostitory.findByTalentaIdAndTalentbId(ida, idb);
        if (fanOverlapEntity != null && fanOverlapEntity.getOverlapValue() != null) {
            overlapVo.setOverlapValue(fanOverlapEntity.getOverlapValue());
            overlapVo.setTalendaFanNum(fanOverlapEntity.getTalendaFanNum());
            overlapVo.setTalendbFanNum(fanOverlapEntity.getTalendbFanNum());
        } else {
            coreService.calcOverlap(overlapVo);
        }
        log.info("overlapVo重合度结果：{}", overlapVo.toString());
        return overlapVo;
    }


}
