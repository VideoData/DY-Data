package com.lida.dy.cal.dao;

import com.lida.dy.cal.entity.VideoChangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.security.PublicKey;
import java.util.List;

public interface VideoChangeRepository extends JpaRepository<VideoChangeEntity, Integer>, JpaSpecificationExecutor {
    @Query(value="select distinct vid from video_change",nativeQuery=true)
    public List<String> findvid();

    public VideoChangeEntity findFirstByVid(String vid);
}
