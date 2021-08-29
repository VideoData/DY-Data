package com.lida.dy.dao;

import com.lida.dy.model.entity.FanOverlapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 15:03
 * @Version: 1.0
 */
public interface OverlapRepostitory extends JpaRepository<FanOverlapEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM fan_overlap WHERE (talenta_id = :a AND talentb_id = :b) OR (talenta_id = :b AND talentb_id = :a);")
    public FanOverlapEntity findByTalentaIdAndTalentbId(@Param("a") int talentaId, @Param("b") int talentbId);
}
