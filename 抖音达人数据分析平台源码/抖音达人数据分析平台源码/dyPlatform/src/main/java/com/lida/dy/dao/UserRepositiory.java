package com.lida.dy.dao;

import com.lida.dy.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/9 0009 18:33
 * @Version: 1.0
 */
public interface UserRepositiory extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findByAccountNumber(String account);

    public UserEntity findByPhone(String phone);

    public UserEntity findByEmail(String email);
}
