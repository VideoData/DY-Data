/*
 * Copyright (c) 2016, Shanghai YUEWEN Information Technology Co., Ltd.
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  Neither the name of Shanghai YUEWEN Information Technology Co., Ltd. nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY SHANGHAI YUEWEN INFORMATION TECHNOLOGY CO., LTD. AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.yw.game.floatmenu;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wengyiming on 2017/7/20.
 */
public class FloatLogoMenu {
    /**
     * 记录 logo 停放的位置，以备下次恢复
     */
    private static final String LOCATION_X = "hintLocation";
    private static final String LOCATION_Y = "locationY";

    /**
     * 悬浮球 坐落 左 右 标记
     */
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    /**
     * 记录系统状态栏的高度
     */
    private int mStatusBarHeight;
    /**
     * 记录当前手指位置在屏幕上的横坐标值
     */
    private float mXInScreen;

    /**
     * 记录当前手指位置在屏幕上的纵坐标值
     */
    private float mYInScreen;

    /**
     * 记录手指按下时在屏幕上的横坐标的值
     */
    private float mXDownInScreen;

    /**
     * 记录手指按下时在屏幕上的纵坐标的值
     */
    private float mYDownInScreen;

    /**
     * 记录手指按下时在小悬浮窗的View上的横坐标的值
     */
    private float mXInView;

    /**
     * 记录手指按下时在小悬浮窗的View上的纵坐标的值
     */
    private float mYinView;

    /**
     * 记录屏幕的宽度
     */
    private int mScreenWidth;

    /**
     * 来自 activity 的 wManager
     */
    private WindowManager wManager;


    /**
     * 为 wManager 设置 LayoutParams
     */
    private WindowManager.LayoutParams wmParams;

    /**
     * 带透明度动画、旋转、放大的悬浮球
     */
    private DotImageView mFloatLogo;


    /**
     * 用于 定时 隐藏 logo的定时器
     */
    private CountDownTimer mHideTimer;


    /**
     * float menu的高度
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());


    /**
     * 悬浮窗左右移动到默认位置 动画的 加速器
     */
    private Interpolator mLinearInterpolator = new LinearInterpolator();

    /**
     * 用于记录上次菜单打开的时间，判断时间间隔
     */
    private static double DOUBLE_CLICK_TIME = 0L;

    /**
     * 标记是否拖动中
     */
    private boolean isDrag = false;

    /**
     * 用于恢复悬浮球的location的属性动画值
     */
    private int mResetLocationValue;

    /**
     * 手指离开屏幕后 用于恢复 悬浮球的 logo 的左右位置
     */
    private Runnable updatePositionRunnable = new Runnable() {
        @Override
        public void run() {
            isDrag = true;
            checkPosition();
        }
    };

