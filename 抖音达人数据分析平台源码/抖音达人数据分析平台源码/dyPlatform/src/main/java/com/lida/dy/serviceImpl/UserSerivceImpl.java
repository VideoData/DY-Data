package com.lida.dy.serviceImpl;

import com.lida.dy.dao.UserRepositiory;
import com.lida.dy.model.entity.UserEntity;
import com.lida.dy.exception.AssertException;
import com.lida.dy.utils.MD5Util;
import com.lida.dy.utils.RedisUtil;
import com.lida.dy.model.vo.RegisterUserVO;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/10 0010 10:50
 * @Version: 1.0
 */
@Service
@Log
public class UserSerivceImpl implements com.lida.dy.service.UserSerivce {
    @Autowired
    UserRepositiory userRepositiory;
    @Autowired
    MailServiceImpl mailService;
    @Autowired
    RedisUtil redisUtil;
    private static ConcurrentHashMap<String, String> tempCode = new ConcurrentHashMap();

    @Override
    public UserEntity checkByAccountPasswd(String account, String passwd) throws AssertException {
        Assert.assertNotNull(account);
        System.out.println(MD5Util.getMD5(passwd));
        String passwd2 = MD5Util.getMD5(passwd);
        List<UserEntity> userEntities = userRepositiory.findByAccountNumber(account);
        if (userEntities != null) {
            for (UserEntity userEntity : userEntities) {
                if (userEntity.getPasswd().equals(passwd2)) {
                    return userEntity;
                }
            }
        }
        return null;
    }

    /**
     * 验证是否存在该号码
     *
     * @param phone
     * @return
     */
    @Override
    public boolean existPhone(String phone) {
        UserEntity userEntity = userRepositiory.findByPhone(phone);
        if (userEntity != null) {
            return true;
        }
        return false;
    }

    /**
     * 验证是否存在该邮箱
     *
     * @param email
     * @return
     */
    @Override
    public UserEntity existEmail(String email) {
        return userRepositiory.findByEmail(email);
    }


    @Override
    public void updatePasswd(int id, String passwd) {
        UserEntity userEntity = userRepositiory.findById(id).get();
        if (userEntity != null) {
            userEntity.setPasswd(MD5Util.getMD5(passwd));
            userRepositiory.save(userEntity);
        }
    }

    @Override
    public boolean insertUser(RegisterUserVO userVO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPasswd(MD5Util.getMD5(userVO.getPasswd()));
        userEntity.setAccountNumber(userVO.getUsername());
        userEntity.setEmail(userVO.getEmail());
        UserEntity userEntity1 = userRepositiory.save(userEntity);
        return userEntity1 != null;
    }
}
