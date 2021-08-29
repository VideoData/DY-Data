package com.lida.dy.dao;

import com.lida.dy.model.entity.TalentUserInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */

public interface TalentUserRepository extends JpaRepository<TalentUserInfoEntity, Integer>, JpaSpecificationExecutor {
    public List<TalentUserInfoEntity> findAllByIdIn(List<Integer> ids);

    public Page<TalentUserInfoEntity> findAllByOther(String other, Pageable pageable);

    public List<TalentUserInfoEntity> findAllByOther(String other);

    public TalentUserInfoEntity findByIdAndOther(Integer id, String other);
//    public TalentUserInfoEntity findById(Integer id);

    public List<TalentUserInfoEntity> findAllByOtherAndIdIn(String other, List<Integer> ids);

    @Query(nativeQuery = true, value = "select * from talent_user_info where other = 1 and id in (select talent_user_info_id from talent_type_union where talent_type_id in (select id from talent_type where type_name = :typename))")
    public List<TalentUserInfoEntity> findAllByTalentTypeName(@Param("typename") String typeName);
}
