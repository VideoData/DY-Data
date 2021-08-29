package com.lida.dy.cal.dao;


import com.lida.dy.cal.entity.TalentFansUnionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/5 0005 16:31
 * @Version: 1.0
 */
public interface TalentFansUnionRepository extends JpaRepository<TalentFansUnionEntity, Long> {
    List<TalentFansUnionEntity> findAllByTalentId(Integer id);

    TalentFansUnionEntity findByFansIdAndTalentId(Integer fansid, Integer talentid);
}
