package com.lida.dy.service;

import com.lida.dy.model.entity.UserEntity;
import com.lida.dy.exception.AssertException;
import com.lida.dy.model.vo.RegisterUserVO;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/16 0016 11:17
 * @Version: 1.0
 */
public interface UserSerivce {
    UserEntity checkByAccountPasswd(String account, String passwd) throws AssertException;

    boolean existPhone(String phone);

    UserEntity existEmail(String email);

    boolean insertUser(RegisterUserVO userVO);

    void updatePasswd(int id, String passwd);
}
