package com.lida.dy.dao;

import com.lida.dy.model.entity.TalentTypeEntity;
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
public interface TalentTypeRepostitory extends JpaRepository<TalentTypeEntity, Integer> {
    List<TalentTypeEntity> findAllByTypeName(String typename);


    @Query(nativeQuery = true, value = "select id from talent_type where type_name = :typename")
    List<Integer> findIdByTypeNames(@Param("typename") String typeName);

}
