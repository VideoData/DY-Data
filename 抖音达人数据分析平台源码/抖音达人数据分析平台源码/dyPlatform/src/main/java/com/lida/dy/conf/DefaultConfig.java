package com.lida.dy.conf;

import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 14:58
 * @Version: 1.0
 */
public class DefaultConfig {
    public static int page = 1;
    public static int size = 10;

    public static String seContentTitle = "内容类型";
    public static String sePriceTitle = "价值";
    public static String seFansTitle = "粉丝数";

    public static List<String> fansNumItem = Arrays.asList(new String[]{"1000w以上", "500w-1000w", "300w-500w", "100w-300w", "10w-100w", "10w以下"});
    public static List<String> pricesItem = Arrays.asList(new String[]{"10w", "5w-10w", "1w-5w", "0.5w-1w", "0.2w-0.5w", "0.2w以下"});

    public static int defaultProfileVideoNum = 15;  //默认个人信息15个视频播放量
    public static int defaultFanChangeNum = 15;  //默认个人信息15个粉丝变化量


    public static int defaultPlatformDataSize = 500;  //默认显示平台数据的数据量
    public static int defaultPlatformDataTypeUserSize = 500;  //默认显示平台数据有效用户的数据量

    /*AES加密参数*/
    public static String KEY = "aaDJL2d9DfhLZO0z";
    public static String IV = "412ADDSSFA342442";

    public static String defaultEmailPrefixInRedis = "emailregis";  //默认显示平台数据有效用户的数据量

    /**
     * 因为静态变量不能直接从配置文件通过@value获取，所以采用此方法
     *
     * @param key
     */
    @Value("${my.AES.KEY}")
    public void AESkey(String key) {
        KEY = key;
    }

    @Value("${my.AES.IV}")
    public void AESIv(String iv) {
        IV = iv;
    }
}