    /**
     * 这个事件不做任何事情、直接return false则 onclick 事件生效
     */
    private OnTouchListener mDefaultOnTouchListerner = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            isDrag = false;
            return false;
        }
    };

    /**
     * 这个事件用于处理移动、自定义点击或者其它事情，return true可以保证onclick事件失效
     */
    private OnTouchListener touchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    floatEventDown(event);
                    break;
                case MotionEvent.ACTION_MOVE:
                    floatEventMove(event);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    floatEventUp();
                    break;
            }
            return true;
        }
    };


    /**
     * 菜单背景颜色
     */
    private int mBackMenuColor = 0xffe4e3e1;

    /**
     * 是否绘制红点数字
     */
    private boolean mDrawRedPointNum;


    /**
     * 是否绘制圆形菜单项，false绘制方形
     */
    private boolean mCircleMenuBg;


    /**
     * R.drawable.yw_game_logo
     *
     * @param floatItems
     */
    private Bitmap mLogoRes;

    /**
     * 用于显示在 mActivity 上的 mActivity
     */
    private Context mActivity;

    /**
     * 菜单 点击、关闭 监听
     */
    private FloatMenuView.OnMenuClickListener mOnMenuClickListener;


    /**
     * 停靠默认位置
     */
    private int mDefaultLocation = RIGHT;


    /**
     * 悬浮窗 坐落 位置
     */
    private int mHintLocation = mDefaultLocation;


    /**
     * 用于记录菜单项内容
     */
    private List<FloatItem> mFloatItems = new ArrayList<>();

    private LinearLayout rootViewRight;

    private LinearLayout rootView;

    private ValueAnimator valueAnimator;

    private boolean isExpanded = false;

    private Drawable mBackground;


    private FloatLogoMenu(Builder builder) {
        mBackMenuColor = builder.mBackMenuColor;
        mDrawRedPointNum = builder.mDrawRedPointNum;
        mCircleMenuBg = builder.mCircleMenuBg;
        mLogoRes = builder.mLogoRes;
        mActivity = builder.mActivity;
        mOnMenuClickListener = builder.mOnMenuClickListener;
        mDefaultLocation = builder.mDefaultLocation;
        mFloatItems = builder.mFloatItems;
        mBackground = builder.mDrawable;

//        if (mActivity == null || mActivity.isFinishing() || mActivity.getWindowManager() == null) {
//            throw new IllegalArgumentException("Activity = null, or Activity is isFinishing ,or this Activity`s  token is bad");
//        }

        if (mLogoRes == null) {
            throw new IllegalArgumentException("No logo found,you can setLogo/showWithLogo to set a FloatLogo ");
        }

        if (mFloatItems.isEmpty()) {
            throw new IllegalArgumentException("At least one menu item!");
        }

        initFloatWindow();
        initTimer();
        initFloat();

    }

    public void setFloatItemList(List<FloatItem> floatItems) {
        this.mFloatItems = floatItems;
        calculateDotNum();
    }

    /**
     * 初始化悬浮球 window
     */
    private void initFloatWindow() {
        wmParams = new WindowManager.LayoutParams();
        if (mActivity instanceof Activity) {
            Activity activity = (Activity) mActivity;
            wManager = activity.getWindowManager();
            //类似dialog，寄托在activity的windows上,activity关闭时需要关闭当前float
            wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
        } else {
            wManager = (WindowManager) mActivity.getSystemService(Context.WINDOW_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //在android7.1以上系统需要使用TYPE_PHONE类型 配合运行时权限
                wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //在android7.1以上系统需要使用TYPE_PHONE类型 配合运行时权限
                wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            } else {
                wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            }
        }
        mScreenWidth = wManager.getDefaultDisplay().getWidth();
        int screenHeight = wManager.getDefaultDisplay().getHeight();

        //判断状态栏是否显示 如果不显示则statusBarHeight为0
        mStatusBarHeight = dp2Px(25, mActivity);

        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        mHintLocation = getSetting(LOCATION_X, mDefaultLocation);
        int defaultY = ((screenHeight - mStatusBarHeight) / 2) / 3;
        int y = getSetting(LOCATION_Y, defaultY);
        if (mHintLocation == LEFT) {
            wmParams.x = 0;
        } else {
            wmParams.x = mScreenWidth;
        }

        if (y != 0 && y != defaultY) {
            wmParams.y = y;
        } else {
            wmParams.y = defaultY;
        }
        wmParams.alpha = 1;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
    }


    /**
     * 初始化悬浮球
     */
    private void initFloat() {
        generateLeftLineLayout();
        generateRightLineLayout();
        mFloatLogo = new DotImageView(mActivity, mLogoRes);
        mFloatLogo.setLayoutParams(new WindowManager.LayoutParams(dp2Px(50, mActivity), dp2Px(50, mActivity)));
        mFloatLogo.setDrawNum(mDrawRedPointNum);
        mFloatLogo.setBgColor(mBackMenuColor);
        mFloatLogo.setDrawDarkBg(true);
        calculateDotNum();
        floatBtnEvent();
        try {
            wManager.addView(mFloatLogo, wmParams);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void generateLeftLineLayout() {
        DotImageView floatLogo = new DotImageView(mActivity, mLogoRes);
        floatLogo.setLayoutParams(new WindowManager.LayoutParams(dp2Px(60, mActivity), dp2Px(60, mActivity)));
        floatLogo.setDrawNum(mDrawRedPointNum);
        floatLogo.setDrawDarkBg(false);

        rootView = new LinearLayout(mActivity);
        rootView.setOrientation(LinearLayout.HORIZONTAL);
        rootView.setGravity(Gravity.CENTER);
        rootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp2Px(60, mActivity)));

        rootView.setBackgroundDrawable(mBackground);


        FloatMenuView mFloatMenuView = new FloatMenuView.Builder(mActivity)
                .setFloatItems(mFloatItems)
                .setBackgroundColor(Color.TRANSPARENT)
                .setCicleBg(mCircleMenuBg)
                .setStatus(FloatMenuView.STATUS_LEFT)
                .setMenuBackgroundColor(Color.TRANSPARENT)
                .drawNum(mDrawRedPointNum)
                .create();
        setMenuClickListener(mFloatMenuView);

        rootView.addView(floatLogo);
        rootView.addView(mFloatMenuView);


        floatLogo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    try {
                        wManager.removeViewImmediate(rootView);
                        wManager.addView(FloatLogoMenu.this.mFloatLogo, wmParams);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    isExpanded = false;
                }
            }
        });
    }

    private void generateRightLineLayout() {
        final DotImageView floatLogo = new DotImageView(mActivity, mLogoRes);
        floatLogo.setLayoutParams(new WindowManager.LayoutParams(dp2Px(70, mActivity), dp2Px(70, mActivity)));
        floatLogo.setDrawNum(mDrawRedPointNum);
        floatLogo.setDrawDarkBg(false);

        floatLogo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    try {
                        wManager.removeViewImmediate(rootViewRight);
                        wManager.addView(FloatLogoMenu.this.mFloatLogo, wmParams);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    isExpanded = false;
                }
            }
        });

        rootViewRight = new LinearLayout(mActivity);
        rootViewRight.setOrientation(LinearLayout.HORIZONTAL);
        rootViewRight.setGravity(Gravity.CENTER);
        rootViewRight.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp2Px(100, mActivity)));


        rootViewRight.setBackgroundDrawable(mBackground);


        FloatMenuView mFloatMenuView = new FloatMenuView.Builder(mActivity)
                .setFloatItems(mFloatItems)
                .setBackgroundColor(Color.TRANSPARENT)
                .setCicleBg(mCircleMenuBg)
                .setStatus(FloatMenuView.STATUS_RIGHT)
                .setMenuBackgroundColor(Color.TRANSPARENT)
                .drawNum(mDrawRedPointNum)
                .create();
        setMenuClickListener(mFloatMenuView);

        rootViewRight.addView(mFloatMenuView);
        rootViewRight.addView(floatLogo);


    }

    /**
     * 初始化 隐藏悬浮球的定时器
     */
    private void initTimer() {
        mHideTimer = new CountDownTimer(2000, 10) {        //悬浮窗超过5秒没有操作的话会自动隐藏
            @Override
            public void onTick(long millisUntilFinished) {
                if (isExpanded) {
                    mHideTimer.cancel();
                }
            }

            @Override
            public void onFinish() {
                if (isExpanded) {
                    mHideTimer.cancel();
                    return;
                }
                if (!isDrag) {
                    if (mHintLocation == LEFT) {
                        mFloatLogo.setStatus(DotImageView.HIDE_LEFT);
                        mFloatLogo.setDrawDarkBg(true);
                    } else {
                        mFloatLogo.setStatus(DotImageView.HIDE_RIGHT);
                        mFloatLogo.setDrawDarkBg(true);
                    }
//                    mFloatLogo.setOnTouchListener(mDefaultOnTouchListerner);//把onClick事件分发下去，防止onclick无效
                }
            }
        };
    }


    /**
     * 用于 拦截 菜单项的 关闭事件，以方便开始 隐藏定时器
     *
     * @param mFloatMenuView
     */
    private void setMenuClickListener(FloatMenuView mFloatMenuView) {
        mFloatMenuView.setOnMenuClickListener(new FloatMenuView.OnMenuClickListener() {
            @Override
            public void onItemClick(int position, String title) {
                mOnMenuClickListener.onItemClick(position, title);
            }

            @Override
            public void dismiss() {
                mFloatLogo.setDrawDarkBg(true);
                mOnMenuClickListener.dismiss();
                mHideTimer.start();
            }
        });

    }


    /**
     * 悬浮窗的点击事件和touch事件的切换
     */
    private void floatBtnEvent() {
        //这里的onClick只有 touchListener = mDefaultOnTouchListener 才会触发
//        mFloatLogo.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!isDrag) {
//                    if (mFloatLogo.getStatus() != DotImageView.NORMAL) {
//                        mFloatLogo.setBitmap(mLogoRes);
//                        mFloatLogo.setStatus(DotImageView.NORMAL);
//                        if (!mFloatLogo.mDrawDarkBg) {
//                            mFloatLogo.setDrawDarkBg(true);
//                        }
//                    }
//                    mFloatLogo.setOnTouchListener(touchListener);
//                    mHideTimer.start();
//                }
//            }
//        });

        mFloatLogo.setOnTouchListener(touchListener);//恢复touch事件
    }

    /**
     * 悬浮窗touch事件的 down 事件
     */
    private void floatEventDown(MotionEvent event) {
        isDrag = false;
        mHideTimer.cancel();
        if (mFloatLogo.getStatus() != DotImageView.NORMAL) {
            mFloatLogo.setStatus(DotImageView.NORMAL);
        }
        if (!mFloatLogo.mDrawDarkBg) {
            mFloatLogo.setDrawDarkBg(true);
        }
        if (mFloatLogo.getStatus() != DotImageView.NORMAL) {
            mFloatLogo.setStatus(DotImageView.NORMAL);
        }
        mXInView = event.getX();
        mYinView = event.getY();
        mXDownInScreen = event.getRawX();
        mYDownInScreen = event.getRawY();
        mXInScreen = event.getRawX();
        mYInScreen = event.getRawY();


    }

    /**
     * 悬浮窗touch事件的 move 事件
     */
    private void floatEventMove(MotionEvent event) {
        mXInScreen = event.getRawX();
        mYInScreen = event.getRawY();


        //连续移动的距离超过3则更新一次视图位置
        if (Math.abs(mXInScreen - mXDownInScreen) > mFloatLogo.getWidth() / 4 || Math.abs(mYInScreen - mYDownInScreen) > mFloatLogo.getWidth() / 4) {
            wmParams.x = (int) (mXInScreen - mXInView);
            wmParams.y = (int) (mYInScreen - mYinView) - mFloatLogo.getHeight() / 2;
            updateViewPosition(); // 手指移动的时候更新小悬浮窗的位置
            double a = mScreenWidth / 2;
            float offset = (float) ((a - (Math.abs(wmParams.x - a))) / a);
            mFloatLogo.setDrag(isDrag, offset, false);
        } else {
            isDrag = false;
            mFloatLogo.setDrag(false, 0, true);
        }
    }

    /**
     * 悬浮窗touch事件的 up 事件
     */
    private void floatEventUp() {
        if (mXInScreen < mScreenWidth / 2) {   //在左边
            mHintLocation = LEFT;
        } else {                   //在右边
            mHintLocation = RIGHT;
        }
        if (valueAnimator == null) {
            valueAnimator = ValueAnimator.ofInt(64);
            valueAnimator.setInterpolator(mLinearInterpolator);
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mResetLocationValue = (int) animation.getAnimatedValue();
                    mHandler.post(updatePositionRunnable);
                }
            });

            valueAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    if (Math.abs(wmParams.x) < 0) {
                        wmParams.x = 0;
                    } else if (Math.abs(wmParams.x) > mScreenWidth) {
                        wmParams.x = mScreenWidth;
                    }
                    updateViewPosition();
                    isDrag = false;
                    mFloatLogo.setDrag(false, 0, true);
                    mHideTimer.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    if (Math.abs(wmParams.x) < 0) {
                        wmParams.x = 0;
                    } else if (Math.abs(wmParams.x) > mScreenWidth) {
                        wmParams.x = mScreenWidth;
                    }

                    updateViewPosition();
                    isDrag = false;
                    mFloatLogo.setDrag(false, 0, true);
                    mHideTimer.start();

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }

