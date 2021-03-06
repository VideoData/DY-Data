package com.dy.autocomment;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.dy.autocomment.view.TsUtils;
import com.dy.fastframework.activity.BaseActivity;
import com.dy.fastframework.service.NotifyService;
import com.dy.fastframework.view.CommonMsgDialog;
import com.imuxuan.floatingview.FloatingView;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import yin.deng.normalutils.utils.LogUtils;
import yin.deng.normalutils.utils.MyUtils;
import yin.deng.normalutils.utils.NoDoubleClickListener;
import yin.deng.normalutils.view.MsgDialog;

public class MainActivity extends BaseActivity implements ServiceConnection {

    private static final int REQUEST_OVERLAY = 3211;
    private Button btStart;
    private Switch switchIsOpen;
    private Switch switchIsOpenYh;
    private TextView tvResults;
    private int lastCount;
    private boolean isFirstOpen=true;
    private EditText etYhBeTime;
    private EditText etLikePoint;
    private EditText etCommentPoint;
    private CommonMsgDialog msgDialog;
    private EditText etMaxLikeSize;
    private EditText etLiveBetweenTime;
    private List<FloatItem> itemList=new ArrayList<>();
    private FloatLogoMenu mFloatMenu;
    private Switch switchIsAddRandom;
    private Switch switchIsAutoClose;
    private Switch switchIsSingleLivingRoom;
    private Switch switchIsAutoClickLike;
    private Intent intent;
    private MyNotifyService.MyWorkService workService;
    private Switch switchIsOpenLikeForever;
    private Switch switchIsOpenLikeBack;
    private EditText etLiveTopicContains;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (!isAccessibilitySettingsOn(this,
                AccessibilityAutoCommentAndClickLikeService.class.getName())) {// ????????????????????????
            if(msgDialog!=null&&msgDialog.isShowing()){
                msgDialog.dismiss();
                msgDialog=null;
            }
            msgDialog=new CommonMsgDialog(this);
            msgDialog.setCancelable(false);
            msgDialog.getHolder().tvTitle.setText("????????????");
            msgDialog.getHolder().tvSure.setText("?????????");
            msgDialog.getHolder().tvCancle.setVisibility(View.GONE);
            msgDialog.getHolder().tvMiddle.setVisibility(View.GONE);
            msgDialog.getHolder().tvContent.setText("??????????????????????????????????????????????????????????????????????????????");
            msgDialog.getHolder().llProgress.setVisibility(View.GONE);
            msgDialog.getHolder().tvSure.setOnClickListener(new NoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    msgDialog.dismiss();
                    jumpToSettingPage(MainActivity.this);// ?????????????????????
                }
            });
            msgDialog.show();
        } else {
            TsUtils.showTips( "???????????????????????????????????????");
            //do other things...
        }
        int viewedVideoCount=BaseApp.getSharedPreferenceUtil().getInt("viewedVideoCount");
        int nowCount=BaseApp.getSharedPreferenceUtil().getInt("count");
        int nowCommentCount=BaseApp.getSharedPreferenceUtil().getInt("commentCount");
        tvResults.setText("?????????????????????"+nowCount+"???  ?????????????????????"+nowCommentCount+"???"+"\n????????????????????????"+viewedVideoCount+"???");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        if(AccessibilityAutoCommentAndClickLikeService.isSwitchOpen){
            switchIsOpen.setChecked(true);
        }else{
            switchIsOpen.setChecked(false);

        }
    }

    //?????????????????????????????????????????????
    public static boolean isAccessibilitySettingsOn(Context context, String className) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices =
                    activityManager.getRunningServices(100);// ?????????????????????????????????
            if (runningServices.size() < 0) {
                return false;
            }
            for (int i = 0; i < runningServices.size(); i++) {
                ComponentName service = runningServices.get(i).service;
                if (service.getClassName().equals(className)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    //?????????????????????????????????????????????????????????????????????
    public static void jumpToSettingPage(Context context) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void bindViewWithId() {
        btStart=findViewById(R.id.bt_start);
        switchIsOpen=findViewById(R.id.s_is_open);
        switchIsOpenYh=findViewById(R.id.s_is_open_yh);
        switchIsAutoClose=findViewById(R.id.s_is_auto_close);
        switchIsAddRandom=findViewById(R.id.s_is_add_random);
        switchIsSingleLivingRoom=findViewById(R.id.s_is_single_living_room);
        switchIsAutoClickLike=findViewById(R.id.s_is_auto_click_like);
        switchIsOpenLikeForever=findViewById(R.id.s_is_open_zb_like_forever);
        tvResults =findViewById(R.id.tv_results);
        etYhBeTime =findViewById(R.id.et_yh_between_time);
        etLikePoint =findViewById(R.id.et_like_point);
        etMaxLikeSize =findViewById(R.id.et_max_like_size);
        etCommentPoint =findViewById(R.id.et_comment_point);
        etLiveBetweenTime =findViewById(R.id.et_live_between_time);
        etLiveTopicContains =findViewById(R.id.et_live_topic_contains);
        switchIsOpenLikeBack =findViewById(R.id.s_is_open_like_back);
    }

    @Override
    public void initFirst() {
        intent = new Intent();
        intent.setClass(this, MyNotifyService.class);
        startService(intent);
        bindService(intent,this,BIND_AUTO_CREATE);
        try {
            OutputStream os = Runtime.getRuntime().exec("su").getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initStatus();
        switchIsOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isSwitchOpen=switchIsOpen.isChecked();
                if(switchIsOpen.isChecked()){
                    switchIsOpen.setText("????????????");
                }else{
                    switchIsOpen.setText("????????????");
                }
            }
        });
        switchIsOpenLikeForever.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever=switchIsOpenLikeForever.isChecked();
                if(switchIsOpenLikeForever.isChecked()){
                    switchIsOpenLikeForever.setText("?????????????????????");
                }else{
                    switchIsOpenLikeForever.setText("?????????????????????");
                }
            }
        });
        switchIsAutoClickLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isAutoClickLike=switchIsAutoClickLike.isChecked();
                if(switchIsAutoClickLike.isChecked()){
                    switchIsAutoClickLike.setText("??????????????????");
                }else{
                    switchIsAutoClickLike.setText("?????????????????????");
                }
            }
        });
        switchIsOpenLikeBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode=switchIsOpenLikeBack.isChecked();
                if(switchIsOpenLikeBack.isChecked()){
                    switchIsOpenLikeBack.setText("???????????????");
                }else{
                    switchIsOpenLikeBack.setText("???????????????");
                }
            }
        });
        switchIsSingleLivingRoom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment=!switchIsSingleLivingRoom.isChecked();
                if(switchIsSingleLivingRoom.isChecked()){
                    switchIsSingleLivingRoom.setText("??????????????????");
                }else{
                    switchIsSingleLivingRoom.setText("??????????????????");
                }
            }
        });
        switchIsOpenYh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isOpenYh=!switchIsOpenYh.isChecked();
                if(switchIsOpenYh.isChecked()){
                    switchIsOpenYh.setText("?????????????????????");
                }else{
                    switchIsOpenYh.setText("?????????????????????");
                }
            }
        });
        switchIsAutoClose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.needAutoClose=switchIsAutoClose.isChecked();
                if(switchIsAutoClose.isChecked()){
                    switchIsAutoClose.setText("??????3???????????????");
                }else{
                    switchIsAutoClose.setText("??????????????????");
                }
            }
        });
        switchIsAddRandom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.needRandWords=switchIsAddRandom.isChecked();
                if(switchIsAddRandom.isChecked()){
                    switchIsAddRandom.setText("???????????????");
                }else{
                    switchIsAddRandom.setText("????????????");
                }
            }
        });
        btStart.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                boolean isYhBeTimeEmpty=MyUtils.isEmpty(etYhBeTime);
                initStatus();
                if(!isYhBeTimeEmpty){
                    AccessibilityAutoCommentAndClickLikeService.yhWaitTimeEveryVideo=Integer.parseInt(etYhBeTime.getText().toString().trim());
                }
                AccessibilityAutoCommentAndClickLikeService.refreshNowData();
                if(!MyUtils.isEmpty(etLikePoint)) {
                    AccessibilityAutoCommentAndClickLikeService.lickPercent = Integer.parseInt(etLikePoint.getText().toString().trim());
                }
                if(!MyUtils.isEmpty(etCommentPoint)) {
                    AccessibilityAutoCommentAndClickLikeService.commentPercent = Integer.parseInt(etCommentPoint.getText().toString().trim());
                }
                if(!MyUtils.isEmpty(etLiveBetweenTime)) {
                    AccessibilityAutoCommentAndClickLikeService.sendLivingCommentDelay= Integer.parseInt(etLiveBetweenTime.getText().toString().trim())*1000;
                }
                if(!MyUtils.isEmpty(etMaxLikeSize)) {
                    AccessibilityAutoCommentAndClickLikeService.maxClickLikeSize = Integer.parseInt(etMaxLikeSize.getText().toString().trim());
                    if(AccessibilityAutoCommentAndClickLikeService.maxClickLikeSize<=0){
                        AccessibilityAutoCommentAndClickLikeService.maxClickLikeSize=50;
                    }
                }
                if(MyUtils.isEmpty(etLiveTopicContains)){
                    AccessibilityAutoCommentAndClickLikeService.needTopic="";
                }else{
                    AccessibilityAutoCommentAndClickLikeService.needTopic=etLiveTopicContains.getText().toString().trim();
                }
                BaseApp.getSharedPreferenceUtil().saveInt("count",0);
                BaseApp.getSharedPreferenceUtil().saveInt("commentCount",0);
                BaseApp.getSharedPreferenceUtil().saveInt("viewedVideoCount",0);
                RequestOverlayPermission();
            }
        });
        TsUtils.showTips("??????????????????");
    }

    private void initStatus() {
        AccessibilityAutoCommentAndClickLikeService.isSwitchOpen=switchIsOpen.isChecked();
        AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever=switchIsOpenLikeForever.isChecked();
        AccessibilityAutoCommentAndClickLikeService.isAutoClickLike=switchIsAutoClickLike.isChecked();
        AccessibilityAutoCommentAndClickLikeService.isOpenYh=!switchIsOpenYh.isChecked();
        AccessibilityAutoCommentAndClickLikeService.needAutoClose=switchIsAutoClose.isChecked();
        AccessibilityAutoCommentAndClickLikeService.needRandWords=switchIsAddRandom.isChecked();
    }

    @Override
    public void onDestroy() {
        unbindService(this);
        stopService(intent);
        super.onDestroy();
    }

    // ???????????????????????????
    private void RequestOverlayPermission()
    {
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (!Settings.canDrawOverlays(this))
            {
                String ACTION_MANAGE_OVERLAY_PERMISSION = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
                Intent intent = new Intent(ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, REQUEST_OVERLAY);
            }
            else
            {
//                openFloatView();
                launchDouYin();
            }
        }
    }

    /** Activity??????????????????????????? */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Toast.makeText(activity, "onActivityResult???????????????", Toast.LENGTH_SHORT).show();
        if (requestCode == REQUEST_OVERLAY)		// ?????????????????????????????????
        {
            if(resultCode == RESULT_OK)
            {
                LogUtils.i("??????????????????ok???");
                openFloatView();
            }
        }
    }





    /**
     * ???????????????
     */
    private void openFloatView() {
        if(mFloatMenu==null) {
            initData();
            mFloatMenu = new FloatLogoMenu.Builder()
                      .withContext(workService.getService().getApplication())//?????????7.0?????????7.0????????????????????????7.0?????????????????????????????????????????????????????????<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
                    .logo(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_main))
                    .drawCicleMenuBg(false)
                    .backMenuColor(0xffe4e3e1)
                    .setBgDrawable(new ColorDrawable(Color.parseColor("#ebebeb")))
                    //????????????????????????logo??????????????????
                    .setFloatItems(itemList)
                    .defaultLocation(FloatLogoMenu.LEFT)
                    .drawRedPointNum(false)
                    .showWithListener(new FloatMenuView.OnMenuClickListener() {
                        @Override
                        public void onItemClick(int position, String title) {
                            if(position==0) {
                                if(AccessibilityAutoCommentAndClickLikeService.isSwitchOpen){
                                    switchIsOpen.setChecked(false);
                                    TsUtils.showTips("?????????????????????");
                                }else{
                                    switchIsOpen.setChecked(true);
                                    TsUtils.showTips("????????????");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isSwitchOpen=switchIsOpen.isChecked();
                                itemList.get(0).setTitle("??????:" + (AccessibilityAutoCommentAndClickLikeService.isSwitchOpen ? "???" : "???"));
                                mFloatMenu.openMenu();
                            }else if (position == 1) {
                                if (AccessibilityAutoCommentAndClickLikeService.isOpenYh) {
                                    AccessibilityAutoCommentAndClickLikeService.isOpenYh = false;
                                    switchIsOpenYh.setChecked(AccessibilityAutoCommentAndClickLikeService.isOpenYh);
                                    String nowYhStr="????????????";
                                    String nowXfStr="????????????";
                                    String nowStr=AccessibilityAutoCommentAndClickLikeService.isOpenYh?nowYhStr:nowXfStr;
                                    LogUtils.i(nowYhStr);
                                    itemList.get(1).setTitle(nowStr);
                                    TsUtils.showTips("????????????????????????");
                                    mFloatMenu.openMenu();
                                }else{
                                    AccessibilityAutoCommentAndClickLikeService.isOpenYh = true;
                                    switchIsOpenYh.setChecked(AccessibilityAutoCommentAndClickLikeService.isOpenYh);
                                    String nowYhStr="????????????";
                                    String nowXfStr="????????????";
                                    String nowStr=AccessibilityAutoCommentAndClickLikeService.isOpenYh?nowYhStr:nowXfStr;
                                    LogUtils.i(nowYhStr);
                                    itemList.get(1).setTitle(nowStr);
                                    TsUtils.showTips("????????????????????????");
                                    mFloatMenu.openMenu();
                                }
                            } else if (position == 2) {
                                if(AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode){
                                    switchIsOpenLikeBack.setChecked(false);
                                    TsUtils.showTips("??????????????????");
                                }else{
                                    switchIsOpenLikeBack.setChecked(true);
                                    TsUtils.showTips("??????????????????");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode=switchIsOpenLikeBack.isChecked();
                                itemList.get(2).setTitle("??????:" + (AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode ? "???" : "???"));
                                mFloatMenu.openMenu();
                            }else if(position==3) {
                                if(AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment){
                                    switchIsSingleLivingRoom.setChecked(false);
                                    TsUtils.showTips("???????????????????????????????????????");
                                }else{
                                    switchIsSingleLivingRoom.setChecked(true);
                                    TsUtils.showTips("???????????????????????????????????????");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment=switchIsSingleLivingRoom.isChecked();
                                itemList.get(3).setTitle("??????:" + (AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment ? "???" : "???"));
                                mFloatMenu.openMenu();
                            }else if(position==4) {
                                if(AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever){
                                    switchIsOpenLikeForever.setChecked(false);
                                    TsUtils.showTips("??????????????????????????????");
                                }else{
                                    switchIsOpenLikeForever.setChecked(true);
                                    TsUtils.showTips("??????????????????????????????");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever=switchIsOpenLikeForever.isChecked();
                                itemList.get(4).setTitle("??????:" + (AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever ? "???" : "???"));
                                mFloatMenu.openMenu();
                            }
                        }

                        @Override
                        public void dismiss() {

                        }
                    });
            launchDouYin();
        }else{
            launchDouYin();
        }
    }

    private void initData() {
        itemList.clear();
        final boolean isOpenYh = AccessibilityAutoCommentAndClickLikeService.isOpenYh;
        final boolean isSwitchOpen = AccessibilityAutoCommentAndClickLikeService.isSwitchOpen;
        final boolean isSingleMode = AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment;
        final boolean isLikeForever = AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever;
        final boolean isOpenBackLikeMode = AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode;
        String nowYhStr="????????????";
        String nowXfStr="????????????";
        String nowStr=isOpenYh?nowYhStr:nowXfStr;
        FloatItem floatItem1 = new FloatItem("??????:" + (isSwitchOpen ? "???" : "???") , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_is_open));
        FloatItem floatItem2 = new FloatItem(nowStr, Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_like_png));
        FloatItem floatItem3 = new FloatItem(("?????????"+(isOpenBackLikeMode ? "???" : "???")) , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_living));
        FloatItem floatItem4 = new FloatItem("??????:" + (isSingleMode ? "???" : "???") , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_switch));
        FloatItem floatItem5 = new FloatItem("??????:" + (isLikeForever ? "???" : "???") , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_hot));
        itemList.add(floatItem1);
        itemList.add(floatItem2);
        itemList.add(floatItem3);
        itemList.add(floatItem4);
        itemList.add(floatItem5);
    }


    /**
     * ???????????????apk
     * ????????????  ??????????????????????????????????????????????????????????????????????????????
     * XXXXX ??? ??????
     */
    public  void launchDouYin() {
        PackageManager packageManager = getPackageManager();
        Intent it = packageManager.getLaunchIntentForPackage("com.ss.android.ugc.aweme");
        try {
            startActivity(it);
        }catch (Exception e){
            e.printStackTrace();
            TsUtils.showTips("??????????????????????????????????????????");
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        LogUtils.i("???????????????");
        TsUtils.showTips("?????????????????????");
        workService = ((MyNotifyService.MyWorkService) service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
