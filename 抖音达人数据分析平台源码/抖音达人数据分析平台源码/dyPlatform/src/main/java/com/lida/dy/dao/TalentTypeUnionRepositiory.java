package com.lida.dy.dao;

import com.lida.dy.model.entity.TalentTypeUnionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 15:34
 * @Version: 1.0
 */
public interface TalentTypeUnionRepositiory extends JpaRepository<TalentTypeUnionEntity, Integer> {
    public List<TalentTypeUnionEntity> findAllByTalentTypeId(Integer id);

    public List<TalentTypeUnionEntity> findAllByTalentTypeIdIn(List<Integer> ids);

    @Query(nativeQuery = true, value = "select talent_user_info_id from talent_type_union where talent_type_id = :typeid")
    List<Integer> findIdByTypeId(@Param("typeid") Integer id);
}
