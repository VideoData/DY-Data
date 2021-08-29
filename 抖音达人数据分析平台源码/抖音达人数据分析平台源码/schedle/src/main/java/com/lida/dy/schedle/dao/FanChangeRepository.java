package com.lida.dy.schedle.dao;

import com.lida.dy.schedle.entity.FanChangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */

public interface FanChangeRepository extends JpaRepository<FanChangeEntity, Integer>, JpaSpecificationExecutor {
     ArrayList<FanChangeEntity> findAllByUserInfoIdAndCheckTime(Integer id,Long checkTime);
     @Query(value = "select distinct user_info_id from fan_change",nativeQuery =true)
     ArrayList<Integer> findAllByDistinct();
     @Query(value = "SELECT *  FROM fan_change where user_info_id =:id ORDER by check_time DESC LIMIT 1",nativeQuery =true)
     FanChangeEntity findAllByDistinctById(@Param("id") Integer id );
}
