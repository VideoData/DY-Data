package com.lida.dy.cal.dao;

import com.lida.dy.cal.entity.TalentTypeUnionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */

public interface TalentTypeUnioRepository extends JpaRepository<TalentTypeUnionEntity, Integer>, JpaSpecificationExecutor {
    public List<TalentTypeUnionEntity> findAllByTalentUserInfoId(Integer id);
}
