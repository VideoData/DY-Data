package com.lida.dy.dao;

import com.lida.dy.model.entity.VideoEntity;
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
public interface VideoRepostitory extends JpaRepository<VideoEntity, Integer> {
    @Query(value = "select * from video where user_info_id =:id order by create_time desc limit :size", nativeQuery = true)
    List<VideoEntity> getLastVideoInfoByNum(@Param("id") int id, @Param("size") int size);
}
