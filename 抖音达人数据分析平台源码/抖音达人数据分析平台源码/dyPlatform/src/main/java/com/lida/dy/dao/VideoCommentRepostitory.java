package com.lida.dy.dao;

import com.lida.dy.model.entity.VideoCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 15:03
 * @Version: 1.0
 */
public interface VideoCommentRepostitory extends JpaRepository<VideoCommentEntity, Integer> {
}
