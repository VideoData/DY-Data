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
                AccessibilityAutoCommentAndClickLikeService.class.getName())) {// 判断服务是否开启
            if(msgDialog!=null&&msgDialog.isShowing()){
                msgDialog.dismiss();
                msgDialog=null;
            }
            msgDialog=new CommonMsgDialog(this);
            msgDialog.setCancelable(false);
            msgDialog.getHolder().tvTitle.setText("系统提示");
            msgDialog.getHolder().tvSure.setText("去开启");
            msgDialog.getHolder().tvCancle.setVisibility(View.GONE);
            msgDialog.getHolder().tvMiddle.setVisibility(View.GONE);
            msgDialog.getHolder().tvContent.setText("使用此功能需要开启无障碍服务，请点击去开启手动打开！");
            msgDialog.getHolder().llProgress.setVisibility(View.GONE);
            msgDialog.getHolder().tvSure.setOnClickListener(new NoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    msgDialog.dismiss();
                    jumpToSettingPage(MainActivity.this);// 跳转到开启页面
                }
            });
            msgDialog.show();
        } else {
            TsUtils.showTips( "无障碍服务已开启，准备就绪");
            //do other things...
        }
        int viewedVideoCount=BaseApp.getSharedPreferenceUtil().getInt("viewedVideoCount");
        int nowCount=BaseApp.getSharedPreferenceUtil().getInt("count");
        int nowCommentCount=BaseApp.getSharedPreferenceUtil().getInt("commentCount");
        tvResults.setText("上次点赞视频："+nowCount+"条  上次发送评论："+nowCommentCount+"条"+"\n上次共观看视频："+viewedVideoCount+"个");
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

    //判断自定义辅助功能服务是否开启
    public static boolean isAccessibilitySettingsOn(Context context, String className) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices =
                    activityManager.getRunningServices(100);// 获取正在运行的服务列表
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


    //跳转到设置页面无障碍服务开启自定义辅助功能服务
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
                    switchIsOpen.setText("任务开启");
                }else{
                    switchIsOpen.setText("任务关闭");
                }
            }
        });
        switchIsOpenLikeForever.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever=switchIsOpenLikeForever.isChecked();
                if(switchIsOpenLikeForever.isChecked()){
                    switchIsOpenLikeForever.setText("直播间循环点赞");
                }else{
                    switchIsOpenLikeForever.setText("直播不循环点赞");
                }
            }
        });
        switchIsAutoClickLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isAutoClickLike=switchIsAutoClickLike.isChecked();
                if(switchIsAutoClickLike.isChecked()){
                    switchIsAutoClickLike.setText("直播开始点赞");
                }else{
                    switchIsAutoClickLike.setText("直播开始不点赞");
                }
            }
        });
        switchIsOpenLikeBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode=switchIsOpenLikeBack.isChecked();
                if(switchIsOpenLikeBack.isChecked()){
                    switchIsOpenLikeBack.setText("赞回访模式");
                }else{
                    switchIsOpenLikeBack.setText("关闭赞回访");
                }
            }
        });
        switchIsSingleLivingRoom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment=!switchIsSingleLivingRoom.isChecked();
                if(switchIsSingleLivingRoom.isChecked()){
                    switchIsSingleLivingRoom.setText("多直播间吸粉");
                }else{
                    switchIsSingleLivingRoom.setText("单直播间吸粉");
                }
            }
        });
        switchIsOpenYh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.isOpenYh=!switchIsOpenYh.isChecked();
                if(switchIsOpenYh.isChecked()){
                    switchIsOpenYh.setText("直播间评论吸粉");
                }else{
                    switchIsOpenYh.setText("自动刷视频点赞");
                }
            }
        });
        switchIsAutoClose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.needAutoClose=switchIsAutoClose.isChecked();
                if(switchIsAutoClose.isChecked()){
                    switchIsAutoClose.setText("凌晨3点自动关闭");
                }else{
                    switchIsAutoClose.setText("无限执行任务");
                }
            }
        });
        switchIsAddRandom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AccessibilityAutoCommentAndClickLikeService.needRandWords=switchIsAddRandom.isChecked();
                if(switchIsAddRandom.isChecked()){
                    switchIsAddRandom.setText("防频繁发言");
                }else{
                    switchIsAddRandom.setText("不加后缀");
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
        TsUtils.showTips("准备开始任务");
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

    // 动态请求悬浮窗权限
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

    /** Activity执行结果，回调函数 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Toast.makeText(activity, "onActivityResult设置权限！", Toast.LENGTH_SHORT).show();
        if (requestCode == REQUEST_OVERLAY)		// 从应用权限设置界面返回
        {
            if(resultCode == RESULT_OK)
            {
                LogUtils.i("悬浮窗的权限ok了");
                openFloatView();
            }
        }
    }





    /**
     * 开启悬浮框
     */
    private void openFloatView() {
        if(mFloatMenu==null) {
            initData();
            mFloatMenu = new FloatLogoMenu.Builder()
                      .withContext(workService.getService().getApplication())//这个在7.0（包括7.0）以上以及大部分7.0以下的国产手机上需要用户授权，需要搭配<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
                    .logo(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_main))
                    .drawCicleMenuBg(false)
                    .backMenuColor(0xffe4e3e1)
                    .setBgDrawable(new ColorDrawable(Color.parseColor("#ebebeb")))
                    //这个背景色需要和logo的背景色一致
                    .setFloatItems(itemList)
                    .defaultLocation(FloatLogoMenu.LEFT)
                    .drawRedPointNum(false)
                    .showWithListener(new FloatMenuView.OnMenuClickListener() {
                        @Override
                        public void onItemClick(int position, String title) {
                            if(position==0) {
                                if(AccessibilityAutoCommentAndClickLikeService.isSwitchOpen){
                                    switchIsOpen.setChecked(false);
                                    TsUtils.showTips("已停止所有任务");
                                }else{
                                    switchIsOpen.setChecked(true);
                                    TsUtils.showTips("任务开始");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isSwitchOpen=switchIsOpen.isChecked();
                                itemList.get(0).setTitle("状态:" + (AccessibilityAutoCommentAndClickLikeService.isSwitchOpen ? "开" : "关"));
                                mFloatMenu.openMenu();
                            }else if (position == 1) {
                                if (AccessibilityAutoCommentAndClickLikeService.isOpenYh) {
                                    AccessibilityAutoCommentAndClickLikeService.isOpenYh = false;
                                    switchIsOpenYh.setChecked(AccessibilityAutoCommentAndClickLikeService.isOpenYh);
                                    String nowYhStr="养号：开";
                                    String nowXfStr="吸粉：开";
                                    String nowStr=AccessibilityAutoCommentAndClickLikeService.isOpenYh?nowYhStr:nowXfStr;
                                    LogUtils.i(nowYhStr);
                                    itemList.get(1).setTitle(nowStr);
                                    TsUtils.showTips("已切换到吸粉模式");
                                    mFloatMenu.openMenu();
                                }else{
                                    AccessibilityAutoCommentAndClickLikeService.isOpenYh = true;
                                    switchIsOpenYh.setChecked(AccessibilityAutoCommentAndClickLikeService.isOpenYh);
                                    String nowYhStr="养号：开";
                                    String nowXfStr="吸粉：开";
                                    String nowStr=AccessibilityAutoCommentAndClickLikeService.isOpenYh?nowYhStr:nowXfStr;
                                    LogUtils.i(nowYhStr);
                                    itemList.get(1).setTitle(nowStr);
                                    TsUtils.showTips("已切换到养号模式");
                                    mFloatMenu.openMenu();
                                }
                            } else if (position == 2) {
                                if(AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode){
                                    switchIsOpenLikeBack.setChecked(false);
                                    TsUtils.showTips("赞回访已关闭");
                                }else{
                                    switchIsOpenLikeBack.setChecked(true);
                                    TsUtils.showTips("赞回访已开启");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode=switchIsOpenLikeBack.isChecked();
                                itemList.get(2).setTitle("回访:" + (AccessibilityAutoCommentAndClickLikeService.isOpenBackLikeMode ? "关" : "开"));
                                mFloatMenu.openMenu();
                            }else if(position==3) {
                                if(AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment){
                                    switchIsSingleLivingRoom.setChecked(false);
                                    TsUtils.showTips("当前模式：多直播间循环评论");
                                }else{
                                    switchIsSingleLivingRoom.setChecked(true);
                                    TsUtils.showTips("当前模式：单直播间轮流评论");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment=switchIsSingleLivingRoom.isChecked();
                                itemList.get(3).setTitle("轮换:" + (AccessibilityAutoCommentAndClickLikeService.isSingleLivingRoomComment ? "关" : "开"));
                                mFloatMenu.openMenu();
                            }else if(position==4) {
                                if(AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever){
                                    switchIsOpenLikeForever.setChecked(false);
                                    TsUtils.showTips("已关闭直播间无限点赞");
                                }else{
                                    switchIsOpenLikeForever.setChecked(true);
                                    TsUtils.showTips("已开启直播间无限点赞");
                                }
                                AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever=switchIsOpenLikeForever.isChecked();
                                itemList.get(4).setTitle("人气:" + (AccessibilityAutoCommentAndClickLikeService.isOpenClickLikeForever ? "开" : "关"));
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
        String nowYhStr="养号：开";
        String nowXfStr="吸粉：开";
        String nowStr=isOpenYh?nowYhStr:nowXfStr;
        FloatItem floatItem1 = new FloatItem("状态:" + (isSwitchOpen ? "开" : "关") , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_is_open));
        FloatItem floatItem2 = new FloatItem(nowStr, Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_like_png));
        FloatItem floatItem3 = new FloatItem(("回访："+(isOpenBackLikeMode ? "开" : "关")) , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_living));
        FloatItem floatItem4 = new FloatItem("轮换:" + (isSingleMode ? "关" : "开") , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_switch));
        FloatItem floatItem5 = new FloatItem("人气:" + (isLikeForever ? "开" : "关") , Color.WHITE, getResources().getColor(R.color.normal_gray), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_hot));
        itemList.add(floatItem1);
        itemList.add(floatItem2);
        itemList.add(floatItem3);
        itemList.add(floatItem4);
        itemList.add(floatItem5);
    }


    /**
     * 启动第三方apk
     * 直接打开  每次都会启动到启动界面，每次都会干掉之前的，从新启动
     * XXXXX ： 包名
     */
    public  void launchDouYin() {
        PackageManager packageManager = getPackageManager();
        Intent it = packageManager.getLaunchIntentForPackage("com.ss.android.ugc.aweme");
        try {
            startActivity(it);
        }catch (Exception e){
            e.printStackTrace();
            TsUtils.showTips("启动失败，请确认您安装了抖音");
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        LogUtils.i("服务已开启");
        TsUtils.showTips("后台服务已开启");
        workService = ((MyNotifyService.MyWorkService) service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
