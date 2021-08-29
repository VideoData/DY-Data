package com.lida.dy.schedle.ippool.util;


import com.lida.dy.schedle.ippool.IPBean;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/28 0028 18:06
 * @Version: 1.0
 */
public class ProxyUtils {
    /**
     * 设置全局代理
     * @param ipBean
     */
    public static void setGlobalProxy(IPBean ipBean){
        System.setProperty("proxyPort", String.valueOf(ipBean.getPort()));
        System.setProperty("proxyHost", ipBean.getIp());
        System.setProperty("proxySet", "true");
    }

}
