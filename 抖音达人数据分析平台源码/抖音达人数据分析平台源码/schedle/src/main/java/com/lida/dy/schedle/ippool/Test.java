package com.lida.dy.schedle.ippool;


import com.lida.dy.schedle.ippool.util.IPUtils;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/28 0028 18:12
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Test Start: ");
        String ip = "119.101.118.61";

        System.out.println(IPUtils.getMyIp());
        System.out.println(IPUtils.getMyIp());
        System.out.println(IPUtils.getMyIp());

        System.setProperty("proxyPort", "9999");
        System.setProperty("proxyHost", ip);
        System.setProperty("proxySet", "true");

        System.out.println(IPUtils.getMyIp());
    }
}
