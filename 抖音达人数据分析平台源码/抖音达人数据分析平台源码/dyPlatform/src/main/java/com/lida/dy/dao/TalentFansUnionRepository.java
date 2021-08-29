package com.lida.dy.dao;

import com.lida.dy.model.entity.TalentFansUnionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/5 0005 16:31
 * @Version: 1.0
 */
public interface TalentFansUnionRepository extends JpaRepository<TalentFansUnionEntity, Long> {
    Set<TalentFansUnionEntity> findAllByTalentId(Integer id);
}
