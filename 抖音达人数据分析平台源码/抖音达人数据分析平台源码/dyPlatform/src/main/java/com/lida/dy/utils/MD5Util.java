package com.lida.dy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/17 0017 9:15
 * @Version: 1.0
 */
@Component
public class MD5Util {
    //盐，用于混交md5
    @Value("${my.md5.salt}")
    private static final String salt = "&%5123***&&%%$$#@";

    /**
     * 生成md5
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        String base = str + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
