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
package com.yw.game.floatmenu.customfloat;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;


/**
 * Created by wengyiming on 2017/8/25.
 */

public abstract class BaseFloatDialog {

    /**
     * 悬浮球 坐落 左 右 标记
     */
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    /**
     * 记录 logo 停放的位置，以备下次恢复
     */
    private static final String LOCATION_X = "hintLocation";
    private static final String LOCATION_Y = "locationY";


    /**
     * 停靠默认位置
     */
    private int mDefaultLocation = RIGHT;


    /**
     * 悬浮窗 坐落 位置
     */
    private int mHintLocation = mDefaultLocation;


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
     * 用于显示在 mActivity 上的 mActivity
     */
    private Context mActivity;


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
     * 标记是否拖动中
     */
    private boolean isDrag = false;

    /**
     * 用于恢复悬浮球的location的属性动画值
     */
    private int mResetLocationValue;

    public boolean isApplicationDialog() {
        return isApplicationDialog;
    }

    private boolean isApplicationDialog = false;

    /**
     * 这个事件用于处理移动、自定义点击或者其它事情，return true可以保证onclick事件失效
     */
    private View.OnTouchListener touchListener = new View.OnTouchListener() {
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

    ValueAnimator valueAnimator = null;
    private boolean isExpanded = false;

    private View logoView;
    private View rightView;
    private View leftView;

    private GetViewCallback mGetViewCallback;


    public Context getContext() {
        return mActivity;
    }

    public static class FloatDialogImp extends BaseFloatDialog {


        public FloatDialogImp(Context context, GetViewCallback getViewCallback) {
            super(context, getViewCallback);
        }

        public FloatDialogImp(Context context) {
            super(context);
        }

        @Override
        protected View getLeftView(LayoutInflater inflater, View.OnTouchListener touchListener) {
            return null;
        }

        @Override
        protected View getRightView(LayoutInflater inflater, View.OnTouchListener touchListener) {
            return null;
        }

        @Override
        protected View getLogoView(LayoutInflater inflater) {
            return null;
        }

        @Override
        protected void resetLogoViewSize(int hintLocation, View logoView) {

        }

        @Override
        protected void dragLogoViewOffset(View logoView, boolean isDraging, boolean isResetPosition, float offset) {

        }

        @Override
        protected void shrinkLeftLogoView(View logoView) {

        }

        @Override
        protected void shrinkRightLogoView(View logoView) {

        }

        @Override
        protected void leftViewOpened(View leftView) {

        }

        @Override
        protected void rightViewOpened(View rightView) {

        }

        @Override
        protected void leftOrRightViewClosed(View logoView) {

        }

        @Override
        protected void onDestroyed() {

        }
    }

    protected BaseFloatDialog(Context context, GetViewCallback getViewCallback) {
        this(context);
        this.mGetViewCallback = getViewCallback;
        if (mGetViewCallback == null) {
            throw new IllegalArgumentException("GetViewCallback cound not be null!");
        }

    }

    protected BaseFloatDialog(Context context) {
        this.mActivity = context;
        initFloatWindow();
        initTimer();
        initFloatView();

    }


    private void initFloatView() {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        logoView = mGetViewCallback == null ? getLogoView(inflater) : mGetViewCallback.getLogoView(inflater);
        leftView = mGetViewCallback == null ? getLeftView(inflater, touchListener) : mGetViewCallback.getLeftView(inflater, touchListener);
        rightView = mGetViewCallback == null ? getRightView(inflater, touchListener) : mGetViewCallback.getRightView(inflater, touchListener);

        if (logoView == null) {
            throw new IllegalArgumentException("Must impl GetViewCallback or impl " + this.getClass().getSimpleName() + "and make getLogoView() not return null !");
        }

        logoView.setOnTouchListener(touchListener);//恢复touch事件

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
                        if (mGetViewCallback == null) {
                            shrinkLeftLogoView(logoView);
                        } else {
                            mGetViewCallback.shrinkLeftLogoView(logoView);
                        }
                    } else {
                        if (mGetViewCallback == null) {
                            shrinkRightLogoView(logoView);
                        } else {
                            mGetViewCallback.shrinkRightLogoView(logoView);
                        }
                    }
                }
            }
        };
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
            isApplicationDialog = true;
        } else {
            wManager = (WindowManager) mActivity.getSystemService(Context.WINDOW_SERVICE);
            //判断状态栏是否显示 如果不显示则statusBarHeight为0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //在android7.1以上系统需要使用TYPE_PHONE类型 配合运行时权限
                wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //在android7.1以上系统需要使用TYPE_PHONE类型 配合运行时权限
                wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                wmParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            } else {
                wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            }
            isApplicationDialog = false;
        }
        mScreenWidth = wManager.getDefaultDisplay().getWidth();
        int screenHeight = wManager.getDefaultDisplay().getHeight();
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        mHintLocation = getSetting(LOCATION_X, mDefaultLocation);
        int defaultY = ((screenHeight) / 2) / 3;
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
     * 悬浮窗touch事件的 down 事件
     */
    private void floatEventDown(MotionEvent event) {
        isDrag = false;
        mHideTimer.cancel();

        if (mGetViewCallback == null) {
            resetLogoViewSize(mHintLocation, logoView);
        } else {
            mGetViewCallback.resetLogoViewSize(mHintLocation, logoView);
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
        if (Math.abs(mXInScreen - mXDownInScreen) > logoView.getWidth() / 4 || Math.abs(mYInScreen - mYDownInScreen) > logoView.getWidth() / 4) {
            wmParams.x = (int) (mXInScreen - mXInView);
            wmParams.y = (int) (mYInScreen - mYinView) - logoView.getHeight() / 2;
            updateViewPosition(); // 手指移动的时候更新小悬浮窗的位置
            double a = mScreenWidth / 2;
            float offset = (float) ((a - (Math.abs(wmParams.x - a))) / a);
            if (mGetViewCallback == null) {
                dragLogoViewOffset(logoView, isDrag, false, offset);
            } else {
                mGetViewCallback.dragingLogoViewOffset(logoView, isDrag, false, offset);
            }

        } else {
            isDrag = false;
//            logoView.setDrag(false, 0, true);
            if (mGetViewCallback == null) {
                dragLogoViewOffset(logoView, false, true, 0);
            } else {
                mGetViewCallback.dragingLogoViewOffset(logoView, false, true, 0);
            }

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
                if (mGetViewCallback == null) {
                    dragLogoViewOffset(logoView, false, true, 0);
                } else {
                    mGetViewCallback.dragingLogoViewOffset(logoView, false, true, 0);
                }
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
                if (mGetViewCallback == null) {
                    dragLogoViewOffset(logoView, false, true, 0);
                } else {
                    mGetViewCallback.dragingLogoViewOffset(logoView, false, true, 0);
                }
                mHideTimer.start();

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }

//        //这里需要判断如果如果手指所在位置和logo所在位置在一个宽度内则不移动,
        if (Math.abs(mXInScreen - mXDownInScreen) > logoView.getWidth() / 5 || Math.abs(mYInScreen - mYDownInScreen) > logoView.getHeight() / 5) {
            isDrag = false;
        } else {
            openMenu();
        }

    }

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
//            logoView.setDrag(isDrag, offset, true);
            if (mGetViewCallback == null) {
                dragLogoViewOffset(logoView, false, true, 0);
            } else {
                mGetViewCallback.dragingLogoViewOffset(logoView, isDrag, true, offset);
            }

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

    public void show() {
        try {
            if (wManager != null && wmParams != null && logoView != null) {
                wManager.addView(logoView, wmParams);
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
     * 打开菜单
     */
    private void openMenu() {
        if (isDrag) return;

        if (!isExpanded) {
//            logoView.setDrawDarkBg(false);
            try {
                wManager.removeViewImmediate(logoView);
                if (mHintLocation == RIGHT) {
                    wManager.addView(rightView, wmParams);
                    if (mGetViewCallback == null) {
                        rightViewOpened(rightView);
                    } else {
                        mGetViewCallback.rightViewOpened(rightView);
                    }
                } else {
                    wManager.addView(leftView, wmParams);
                    if (mGetViewCallback == null) {
                        leftViewOpened(leftView);
                    } else {
                        mGetViewCallback.leftViewOpened(leftView);
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            isExpanded = true;
            mHideTimer.cancel();
        } else {
//            logoView.setDrawDarkBg(true);
            try {
                wManager.removeViewImmediate(mHintLocation == LEFT ? leftView : rightView);
                wManager.addView(logoView, wmParams);
                if (mGetViewCallback == null) {
                    leftOrRightViewClosed(logoView);
                } else {
                    mGetViewCallback.leftOrRightViewClosed(logoView);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            isExpanded = false;
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
                if (wmParams.y - logoView.getHeight() / 2 <= 0) {
                    wmParams.y = 25;
                    isDrag = true;
                }
                wManager.updateViewLayout(logoView, wmParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 移除所有悬浮窗 释放资源
     */
    public void dismiss() {
        //记录上次的位置logo的停放位置，以备下次恢复
        saveSetting(LOCATION_X, mHintLocation);
        saveSetting(LOCATION_Y, wmParams.y);
        logoView.clearAnimation();
        try {
            mHideTimer.cancel();
            if (isExpanded) {
                wManager.removeViewImmediate(mHintLocation == LEFT ? leftView : rightView);
            } else {
                wManager.removeViewImmediate(logoView);
            }
            isExpanded = false;
            isDrag = false;
            if (mGetViewCallback == null) {
                onDestroyed();
            } else {
                mGetViewCallback.onDestoryed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract View getLeftView(LayoutInflater inflater, View.OnTouchListener touchListener);

    protected abstract View getRightView(LayoutInflater inflater, View.OnTouchListener touchListener);

    protected abstract View getLogoView(LayoutInflater inflater);

    protected abstract void resetLogoViewSize(int hintLocation, View logoView);//logo恢复原始大小

    protected abstract void dragLogoViewOffset(View logoView, boolean isDraging, boolean isResetPosition, float offset);

    protected abstract void shrinkLeftLogoView(View logoView);//logo左边收缩

    protected abstract void shrinkRightLogoView(View logoView);//logo右边收缩

    protected abstract void leftViewOpened(View leftView);//左菜单打开

    protected abstract void rightViewOpened(View rightView);//右菜单打开

    protected abstract void leftOrRightViewClosed(View logoView);

    protected abstract void onDestroyed();

    public interface GetViewCallback {
        View getLeftView(LayoutInflater inflater, View.OnTouchListener touchListener);

        View getRightView(LayoutInflater inflater, View.OnTouchListener touchListener);

        View getLogoView(LayoutInflater inflater);


        void resetLogoViewSize(int hintLocation, View logoView);//logo恢复原始大小

        void dragingLogoViewOffset(View logoView, boolean isDraging, boolean isResetPosition, float offset);//logo正被拖动，或真在恢复原位

        void shrinkLeftLogoView(View logoView);//logo左边收缩

        void shrinkRightLogoView(View logoView);//logo右边收缩

        void leftViewOpened(View leftView);//左菜单打开

        void rightViewOpened(View rightView);//右菜单打开

        void leftOrRightViewClosed(View logoView);

        void onDestoryed();

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
}
