package com.lida.dy.utils;

import java.text.DecimalFormat;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/9 0009 20:54
 * @Version: 1.0
 */
public class ThymeleafUtil {
    public static String parseMoney(double money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
        return decimalFormat.format(money);
    }

    public static void main(String[] args) {
        parseMoney(15000000000.4564);
    }
}
