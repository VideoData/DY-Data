package com.lida.dy.cal.dao;

import com.lida.dy.cal.entity.TalentUserInfoEntity;
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

    public List<TalentUserInfoEntity> findAllByNickName(String name);

    public TalentUserInfoEntity findByNickName(String name);

    public List<TalentUserInfoEntity> findAllByOther(String other);

    @Query(value = "select nick_name from  talent_user_info", nativeQuery = true)
    public List<String> findAllBynickname();

    public List<TalentUserInfoEntity> findAllByPlatformId(Integer id);

    public List<TalentUserInfoEntity> findAllByUidNot(String uid, Pageable pageable);

    @Query(value = "select * from talent_user_info where total_like is null ", nativeQuery = true)
    public List<TalentUserInfoEntity> findAllByUids(Pageable pageable);

    @Query(value = "SELECT * FROM talent_user_info WHERE other = '-1'", nativeQuery = true)
    public List<TalentUserInfoEntity> findAllByOther0(Pageable pageable);

    @Query(value = "SELECT * FROM talent_user_info WHERE uid!=''", nativeQuery = true)
    public List<TalentUserInfoEntity> findAllByuidNotnull(Pageable pageable);

}
