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
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;


/**
 * Created by wengyiming on 2017/7/21.
 */

/**
 * 00%=FF（不透明）    5%=F2    10%=E5    15%=D8    20%=CC    25%=BF    30%=B2    35%=A5    40%=99    45%=8c    50%=7F
 * 55%=72    60%=66    65%=59    70%=4c    75%=3F    80%=33    85%=21    90%=19    95%=0c    100%=00（全透明）
 */
public class DotImageView extends View {
    private static final String TAG = DotImageView.class.getSimpleName();
    public static final int NORMAL = 0;//不隐藏
    public static final int HIDE_LEFT = 1;//左边隐藏
    public static final int HIDE_RIGHT = 2;//右边隐藏
    private Paint mPaint;//用于画anything

    private Paint mPaintBg;//用于画anything
    private String dotNum = null;//红点数字
    private float mAlphaValue;//透明度动画值
    private float mRotateValue = 1f;//旋转动画值
    private boolean inited = false;//标记透明动画是否执行过，防止因onreseme 切换导致重复执行


    private Bitmap mBitmap;//logo
    private final int mLogoBackgroundRadius = dip2px(25);//logo的灰色背景圆的半径
    private final int mLogoWhiteRadius = dip2px(20);//logo的白色背景的圆的半径
    private final int mRedPointRadiusWithNum = dip2px(6);//红点圆半径
    private final int mRedPointRadius = dip2px(3);//红点圆半径
    private final int mRedPointOffset = dip2px(10);//红点对logo的偏移量，比如左红点就是logo中心的 x - mRedPointOffset

    private boolean isDrag = false;//是否 绘制旋转放大动画，只有 非停靠边缘才绘制
    private float scaleOffset;//放大偏移值
    private ValueAnimator mDragValueAnimator;//放大、旋转 属性动画
    private LinearInterpolator mLinearInterpolator = new LinearInterpolator();//通用用加速器
    public boolean mDrawDarkBg = true;//是否绘制黑色背景，当菜单关闭时，才绘制灰色背景
    private static final float hideOffset = 0.4f;//往左右隐藏多少宽度的偏移值， 隐藏宽度的0.4
    private Camera mCamera;//camera用于执行3D动画

    private boolean mDrawNum = false;//只绘制红点还是红点+白色数字

    private int mStatus = NORMAL;//0 正常，1 左，2右,3 中间方法旋转
    private int mLastStatus = mStatus;
    private Matrix mMatrix;
    private boolean mIsResetPosition;

    private int mBgColor = 0x99000000;


    public void setBgColor(int bgColor) {
        mBgColor = bgColor;
    }


    public void setDrawNum(boolean drawNum) {
        this.mDrawNum = drawNum;
    }

    public void setDrawDarkBg(boolean drawDarkBg) {
        mDrawDarkBg = drawDarkBg;
        invalidate();
    }

    public int getStatus() {
        return mStatus;
    }


    public void setStatus(int status) {
        this.mStatus = status;
        isDrag = false;
        if (this.mStatus != NORMAL) {
            setDrawNum(mDrawNum);
            this.mDrawDarkBg = true;
        }
        invalidate();

    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public DotImageView(Context context, Bitmap bitmap) {
        super(context);
        this.mBitmap = bitmap;
        init();
    }


    public DotImageView(Context context) {
        super(context);
        init();
    }

    public DotImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(sp2px(10));
        mPaint.setStyle(Paint.Style.FILL);

        mPaintBg = new Paint();
        mPaintBg.setAntiAlias(true);
        mPaintBg.setStyle(Paint.Style.FILL);
        mPaintBg.setColor(mBgColor);//60% 黑色背景 （透明度 40%）

        mCamera = new Camera();
        mMatrix = new Matrix();
    }

