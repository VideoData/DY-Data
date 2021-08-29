package com.lida.dy.serviceImpl;

import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.model.entity.UserEntity;
import com.lida.dy.model.pojo.VerificationCodeRedisBean;
import com.lida.dy.service.UserSerivce;
import com.lida.dy.utils.MD5Util;
import com.lida.dy.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/3 0003 15:30
 * @Version: 1.0
 */
@Service
@Slf4j
public class RedisService {
    @Autowired
    MailServiceImpl mailService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserSerivce userSerivce;

    /**
     * 生成验证码并缓存，发送邮箱验证码
     *
     * @param userEntity
     * @return
     */
    public String sendEmail(UserEntity userEntity) {
        String code = generateVerificationCode();
        String key = MD5Util.getMD5(String.valueOf(userEntity.getId()));
        log.info("sendEmail缓存redis: key: " + key + "   code:" + code);
        VerificationCodeRedisBean verificationCodeRedisBean = new VerificationCodeRedisBean();
        verificationCodeRedisBean.setId(userEntity.getId());
        verificationCodeRedisBean.setCode(code);
//
        if (!redisUtil.hasKey(key)) {
            redisUtil.set(key, verificationCodeRedisBean);
            redisUtil.expire(key, 60);
            mailService.sendMailVerificationCode(userEntity.getEmail(), code);
            System.out.println(code);
            return key;
        } else {
            return null;
        }

    }

    /**
     * 生成验证码并缓存，发送邮箱验证码,redis使用email作为key
     *
     * @return
     */
    public boolean sendEmailKeyByEmail(String email) {
        String code = generateVerificationCode();
        String key = DefaultConfig.defaultEmailPrefixInRedis + email;
        if (!redisUtil.hasKey(key)) {
            mailService.sendRegisterMailCode(email, code);
            redisUtil.set(key, code);
            return redisUtil.expire(key, 60);
        }
        return false;
    }

    /**
     * 生成6位随机验证码
     *
     * @return
     */
    public String generateVerificationCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    /**
     * 验证验证码    验证不成功返回-1，否则用户id
     *
     * @param key
     * @param code
     * @return id
     */
    public int checkVerificationCode(String key, String code) {
        VerificationCodeRedisBean s = (VerificationCodeRedisBean) redisUtil.get(key);
        System.out.println(s);
        if (s != null) {
            String key1 = MD5Util.getMD5(String.valueOf(s.getId()));
            if (key.equals(key1) && s.getCode().equals(code)) {
                redisUtil.del(key);
                return s.getId();
            }
        }
        return -1;
    }

    /**
     * 验证验证码。注册的，使用邮箱作为redis的key
     *
     * @param email
     * @param code
     * @return id
     */
    public boolean checkEmailKeyByEmail(String email, String code, boolean isDeleted) {
        String key = DefaultConfig.defaultEmailPrefixInRedis + email;
        String s = (String) redisUtil.get(key);
        if (s != null) {
            if (s.equals(code)) {
                if (isDeleted) {
                    redisUtil.del(key);
                } else {
                    redisUtil.expire(key, 60);
                }
                return true;
            }
        }
        return false;
    }
}
