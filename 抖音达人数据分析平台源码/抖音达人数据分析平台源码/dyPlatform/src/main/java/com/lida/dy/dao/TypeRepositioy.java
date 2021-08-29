package com.lida.dy.dao;

import com.lida.dy.model.entity.TalentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 10:30
 * @Version: 1.0
 */
public interface TypeRepositioy extends JpaRepository<TalentTypeEntity, Integer> {
    public List<TalentTypeEntity> findByTypeNameEquals(String name);
}
