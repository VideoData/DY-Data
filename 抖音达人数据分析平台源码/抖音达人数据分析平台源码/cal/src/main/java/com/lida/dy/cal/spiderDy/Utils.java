package com.lida.dy.cal.spiderDy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getNowDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
