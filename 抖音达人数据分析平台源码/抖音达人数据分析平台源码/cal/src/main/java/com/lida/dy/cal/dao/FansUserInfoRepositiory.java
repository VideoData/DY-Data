package com.lida.dy.cal.dao;

import com.lida.dy.cal.entity.FansUserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/9 0009 18:33
 * @Version: 1.0
 */
public interface FansUserInfoRepositiory extends JpaRepository<FansUserInfoEntity, Integer> {
    FansUserInfoEntity findByUid(String id);
}
