package com.lida.dy.schedle.dao;

import com.lida.dy.schedle.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */

public interface VideoRepository extends JpaRepository<VideoEntity, Integer>, JpaSpecificationExecutor {
    public List<VideoEntity> findAllByUserInfoId(Integer id);

    public VideoEntity findByVid(String vid);
}
