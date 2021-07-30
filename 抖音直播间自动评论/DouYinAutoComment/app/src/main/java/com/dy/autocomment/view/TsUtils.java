package com.dy.autocomment.view;

import com.dy.autocomment.BaseApp;

public class TsUtils {
    private static FloatTips floatTips;
    public static void showTips(String msg){
        if(floatTips==null) {
            floatTips = new FloatTips(BaseApp.app.getApplicationContext());
            floatTips.setGravity(FloatTips.BOTTOM);
            floatTips.setDuration(FloatTips.LENGTH_ALWAYS);
        }
        floatTips.setText(msg);
        floatTips.show();
    }
}