//        //这里需要判断如果如果手指所在位置和logo所在位置在一个宽度内则不移动,
        if (Math.abs(mXInScreen - mXDownInScreen) > mFloatLogo.getWidth() / 5 || Math.abs(mYInScreen - mYDownInScreen) > mFloatLogo.getHeight() / 5) {
            isDrag = false;
        } else {
            openMenu();
        }

    }


    /**
     * 用于检查并更新悬浮球的位置
     */
    private void checkPosition() {
        if (wmParams.x > 0 && wmParams.x < mScreenWidth) {
            if (mHintLocation == LEFT) {
                wmParams.x = wmParams.x - mResetLocationValue;
            } else {
                wmParams.x = wmParams.x + mResetLocationValue;
            }
            updateViewPosition();
            double a = mScreenWidth / 2;
            float offset = (float) ((a - (Math.abs(wmParams.x - a))) / a);
            mFloatLogo.setDrag(isDrag, offset, true);
            return;
        }


        if (Math.abs(wmParams.x) < 0) {
            wmParams.x = 0;
        } else if (Math.abs(wmParams.x) > mScreenWidth) {
            wmParams.x = mScreenWidth;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }


        updateViewPosition();
        isDrag = false;


    }


    /**
     * 打开菜单
     */
    public void openMenu() {
        if (isDrag) return;

        if (!isExpanded) {
            mFloatLogo.setDrawDarkBg(false);
            try {
                wManager.removeViewImmediate(mFloatLogo);
                if (mHintLocation == RIGHT) {
                    wManager.addView(rootViewRight, wmParams);
                } else {
                    wManager.addView(rootView, wmParams);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            isExpanded = true;
            mHideTimer.cancel();
        } else {
            mFloatLogo.setDrawDarkBg(true);
            if (isExpanded) {
                try {
                    wManager.removeViewImmediate(mHintLocation == LEFT ? rootView : rootViewRight);
                    wManager.addView(mFloatLogo, wmParams);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                isExpanded = false;
            }
            mHideTimer.start();
        }

    }


    /**
     * 更新悬浮窗在屏幕中的位置。
     */
    private void updateViewPosition() {
        isDrag = true;
        try {
            if (!isExpanded) {
                if (wmParams.y - mFloatLogo.getHeight() / 2 <= 0) {
                    wmParams.y = mStatusBarHeight;
                    isDrag = true;
                }
                wManager.updateViewLayout(mFloatLogo, wmParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        try {
            if (wManager != null && wmParams != null && mFloatLogo != null) {
                wManager.addView(mFloatLogo, wmParams);
            }
            if (mHideTimer != null) {
                mHideTimer.start();
            } else {
                initTimer();
                mHideTimer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭菜单
     */
    public void hide() {
        destroyFloat();
    }


    /**
     * 移除所有悬浮窗 释放资源
     */
    public void destroyFloat() {
        //记录上次的位置logo的停放位置，以备下次恢复
        saveSetting(LOCATION_X, mHintLocation);
        saveSetting(LOCATION_Y, wmParams.y);
        mFloatLogo.clearAnimation();
        try {
            mHideTimer.cancel();
            if (isExpanded) {
                wManager.removeViewImmediate(mHintLocation == LEFT ? rootView : rootViewRight);
            } else {
                wManager.removeViewImmediate(mFloatLogo);
            }
            isExpanded = false;
            isDrag = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算总红点数
     */
    private void calculateDotNum() {
        int dotNum = 0;
        for (FloatItem floatItem : mFloatItems) {
            if (!TextUtils.isEmpty(floatItem.getDotNum())) {
                int num = Integer.parseInt(floatItem.getDotNum());
                dotNum = dotNum + num;
            }
        }
        mFloatLogo.setDrawNum(mDrawRedPointNum);
        setDotNum(dotNum);
    }

    /**
     * 绘制悬浮球的红点
     *
     * @param dotNum d
     */
    private void setDotNum(int dotNum) {
        mFloatLogo.setDotNum(dotNum, new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isDrag) {
                    mHideTimer.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 用于暴露给外部判断是否包含某个菜单项
     *
     * @param menuLabel string
     * @return boolean
     */
    public boolean hasMenu(String menuLabel) {
        for (FloatItem menuItem : mFloatItems) {
            if (TextUtils.equals(menuItem.getTitle(), menuLabel)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 用于保存悬浮球的位置记录
     *
     * @param key          String
     * @param defaultValue int
     * @return int
     */
    private int getSetting(String key, int defaultValue) {
        try {
            SharedPreferences sharedata = mActivity.getSharedPreferences("floatLogo", 0);
            return sharedata.getInt(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 用于保存悬浮球的位置记录
     *
     * @param key   String
     * @param value int
     */
    public void saveSetting(String key, int value) {
        try {
            SharedPreferences.Editor sharedata = mActivity.getSharedPreferences("floatLogo", 0).edit();
            sharedata.putInt(key, value);
            sharedata.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int dp2Px(float dp, Context mContext) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                mContext.getResources().getDisplayMetrics());
    }


    public interface OnMenuClickListener {
        void onMenuExpended(boolean isExpened);
    }


    public void setValueAnimator() {

    }

    public static final class Builder {
        private int mBackMenuColor;
        private boolean mDrawRedPointNum;
        private boolean mCircleMenuBg;
        private Bitmap mLogoRes;
        private int mDefaultLocation;
        private List<FloatItem> mFloatItems = new ArrayList<>();
        private Context mActivity;
        private FloatMenuView.OnMenuClickListener mOnMenuClickListener;
        private Drawable mDrawable;


        public Builder setBgDrawable(Drawable drawable) {
            mDrawable = drawable;
            return this;
        }

        public Builder() {
        }

        public Builder setFloatItems(List<FloatItem> mFloatItems) {
            this.mFloatItems = mFloatItems;
            return this;
        }

        public Builder addFloatItem(FloatItem floatItem) {
            this.mFloatItems.add(floatItem);
            return this;
        }

        public Builder backMenuColor(int val) {
            mBackMenuColor = val;
            return this;
        }

        public Builder drawRedPointNum(boolean val) {
            mDrawRedPointNum = val;
            return this;
        }

        public Builder drawCicleMenuBg(boolean val) {
            mCircleMenuBg = val;
            return this;
        }

        public Builder logo(Bitmap val) {
            mLogoRes = val;
            return this;
        }

        public Builder withActivity(Activity val) {
            mActivity = val;
            return this;
        }

        public Builder withContext(Context val) {
            mActivity = val;
            return this;
        }

        public Builder setOnMenuItemClickListener(FloatMenuView.OnMenuClickListener val) {
            mOnMenuClickListener = val;
            return this;
        }

        public Builder defaultLocation(int val) {
            mDefaultLocation = val;
            return this;
        }

        public FloatLogoMenu showWithListener(FloatMenuView.OnMenuClickListener val) {
            mOnMenuClickListener = val;
            return new FloatLogoMenu(this);
        }

        public FloatLogoMenu showWithLogo(Bitmap val) {
            mLogoRes = val;
            return new FloatLogoMenu(this);
        }

        public FloatLogoMenu show() {
            return new FloatLogoMenu(this);
        }
    }


}
