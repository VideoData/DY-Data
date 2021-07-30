package com.dy.autocomment;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.dy.autocomment.view.FloatTips;
import com.dy.autocomment.view.TsUtils;
import com.dy.fastframework.view.CommonMsgDialog;
import com.vise.utils.assist.RandomUtil;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Delayed;

import yin.deng.normalutils.utils.DownTimer;
import yin.deng.normalutils.utils.LogUtils;
import yin.deng.normalutils.utils.MyUtils;


/**
 * 自动点赞评论养号辅助
 * 适配版本 14.8.0 适配机型 小米9
 */
public class AccessibilityAutoCommentAndClickLikeService extends AccessibilityService {
    public static int lickCount=0;//当前总共点赞数量
    public static final int DOING_TASK=-1;//准备开始
    public static final int NORMAL=0;//准备开始
    public static final int COUNTING=1;//开始计时
    public static final int COUNT_OVER=2;//结束计时
    public static final int LIKEING=3;//点赞开始
    public static final int LIKE_OVER=4;//点赞结束
    public static final int COMMENTING=5;//评论开始
    public static final int COMMENT_OVER=6;//评论结束
    private static final int LIVING_RED_BAG = 7;//直播间发现并点击红包
    private static final int LIVING_CLICK_QIANG = 8;//正在抢红包
    private static final int CHECH_RED_BAG = 9;//正在检测红包是否存在
    public int nowState=NORMAL;
    public boolean isPauseTimer=true;
    AccessibilityEvent mAccessibilityEvent;
    public static boolean isSwitchOpen=false;//是否开启辅助
    public static boolean isAutoClickLike=true;//是否开启直播间自动点赞模式
    public static boolean isSingleLivingRoomComment=true;//是否只在同一直播间进行评论
    private DownTimer timer;
    public String adName="广告";
    /**************版本更新只需修改此部分的6个id即可***********************/
    //视频发布的左下角音乐封面id
    public String enterMainAcTag="com.ss.android.ugc.aweme:id/fne";
    //视频浏览时遇到的直播的底部中间的大的LinearLayoutId：包含点击进入直播间文字在内的父容器
    public String clickEnterInLivingRoom="com.ss.android.ugc.aweme:id/eyv";
    //软键盘弹起后的评论输入框id
    private String commentEditTextStr="com.ss.android.ugc.aweme:id/b4m";
    //评论发送按钮的id
    private String sendBtStr="com.ss.android.ugc.aweme:id/b5c";
    /********************直播间循环发言****************/
    //直播间右上角的观众人数TextView
    private String livingRoomTopRightPeopleLinearId="com.ss.android.ugc.aweme:id/g3k";
    //直播间话题TextViewId
    private String livingTopicId="com.ss.android.ugc.aweme:id/d13";

    /***************下方为赞回访id，暂不需要***********************/
    private String mainZanAcId="com.ss.android.ugc.aweme:id/dr8";//判断是否在赞页面标题id
    private String itemNeedZanId="com.ss.android.ugc.aweme:id/e43";//需要点赞的人物昵称id
    private String dyId="com.ss.android.ugc.aweme:id/g42";//是否在个人资料页动态按钮父布局LinearLayout的ID
    private String lastDTPicId="com.ss.android.ugc.aweme:id/d0l";//最新的一条动态的封面图ID
    private String redBagRootId="com.ss.android.ugc.aweme:id/fw0";//装福袋和红包的父容器
    private boolean isSwiping=false;
    public static int commentCount=0;
    public static boolean isOpenYh=true;//是否开启养号功能
    private boolean isClickingLike=false;
    public static int viewedVideoCount=0;//已观看的视频总数
    private String headOfRedBagSenderId="com.ss.android.ugc.aweme:id/blr";//中间大圆形倒计时的id
    private String qiangId="com.ss.android.ugc.aweme:id/fgu";//抢字id
    private String updateCancleBtId="com.ss.android.ugc.aweme:id/ctq";//更新提示的取消按钮id
    private boolean isClickingLeftTop=false;
    private long lastClickLivingLikeTime=0;//上次直播点赞时间
    private long LivingLikeClickBetweenTime=60*1000;//一分钟给主播点赞一次
    private long lastclickBottomLinearTime =0;//上次点击左上角红包按钮的时间
    /*************************基础配置*******************************************/
    private boolean isKillSelfDoing=false;
    public static int yhWaitTimeEveryVideo=5;//养号页面停留时间
    public static int maxClickLikeSize=80;//最多可以点赞80个视频
    public static int lickPercent=70;//点赞概率
    public static int commentPercent=60;//评论概率
    public static long sendLivingCommentDelay=7000;//每隔7秒发一条评论
    private int sendLivingCommentCount=0;//单个直播间发送的总评论数
    public static  boolean needRandWords=true;//是否需要随机字符串
    public static  boolean needAutoClose=false;//是否需要自动关闭所有程序
    private double livingPeopleCount=20;//单直播间发言时，人数最低要求
    private double NotSingleModelivingPeopleCount=20;//轮流直播间发言时直播间最低人数要求
    public static boolean isOpenClickLikeForever=false;//无限点赞
    public static boolean isOpenBackLikeMode=false;//是否开启赞回访模式
    /*****************************************************************************/
    private int nowIndex=0;//当前正则操作的回赞角标
    private boolean isLikeBackDoing=false;//是否正在做赞回访操作
    private boolean isReFind=false;
    private String lastHeadName;//最底部的名字
    private int backCount;//赞回访人数
    public static String needTopic;

