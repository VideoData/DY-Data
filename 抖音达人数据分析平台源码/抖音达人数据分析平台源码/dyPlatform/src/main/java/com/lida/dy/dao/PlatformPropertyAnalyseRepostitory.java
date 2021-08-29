package com.lida.dy.dao;

import com.lida.dy.model.entity.PlatformPropertyAnalyseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 15:03
 * @Version: 1.0
 */
public interface PlatformPropertyAnalyseRepostitory extends JpaRepository<PlatformPropertyAnalyseEntity, Integer> {
    @Query(value = "select * from platform_property_analyse where platform_id = :platformId limit :size", nativeQuery = true)
    public List<PlatformPropertyAnalyseEntity> findByPlatformId(@Param("platformId") int platformId, @Param("size") int Size);
}
