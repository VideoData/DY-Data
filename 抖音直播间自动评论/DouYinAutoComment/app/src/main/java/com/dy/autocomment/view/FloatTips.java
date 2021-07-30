package com.dy.autocomment.view;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.dy.autocomment.R;


/**
 * Created by ykj on 15-12-25.
 */
public class FloatTips{

    public static final int TOP = 101;
    public static final int CENTER = 102;
    public static final int BOTTOM = 103;

    public static final int LENGTH_ALWAYS = 0;
    public static final int LENGTH_SHORT = 2;
    public static final int LENGTH_LONG = 4;

    Context mContext;
    WindowManager.LayoutParams params;
    WindowManager mWM;
    View mView;
    TextView mTv;
    Handler mHandler;
    int mDuration = LENGTH_SHORT;

    public FloatTips(Context context){
        this.mContext = context;
        mHandler = new Handler();
        params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.alpha = 80;
        params.windowAnimations = R.style.center_anim_view;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            params.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        params.setTitle("FloatTips");
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mWM = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);

        LayoutInflater inflate = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflate.inflate(R.layout.float_tips_layout, null);
        mTv = (TextView)mView.findViewById(R.id.message);
    }

    public void setGravity(int gravity){
        switch (gravity){
            case TOP:
                params.gravity = Gravity.FILL_HORIZONTAL | Gravity.TOP;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.windowAnimations = R.style.top_anim_view;
                break;
            case CENTER:
                params.gravity = Gravity.CENTER;
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.windowAnimations = R.style.center_anim_view;
                break;
            case BOTTOM:
                params.gravity = Gravity.FILL_HORIZONTAL | Gravity.BOTTOM;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.windowAnimations = R.style.bottom_anim_view;
                break;
        }
    }

    private Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    public void show(){
        if (mView.getParent() != null) {
            mWM.removeView(mView);
        }
        mWM.addView(mView, params);
        //判断duration，如果大于#LENGTH_ALWAYS 则设置消失时间
        if (mDuration > LENGTH_ALWAYS) {
            mHandler.removeCallbacks(hideRunnable);
            mHandler.postDelayed(hideRunnable, mDuration * 1000);
        }
    }


    public void hide(){
        if (mView != null) {
            if (mView.getParent() != null) {
                mWM.removeView(mView);
            }
        }
    }

    public void hideImmediate(){
        if (mView != null) {
            if (mView.getParent() != null) {
                params.windowAnimations = 0;
                mWM.updateViewLayout(mView, params);
            }
        }
    }

    public void setText(String text){
        mTv.setText(text);
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDuration() {
        return mDuration;
    }

    static int dip2px(Context context, float dpValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale +0.5f);
    }
}
