package com.lida.dy.dao;

import com.lida.dy.model.entity.FanChangeEntity;
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
public interface FanChangeRepostitory extends JpaRepository<FanChangeEntity, Integer> {
    @Query(value = "select * from fan_change where user_info_id =:id order by check_time desc limit :size", nativeQuery = true)
    List<FanChangeEntity> getLastFanChangeByNum(@Param("id") int id, @Param("size") int size);
}