    /**
     * 重置当前所有标记类数据
     */
    public static void refreshNowData() {

    }


    long lastDoTime=0;
    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        if(event.getKeyCode()==KeyEvent.KEYCODE_VOLUME_DOWN){
            if(System.currentTimeMillis()-lastDoTime>1000) {
                lastDoTime=System.currentTimeMillis();
                if (isSwitchOpen) {
                    isSwitchOpen = false;
                    showTs("暂停任务");
                } else {
                    isSwitchOpen = true;
                    showTs("开始任务");
                }
            }
        }
        return super.onKeyEvent(event);
    }

    SimpleDateFormat format=new SimpleDateFormat("HH");

    @Override
    public void onAccessibilityEvent(final AccessibilityEvent event) {
        mAccessibilityEvent = event;
        if (!isSwitchOpen) {
            LogUtils.v("已关闭辅助");
            return;
        }
        closeUpdateDialog();
        if(isOpenBackLikeMode){
            //赞回访模式
            doHfMode(event);
            return;
        }
        if (!isOpenYh) {
            if(isClickZan){
                LogUtils.i("正在点赞");
                return;
            }
            if (isSwiping) {
                LogUtils.i("正在滑动下一个直播间");
                return;
            }
            if(isOpenClickLikeForever){
                doClickLikeInLivingRoomForever();
                return;
            }else{
                LogUtils.i("无限点赞已关闭");
            }
            List<AccessibilityNodeInfo> node = findNodesById(livingRoomTopRightPeopleLinearId);
            if(isOk(node)&&node.get(0)!=null&&nowState==NORMAL){
                LogUtils.i("进入了直播间");
                if(needAutoClose){
                    String nowHour=format.format(new Date());
                    int nowHourNum=Integer.parseInt(nowHour);
                    if(nowHourNum>=3&&nowHourNum<6) {
                        LogUtils.i("当前时间凌晨3点-6点之间，自动重启手机杀进程");
                        isKillSelfDoing = true;
                        killAll(true);
                        isKillSelfDoing = false;
                        return;
                    }
                }
                CharSequence personCount = node.get(0).getText();
                if(TextUtils.isEmpty(personCount)){
                    return;
                }
                String personCountStr= (String) personCount;
                LogUtils.i("在线用户数："+personCountStr);
                boolean isUsefulLivingRoom=false;//是否是有用的直播间
                boolean isCountOk=false;//人数是否达标
                if(personCountStr.endsWith("万")){
                    isCountOk=true;
                }else{
                    double personCountNum=Double.parseDouble(personCountStr);
                    if(personCountNum>=livingPeopleCount){
                        isCountOk=true;
                    }
                    if(!isSingleLivingRoomComment){
                        if(personCountNum>=NotSingleModelivingPeopleCount){
                            isCountOk=true;
                        }
                    }
                }
                boolean isTopicOk=false;//话题是否达标
                List<AccessibilityNodeInfo> topicNode = findNodesById(livingTopicId);
                if(isOk(topicNode)){
                    String topicStr= (String) topicNode.get(0).getText();
                    LogUtils.i("直播话题："+topicStr);
                    if(topicStr!=null){
                        if(!MyUtils.isEmpty(needTopic)){
                            if(topicStr.contains(needTopic)){
                                isTopicOk=true;
                            }else{
                                isCountOk=false;
                            }
                        }else {
                            isTopicOk = true;
                        }
                    }
                }else{
                    LogUtils.i("未找到话题节点");
                    isTopicOk = true;
                }
                isUsefulLivingRoom=isTopicOk&&isCountOk;
                LogUtils.i("是否满足要求："+isUsefulLivingRoom+",话题："+isTopicOk+",人数："+isCountOk);
                //如果是直播间，执行直播的对应任务
                if(isAutoClickLike&&isUsefulLivingRoom&&System.currentTimeMillis()-lastClickLivingLikeTime>=LivingLikeClickBetweenTime){
                    doClickLikeInLivingRoom();
                }else {
                    if(isUsefulLivingRoom) {
                        long betweenTime = System.currentTimeMillis() - lastclickBottomLinearTime;
                        if (betweenTime <= sendLivingCommentDelay) {
                            return;
                        }
                        LogUtils.i("时间差：" + betweenTime + ",预设时间差：" + sendLivingCommentDelay);
                        doLivingTask();
                    }else{
                        showTs("该直播间不符合"+(isTopicOk?(isCountOk?"人数":"人数和话题"):"话题")+"要求");
                    }
//                    else{
//                        showTs("在线人数或话题未满足，换房间");
//                        isSwiping = true;
//                        openNextOne();
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                isSwiping = false;
//                                nowState = NORMAL;
//                            }
//                        }, 3000);
//                    }
                }
            }
            return;
        }
        //开始干活
        switch (nowState) {
            case DOING_TASK:
                break;
            case NORMAL:
                if (isSwiping) {
                    return;
                }
                LogUtils.d("开始干活了，当前类型：" + nowState);
                if(isKillSelfDoing){
                    return;
                }
                if(lickCount>=maxClickLikeSize){
                    isKillSelfDoing=true;
                    killAll(false);
                    isKillSelfDoing=false;
                    return;
                }
                isClickLikeThis=false;
                List<AccessibilityNodeInfo> nodes = findNodesById(enterMainAcTag);
                if (isOk(nodes)) {
                    LogUtils.d("找到音乐播放图标");
                    List<AccessibilityNodeInfo> nodeIsLiving = findNodesById(clickEnterInLivingRoom);
                    List<AccessibilityNodeInfo> nodeIsIsAd = findNodesByText(adName);
                    if (isOk(nodeIsLiving)) {
                        showTs("直播间，直接划过");
                        LogUtils.e("直播间，直接划过");
                        viewedVideoCount--;
                        BaseApp.getSharedPreferenceUtil().saveInt("viewedVideoCount",viewedVideoCount);
                        isSwiping = true;
                        openNextOne();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                isSwiping = false;
                                nowState = NORMAL;
                            }
                        }, 1000);
                    } else {
                        if (isOk(nodeIsIsAd)) {
                            showTs("广告内容，直接划过");
                            LogUtils.e("广告内容，直接划过");
                            viewedVideoCount--;
                            BaseApp.getSharedPreferenceUtil().saveInt("viewedVideoCount",viewedVideoCount);
                            isSwiping = true;
                            openNextOne();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    isSwiping = false;
                                    nowState = NORMAL;
                                }
                            }, 1000);
                        } else {
                            startTimer();
                        }
                    }
                } else {
                    LogUtils.e("暂未找到音乐播放图标");
                }
                break;
            case COUNTING:
                List<AccessibilityNodeInfo> nodesWhenCounting = findNodesById(enterMainAcTag);
                if (!isOk(nodesWhenCounting)) {
                    if (!isPauseTimer && timer != null) {
                        timer.pause();
                        LogUtils.e("计时中，找不到音乐播放图标，暂停计时");
                        isPauseTimer = true;
                        showTs("页面已切换，暂停任务计时");
                    }
                } else {
                    if (timer != null && isPauseTimer) {
                        timer.resume();
                        isPauseTimer = false;
                        showTs("页面已恢复，继续上次任务");
                        LogUtils.v("计时中，找到音乐播放图标，继续计时");
                    }
                }
                break;
            case COUNT_OVER:
                LogUtils.d("计时结束了，当前类型：" + nowState);
                List<AccessibilityNodeInfo> nodesWhenCountOver = findNodesById(enterMainAcTag);
                if (isOk(nodesWhenCountOver)) {
                    setIsClickLike();
                } else {
                    nowState = NORMAL;
                }
                break;
            case LIKEING:
                if (isClickingLike) {
                    return;
                }
                LogUtils.d("开始点赞了，当前类型：" + nowState);
                List<AccessibilityNodeInfo> nodesWhenLiking = findNodesById(enterMainAcTag);
                if (isOk(nodesWhenLiking)) {
                    isClickingLike = true;
                    clickLike();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nowState = LIKE_OVER;
                            isClickingLike = false;
                        }
                    }, 1000);
                } else {
                    nowState = NORMAL;
                }
                break;
            case LIKE_OVER:
                LogUtils.d("点赞结束了，当前类型：" + nowState);
                List<AccessibilityNodeInfo> nodesWhenCountLikeOver = findNodesById(enterMainAcTag);
                if (isOk(nodesWhenCountLikeOver)) {
                    setIsNeedComment();
                } else {
                    nowState = NORMAL;
                }
                break;
            case COMMENTING:
                commentText();
                break;
            case COMMENT_OVER:
                isClickLikeThis=false;
                if (isSwiping) {
                    return;
                }
                isSwiping = true;
                LogUtils.d("评论结束了，当前类型：" + nowState);
                openNextOne();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nowState = NORMAL;
                        isSwiping = false;
                    }
                }, 1000);
                break;
            case LIVING_RED_BAG:
                //开始查找红包的弹框是否出现了，或者已抢完的弹框是否出现了

                break;
        }
    }


    /**
     * 处理赞回访模式
     * @param event
     */
    public static final int HF_NORMAL=0;//待命/完成状态
    public static final int HF_FINDHEAD=1;//查找头像进行点击的状态
    public static final int HF_FIND_DT=2;//查找动态进行点击状态
    public static final int HF_FIND_LAST_DT=3;//查找最新一条动态进行点赞状态
    public static final int HF_PAGE_OVER=4;//一页已经点击完成应该滑动的状态
    public static final int HF_OVER=5;//全部任务完成状态
    public  int nowHfType=HF_NORMAL;
    private void doHfMode(AccessibilityEvent event) {
        switch (nowHfType){
            case HF_NORMAL:
                List<AccessibilityNodeInfo> nodeIsInZanAc = findNodesById(mainZanAcId);
                if(isOk(nodeIsInZanAc)&&nodeIsInZanAc.get(0)!=null&&"赞".equals(nodeIsInZanAc.get(0).getText().toString())) {
                    LogUtils.i("任务开始");
                    backCount=0;
                    nowHfType = HF_FINDHEAD;
                    isReFind=false;
                    isLikeBackDoing=false;
                    isSwiping=false;
                    lastHeadName=null;
                }else{
                    LogUtils.i("当前页面不满足条件");
                }
                break;
            case HF_FINDHEAD:
                findHeadAndClick();
                break;
            case HF_FIND_DT:
                findDtBtAndClick(false);
                break;
            case HF_FIND_LAST_DT:
                LogUtils.i("最新的动态已经点赞");
                findLastDt();
                break;
            case HF_PAGE_OVER:
                switchNextOneTop();
                break;
            case HF_OVER:
                showDialog("赞回访已全部完成，共计回访人数："+backCount+"人！");
                break;
        }
    }

    private void findHeadAndClick() {
        if(isLikeBackDoing){
            return;
        }
        List<AccessibilityNodeInfo> nodeHead = findNodesById(itemNeedZanId);
        if(isOk(nodeHead)){
            LogUtils.i("当前需要点赞的条目总数："+nodeHead.size()+"个");
            if(nodeHead.size()>=1) {
                String firstHeadName = nodeHead.get(1).getText().toString();
                if (!MyUtils.isEmpty(firstHeadName)) {
                    if (firstHeadName.equals(lastHeadName)) {
                        //赞回访完毕了
                        nowState = HF_OVER;
                        LogUtils.w("赞回访完毕");
                        return;
                    }
                }
            }
            isLikeBackDoing=true;
            if(nowIndex==0) {
                nowIndex = nodeHead.size() - 1;
            }
            Rect rect=new Rect();
            nodeHead.get(nowIndex).getBoundsInScreen(rect);
            int x=rect.centerX();
            int y=rect.centerY();
            if(y>2200){
                nowIndex--;
                nowHfType=HF_FINDHEAD;
                isLikeBackDoing=false;
                return;
            }
            forceClick(rect.centerX(),rect.centerY());
            lastHeadName=nodeHead.get(nowIndex).getText().toString();
            nowIndex--;
            nowHfType=HF_FIND_DT;
            //切入查找动态模式
        }else{
            try {
                Thread.sleep(2000);
                findHeadAndClick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void findDtBtAndClick(boolean isInVoid) {
        List<AccessibilityNodeInfo> nodeDyId = findNodesById(dyId);
        LogUtils.i("找到个人资料页面了");
        if(isOk(nodeDyId)){
            Rect rect=new Rect();
            nodeDyId.get(0).getBoundsInScreen(rect);
            forceClick(rect.centerX(),rect.centerY());
            //点击动态按钮
            LogUtils.i("点击了动态按钮");
            try {
                Thread.sleep(500);
                nowHfType=HF_FIND_LAST_DT;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            if(isInVoid){
                backToZanAc();
                return;
            }
            try {
                Thread.sleep(2000);
                findDtBtAndClick(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void findLastDt() {
        //最后一条动态已经点赞完毕
        List<AccessibilityNodeInfo> mostNewNode = findNodesById(lastDTPicId);
        if(isOk(mostNewNode)){
            LogUtils.w("双击点赞");
            isReFind=false;
            //找到了最新的动态的封面图
            doubleClickToLike(mostNewNode);
            backCount++;
        }else{
            LogUtils.w("没找到最新动态");
            //没有找到，再找一次
            if(isReFind){
                isReFind=false;
                backToZanAc();
                return;
            }
            try {
                Thread.sleep(2000);
                isReFind=true;
                findLastDt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doubleClickToLike(List<AccessibilityNodeInfo> mostNewNode) {
        Rect rect=new Rect();
        mostNewNode.get(0).getBoundsInScreen(rect);
        int x=rect.centerX();
        int y=rect.centerY();
        if(rect.centerX()<=0){
            x=400;
        }
        if(rect.centerY()<=0){
            y=2000;
        }
        try {
            forceClick(x,y);
            Thread.sleep(200);
            forceClick(x,y);
            Thread.sleep(1000);
            backToZanAc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void backToZanAc() {
        forceBack();
        try {
            Thread.sleep(1500);
            if(nowIndex<=0){
                nowHfType=HF_PAGE_OVER;
                isLikeBackDoing=false;
                LogUtils.i("需要上滑列表重新找人了");
            }else{
                nowHfType=HF_FINDHEAD;
                isLikeBackDoing=false;
                LogUtils.i("继续下一个人的回访");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doClickLikeInLivingRoom() {
        isClickZan=true;
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<30;i++){
                    try {
                        forceClick(500, 500);
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lastClickLivingLikeTime=System.currentTimeMillis();
                isClickZan=false;
            }
        }.start();

    }


    public void closeUpdateDialog(){
        List<AccessibilityNodeInfo> nodeCancleBt = findNodesById(updateCancleBtId);
        if(isOk(nodeCancleBt)){
            nodeCancleBt.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            LogUtils.i("关闭更新提示");
        }
    }

    private void doClickLikeInLivingRoomForever() {
        isClickZan=true;
        new Thread(){
            @Override
            public void run() {
                while (isOpenClickLikeForever){
                    try {
                        forceClick(500, 500);
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lastClickLivingLikeTime=System.currentTimeMillis();
                isSwiping=false;
                isClickZan=false;
            }
        }.start();

    }


    /**
     * 执行直播间对应任务
     */
    boolean isLivingTaskDoing=false;
    private void doLivingTask() {
        if(isLivingTaskDoing){
            return;
        }
        if(!isSwitchOpen){
            return;
        }
        isLivingTaskDoing=true;
        //点击底部框
        try {
            forceClick(211,2264);
            lastclickBottomLinearTime=System.currentTimeMillis();
            Thread.sleep(1000);
            findEditextAndSendMsg();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public void findEditextAndSendMsg() throws InterruptedException {
        if(!isSwitchOpen){
            return;
        }
//        List<AccessibilityNodeInfo> nodeEditTextParent = findNodesById(editTextParenetId);
        AccessibilityNodeInfo nodeEditTextParent = findFocus(AccessibilityNodeInfo.ACTION_FOCUS);
        if(nodeEditTextParent!=null){
            LogUtils.i("找到输入框了");
            //输入框已经出现
//            setNodeText(nodeEditTextParent.get(0).getChild(0),getLiveCommentText());
            setNodeText(nodeEditTextParent,getLiveCommentText());
            //点击发送按钮
            Thread.sleep(1000);
            forceClick(1000,1340);
            Thread.sleep(1000);
            forceClick(500, 500);
            Thread.sleep(1000);
            if(isSingleLivingRoomComment) {
                isLivingTaskDoing = false;
                sendLivingCommentCount++;
                showTs("已发送评论" + sendLivingCommentCount + "条");
            }else{
                isSwiping = true;
                openNextOne();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isSwiping = false;
                        isLivingTaskDoing = false;
                        nowState = NORMAL;
                    }
                }, 2000);
                sendLivingCommentCount++;
                showTs("已发送评论" + sendLivingCommentCount + "条");
            }
        }else{
            LogUtils.i("没找到输入框");
            //输入框未出现,重新点击底部
            isLivingTaskDoing=false;
            findEditextAndSendMsg();
        }
    }

    /**
     * 遍历元素，查找是否存在红包图标
     * @param accessibilityNodeInfo
     * @return
     */
    private boolean checkHasRedBag(AccessibilityNodeInfo accessibilityNodeInfo) {
        if(accessibilityNodeInfo==null){
            LogUtils.e("未找到任何按钮，不点击:"+nowState);
            nowState = NORMAL;
            return false;
        }
        if(accessibilityNodeInfo.getChildCount()>0){
            checkHasRedBag(accessibilityNodeInfo.getChild(0));
        }else{
            if(accessibilityNodeInfo.getClassName().equals("android.widget.ImageView")){
                nowState = NORMAL;
                LogUtils.e("找到福袋，不点击,状态"+nowState);
                return false;
            }else{
                LogUtils.e("找到红包按钮，点击状态："+nowState);
                if(isClickingLeftTop){
                    return false;
                }
                isClickingLeftTop=true;
                LogUtils.i("开始点击左上角按钮");
                forceClick(80,350);
                lastclickBottomLinearTime =System.currentTimeMillis();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nowState = LIVING_RED_BAG;
                        isClickingLeftTop=false;
                        LogUtils.w("当前状态："+nowState);
                    }
                }, 1000);
                return true;
            }
        }
        return false;
    }


    /**
     * 判断是否是直播间
     * @return
     */
    private boolean findIsLivingRoom() {
        List<AccessibilityNodeInfo> node = findNodesById(livingRoomTopRightPeopleLinearId);
        if(isOk(node)){
            return true;
        }
        return false;
    }


    private void commentText() {
        if(nowState==DOING_TASK){
            return;
        }
        nowState=DOING_TASK;
        forceClick(1000,1605);//打开评论面板
        showTs("打开评论面板");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                forceClick(360,2270);//打开评论面板
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<AccessibilityNodeInfo> nodeEditext = findNodesById(commentEditTextStr);
                        setNodeText(nodeEditext.get(0), getCommentText());
                        showTs("输入评论内容");
                        final List<AccessibilityNodeInfo> sendBt = findNodesById(sendBtStr);
                        sendBt.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        commentCount++;
                        showTs("发送评论成功");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                forceBack();
                                showTs("关闭评论对话框,滑动到下一个");
                                BaseApp.getSharedPreferenceUtil().saveInt("commentCount", commentCount);
                                LogUtils.d("评论结束了，当前类型："+nowState);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                            openNextOne(new GestureResultCallback() {
                                                @Override
                                                public void onCompleted(GestureDescription gestureDescription) {
                                                    super.onCompleted(gestureDescription);
                                                    showTs("滑动完成");
                                                    LogUtils.i("滑动结束");
                                                    nowState = NORMAL;
                                                }
                                            });
                                        }
                                    }
                                }, 1000);
                            }
                        }, 500);
                    }
                }, 1000);
            }
        }, 1000);



//        lastDoTime=System.currentTimeMillis();
//        List<AccessibilityNodeInfo> node = findNodesById(commentIsOpenStr);
//        List<AccessibilityNodeInfo> nodeEditext = findNodesById(commentEditTextStr);
//        if(!isOk(node)) {
//            if(!isOk(nodeEditext)){
//                LogUtils.d("点击坐标打开评论框");
//                //什么都没有点的情况
//                forceClick(1000,1605);//打开评论面板
//            }else{
//                //已经弹起输入框的情况
//                LogUtils.d("输入评论内容");
//                setNodeText(nodeEditext.get(0), getCommentText());
//                final List<AccessibilityNodeInfo> sendBt = findNodesById(sendBtStr);
//                if(isOk(sendBt)){
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            sendBt.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                            commentCount++;
//                            forceBack();
//                            BaseApp.getSharedPreferenceUtil().saveInt("commentCount", commentCount);
//                            new Handler().postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    LogUtils.d("评论结束了，当前类型："+nowState);
//                                    openNextOne();
//                                    LogUtils.d("关闭评论对话框");
//                                    nowState = NORMAL;
//                                }
//                            }, 500);
//                            LogUtils.d("发送评论");
//                        }
//                    }, 1000);
//                }else{
//                    LogUtils.v("没有找到发送按钮");
//                }
//
//            }
//        }else{
//            LogUtils.v("评论面板已经打开");
//            if(isOpeningCommentBottomLinear){
//                return;
//            }
//            isOpeningCommentBottomLinear=true;
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    //评论面板已经打开
//                    forceClick(436, 2250);
//                    isOpeningCommentBottomLinear=false;
//                    //弹起输入框
//                }
//            }, 800);
//
//        }

    }


    /*
     * 杀死后台进程
     */
    public void killAll(boolean needReOpenPhone){
        isSwitchOpen = false;
        showTs("任务已结束");
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
            }
        },200);
    }




    private void reOpenPhone() {
        LogUtils.v("关机重启");
        String cmd="reboot";
        doCmd(cmd);
    }

    private void forceBack() {
        LogUtils.v("点击返回键");
        String cmd="input keyevent 4";
        doCmd(cmd);
    }

    private void setIsNeedComment() {
        int isNeedComment=RandomUtil.getRandom(100);
        LogUtils.e("预设评论概率："+commentPercent+",当前随机数值为："+isNeedComment);
        if(!isClickLikeThis){
            nowState=COMMENT_OVER;
            return;
        }
        if(isNeedComment<=commentPercent){
            nowState=COMMENTING;
            showTs("进行评论");
        }else{
            nowState=COMMENT_OVER;
        }
    }


    private void setIsClickLike() {
        int isClickLike=RandomUtil.getRandom(100);
        List<AccessibilityNodeInfo> nodesFriends = findNodesByText("你的好友");
        if(isOk(nodesFriends)){
            isClickLike=80;
            showTs("这是我的好友，点赞概率变大");
        }
        LogUtils.e("预设点赞概率："+lickPercent+",当前随机数值为："+isClickLike);
        if(isClickLike<=lickPercent){
            nowState=LIKEING;
            showTs("点个赞");
        }else{
            nowState=LIKE_OVER;
        }
    }

    private void showTs(final String msg) {
        LogUtils.i("当前操作："+msg);
        TsUtils.showTips(msg);
    }

    private void showDialog(final String msg) {
        Handler handlerThree=new Handler(Looper.getMainLooper());
        handlerThree.post(new Runnable(){
            public void run(){
                CommonMsgDialog msgDialog=new CommonMsgDialog(getApplicationContext());
                msgDialog.getHolder().tvTitle.setText("系统提示");
                msgDialog.getHolder().tvSure.setText("确定");
                msgDialog.getHolder().tvMiddle.setVisibility(View.GONE);
                msgDialog.getHolder().tvCancle.setVisibility(View.GONE);
                msgDialog.getHolder().tvContent.setText(msg);
                msgDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                msgDialog.show();
            }
        });
    }

    private void startTimer() {
        if(nowState==COUNTING){
            return;
        }
        showTs("开始新的计时任务");
        nowState=COUNTING;
        timer = new DownTimer();
        int rundTime = new Random().nextInt(5);
        timer.setTotalTime(yhWaitTimeEveryVideo*1000+rundTime*1000);
        timer.setIntervalTime(1000);
        timer.setTimerLiener(new DownTimer.TimeListener() {
            @Override
            public void onFinish() {
                timer=null;
                LogUtils.v("计时结束");
                nowState=COUNT_OVER;
                isPauseTimer=false;
            }

            @Override
            public void onInterval(long remainTime) {
                LogUtils.v("剩余时间："+remainTime/1000+"s");
            }
        });
        timer.start();
        isPauseTimer=false;
    }


    /**
     * 返回该节点是否存在或有效
     * @param nodes
     * @return
     */
    private boolean isOk(List<AccessibilityNodeInfo> nodes) {
        if(nodes!=null&&nodes.size()>0&&nodes.get(0).isEnabled()){
            return true;
        }
        return false;
    }


    /**
     * 获取评论词
     * @return
     */
    private String getCommentText() {
        String [] datas=getResources().getStringArray(R.array.comment_normal);
        String nowComment=datas[RandomUtil.getRandom(datas.length)];
        return nowComment;
    }

    /**
     * 获取评论词
     * @return
     */
    private String getLiveCommentText() {
        String [] datas=getResources().getStringArray(R.array.comments);
        String nowComment=datas[RandomUtil.getRandom(datas.length)];
        if(needRandWords){
            String x=RandomUtil.getRandomNumbersAndLetters(6);
            nowComment+=x;
        }
        return nowComment;
    }





    private void switchNextOneTop() {
        //上滑列表，状态改为查找头像进行回访
        if(isSwiping){
            return;
        }
        isSwiping=true;
        String move = "input swipe 560 500 560 1600";
        LogUtils.v("上滑");
        doCmd(move);
        try {
            Thread.sleep(2000);
            isSwiping=false;
            nowIndex=0;
            nowHfType=HF_FINDHEAD;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * 看下一个
     */
    private void openNextOne() {
//        String move="input swipe 560 1700 560 600";
//        LogUtils.v("滑动下一个视频");
//        doCmd(move);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Path path = new Path();
            path.moveTo(560 ,1700);
            path.lineTo(560, 600);
            LogUtils.v("开始滑动到下一个视频");
            dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription
                    (path, 20, 600)).build(), new GestureResultCallback() {
                @Override
                public void onCompleted(GestureDescription gestureDescription) {
                    super.onCompleted(gestureDescription);
                    LogUtils.v("滑动到下一个视频----已完成");
                    viewedVideoCount++;
                    BaseApp.getSharedPreferenceUtil().saveInt("viewedVideoCount",viewedVideoCount);
                }

                @Override
                public void onCancelled(GestureDescription gestureDescription) {
                    super.onCancelled(gestureDescription);
                    LogUtils.e("滑动到下一个视频----失败了");

                }
            }, new Handler(getMainLooper()));
            //滑动完成
        }
    }

    private void openNextOne(GestureResultCallback callback) {
//        String move="input swipe 560 1700 560 600";
//        LogUtils.v("滑动下一个视频");
//        doCmd(move);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Path path = new Path();
            path.moveTo(560 ,1700);
            path.lineTo(560, 600);
            LogUtils.v("开始滑动到下一个视频");
            dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription
                    (path, 20, 600)).build(),callback, new Handler(getMainLooper()));
            //滑动完成
        }
    }


    /**
     * 点个小红心
     */
    boolean isClickLikeThis=false;//本个视频是否点赞
    public void clickLike(){
        forceClick(1020, 1410);
        lickCount++;
        isClickLikeThis=true;
        BaseApp.getSharedPreferenceUtil().saveInt("count", lickCount);
    }


    /**
     * 取消赞任务
     */
    public void cancleTask(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(4000);
                        LogUtils.i("取消点赞");
                        clickLike();
                        Thread.sleep(400);
                        LogUtils.i("下一个");
                        openNextOne();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }





    long lastClickTime=0;
    boolean isClickZan=false;
    private void forceClick(int x,int y){
        if(!isClickZan&&System.currentTimeMillis()-lastClickTime<=200){
            LogUtils.w("点击冷却");
            return;
        }
        String cmd = "input tap " + String.valueOf(x) + " " + String.valueOf(y);
        LogUtils.v("当前点击的坐标："+x+","+y);
        doCmd(cmd);
    }


    public void doCmd(String cmd){
        try {
            OutputStream os;
            os = Runtime.getRuntime().exec("su").getOutputStream();
            os.write(cmd.getBytes());
            os.flush();//清空缓存
            os.close();//停止流
            LogUtils.e("命令执行完成");
        } catch (Exception e) {
            LogUtils.e(e.getMessage());
            LogUtils.v("命令出错了:"+e.getMessage());
        }
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        LogUtils.d("qqqqqq无障碍服务已开启");
        sendLivingCommentCount=0;
        lastclickBottomLinearTime=System.currentTimeMillis();
//        cancleTask();
    }

    public void setNodeText(AccessibilityNodeInfo node, String text)
    {
        Bundle arguments = new Bundle();
        arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text);
        node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
    }

    @Override
    public void onInterrupt() {

    }



    private AccessibilityNodeInfo getRootNodeInfo() {
        AccessibilityEvent curEvent = mAccessibilityEvent;
        AccessibilityNodeInfo nodeInfo = null;
        if (Build.VERSION.SDK_INT >= 16) {
                nodeInfo = getRootInActiveWindow();
        } else {
            nodeInfo = curEvent.getSource();
        }
        return nodeInfo;
    }

    public List<AccessibilityNodeInfo> findNodesByText(String text) {
        AccessibilityNodeInfo nodeInfo = getRootNodeInfo();
        if (nodeInfo != null) {
            Log.i("accessibility", "getClassName：" + nodeInfo.getClassName());
            Log.i("accessibility", "getText：" + nodeInfo.getText());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                //需要在xml文件中声明权限android:accessibilityFlags="flagReportViewIds"
                // 并且版本大于4.3 才能获取到view 的 ID
                Log.i("accessibility", "getClassName：" + nodeInfo.getViewIdResourceName());
            }
            return nodeInfo.findAccessibilityNodeInfosByText(text);
        }
        return null;
    }


    private AccessibilityNodeInfo getChildNodeInfos(String id, int childIndex) {
        List<AccessibilityNodeInfo> listChatRecord = findNodesById(id);
        if (listChatRecord == null || listChatRecord.size() == 0) {
            return null;
        }
        AccessibilityNodeInfo parentNode = listChatRecord.get(0);//该节点
        int count = parentNode.getChildCount();
        Log.i("accessibility", "子节点个数 " + count);
        return childIndex < count ? parentNode.getChild(childIndex) : null;
    }




    public List<AccessibilityNodeInfo> findNodesById(String viewId) {
        AccessibilityNodeInfo nodeInfo = getRootNodeInfo();
        if (nodeInfo != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return nodeInfo.findAccessibilityNodeInfosByViewId(viewId);
            }
        }
        return null;
    }
}