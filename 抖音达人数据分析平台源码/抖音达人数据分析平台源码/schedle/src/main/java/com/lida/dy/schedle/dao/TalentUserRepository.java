package com.lida.dy.schedle.dao;

import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */

public interface TalentUserRepository extends JpaRepository<TalentUserInfoEntity, Integer>, JpaSpecificationExecutor {
    public TalentUserInfoEntity findByUniqueId(String uniqueid);

    public List<TalentUserInfoEntity> findAllByOther(String other);

    @Query(value = "select * from talent_user_info where avg_play_num is null and uid !=''", nativeQuery = true)
    public List<TalentUserInfoEntity> findAllByOther(Pageable pageable);

    @Query(value = "select * from talent_user_info where uid is null or  avg_like is null", nativeQuery = true)
    public List<TalentUserInfoEntity> findAllByOtherWithError(Pageable pageable);


}