    /**
     * 这个方法是否有优化空间
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wh = mLogoBackgroundRadius * 2;
        setMeasuredDimension(wh, wh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        canvas.save();//保存一份快照，方便后面恢复
        mCamera.save();
        if (mStatus == NORMAL) {
            if (mLastStatus != NORMAL) {
                canvas.restore();//恢复画布的原始快照
                mCamera.restore();
            }

            if (isDrag) {
                //如果当前是拖动状态则放大并旋转
                canvas.scale((scaleOffset + 1f), (scaleOffset + 1f), getWidth() / 2, getHeight() / 2);
                if (mIsResetPosition) {
                    //手指拖动后离开屏幕复位时使用 x轴旋转 3d动画
                    mCamera.save();
                    mCamera.rotateX(720 * scaleOffset);//0-720度 最多转两圈
                    mCamera.getMatrix(mMatrix);

                    mMatrix.preTranslate(-getWidth() / 2, -getHeight() / 2);
                    mMatrix.postTranslate(getWidth() / 2, getHeight() / 2);
                    canvas.concat(mMatrix);
                    mCamera.restore();
                } else {
                    //手指拖动且手指未离开屏幕则使用 绕图心2d旋转动画
                    canvas.rotate(60 * mRotateValue, getWidth() / 2, getHeight() / 2);
                }
            }


        } else if (mStatus == HIDE_LEFT) {
            canvas.translate(-getWidth() * hideOffset, 0);
            canvas.rotate(-45, getWidth() / 2, getHeight() / 2);

        } else if (mStatus == HIDE_RIGHT) {
            canvas.translate(getWidth() * hideOffset, 0);
            canvas.rotate(45, getWidth() / 2, getHeight() / 2);
        }
        canvas.save();
        if (!isDrag) {
            if (mDrawDarkBg) {
                mPaintBg.setColor(mBgColor);
                canvas.drawCircle(centerX, centerY, mLogoBackgroundRadius, mPaintBg);
                // 60% 白色 （透明度 40%）
                mPaint.setColor(0x99ffffff);
            } else {
                //100% 白色背景 （透明度 0%）
                mPaint.setColor(0xFFFFFFFF);
            }
            if (mAlphaValue != 0) {
                mPaint.setAlpha((int) (mAlphaValue * 255));
            }
            canvas.drawCircle(centerX, centerY, mLogoWhiteRadius, mPaint);
        }

        canvas.restore();
        //100% 白色背景 （透明度 0%）
        mPaint.setColor(0xFFFFFFFF);
        int left = (int) (centerX - mBitmap.getWidth() / 2);
        int top = (int) (centerY - mBitmap.getHeight() / 2);
        canvas.drawBitmap(mBitmap, left, top, mPaint);


        if (!TextUtils.isEmpty(dotNum)) {
            int readPointRadus = (mDrawNum ? mRedPointRadiusWithNum : mRedPointRadius);
            mPaint.setColor(Color.RED);
            if (mStatus == HIDE_LEFT) {
                canvas.drawCircle(centerX + mRedPointOffset, centerY - mRedPointOffset, readPointRadus, mPaint);
                if (mDrawNum) {
                    mPaint.setColor(Color.WHITE);
                    canvas.drawText(dotNum, centerX + mRedPointOffset - getTextWidth(dotNum, mPaint) / 2, centerY - mRedPointOffset + getTextHeight(dotNum, mPaint) / 2, mPaint);
                }
            } else if (mStatus == HIDE_RIGHT) {
                canvas.drawCircle(centerX - mRedPointOffset, centerY - mRedPointOffset, readPointRadus, mPaint);
                if (mDrawNum) {
                    mPaint.setColor(Color.WHITE);
                    canvas.drawText(dotNum, centerX - mRedPointOffset - getTextWidth(dotNum, mPaint) / 2, centerY - mRedPointOffset + getTextHeight(dotNum, mPaint) / 2, mPaint);
                }
            } else {
                if (mLastStatus == HIDE_LEFT) {
                    canvas.drawCircle(centerX + mRedPointOffset, centerY - mRedPointOffset, readPointRadus, mPaint);
                    if (mDrawNum) {
                        mPaint.setColor(Color.WHITE);
                        canvas.drawText(dotNum, centerX + mRedPointOffset - getTextWidth(dotNum, mPaint) / 2, centerY - mRedPointOffset + getTextHeight(dotNum, mPaint) / 2, mPaint);
                    }
                } else if (mLastStatus == HIDE_RIGHT) {
                    canvas.drawCircle(centerX - mRedPointOffset, centerY - mRedPointOffset, readPointRadus, mPaint);
                    if (mDrawNum) {
                        mPaint.setColor(Color.WHITE);
                        canvas.drawText(dotNum, centerX - mRedPointOffset - getTextWidth(dotNum, mPaint) / 2, centerY - mRedPointOffset + getTextHeight(dotNum, mPaint) / 2, mPaint);
                    }
                }
            }
        }
        mLastStatus = mStatus;
    }


    public void setDotNum(int num, Animator.AnimatorListener l) {
        if (!inited) {
            startAnim(num, l);
        } else {
            refreshDot(num);
        }
    }

    private void refreshDot(int num) {
        if (num > 0) {
            String dotNumTmp = String.valueOf(num);
            if (!TextUtils.equals(dotNum, dotNumTmp)) {
                dotNum = dotNumTmp;
                invalidate();
            }
        } else {
            dotNum = null;
        }
    }


    public void startAnim(final int num, Animator.AnimatorListener l) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.f, 0.6f, 1f, 0.6f);
        valueAnimator.setInterpolator(mLinearInterpolator);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAlphaValue = (float) animation.getAnimatedValue();
                invalidate();

            }
        });
        valueAnimator.addListener(l);
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                inited = true;
                refreshDot(num);
                mAlphaValue = 0;

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mAlphaValue = 0;
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    public void setDrag(boolean drag, float offset, boolean isResetPosition) {
        isDrag = drag;
        this.mIsResetPosition = isResetPosition;
        if (offset > 0 && offset != this.scaleOffset) {
            this.scaleOffset = offset;
        }
        if (isDrag && mStatus == NORMAL) {
            if (mDragValueAnimator != null) {
                if (mDragValueAnimator.isRunning()) return;
            }
            mDragValueAnimator = ValueAnimator.ofFloat(0, 6f, 12f, 0f);
            mDragValueAnimator.setInterpolator(mLinearInterpolator);
            mDragValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mRotateValue = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mDragValueAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    isDrag = false;
                    mIsResetPosition = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            mDragValueAnimator.setDuration(1000);
            mDragValueAnimator.start();
        }
    }

    private int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private float getTextHeight(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.height() / 1.1f;
    }

    private float getTextWidth(String text, Paint paint) {
        return paint.measureText(text);
    }
}
