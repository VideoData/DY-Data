package com.dy.autocomment.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by ykj on 15-12-22.
 */
public class ExToast {
    private static final String TAG = "ExToast";

    public static final int LENGTH_ALWAYS = 0;
    public static final int LENGTH_SHORT = 2;
    public static final int LENGTH_LONG = 4;

    private Toast toast;
    private Context mContext;
    private int mDuration = LENGTH_SHORT;
    private int animations = -1;
    private boolean isShow = false;

    private ITransientNotification mTN;
    private Handler handler = new Handler();

    public ExToast(Context context){
        this.mContext = context;
        if (toast == null) {
            toast = new Toast(mContext);
        }
    }

    private Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    /**
     * Show the view for the specified duration.
     */
    public void show(){
        if (isShow) return;

        initTN();
        try {
            mTN.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        isShow = true;
        //判断duration，如果大于#LENGTH_ALWAYS 则设置消失时间
        if (mDuration > LENGTH_ALWAYS) {
            handler.postDelayed(hideRunnable, mDuration * 1000);
        }
    }

    /**
     * Close the view if it's showing, or don't show it if it isn't showing yet.
     * You do not normally have to call this.  Normally view will disappear on its own
     * after the appropriate duration.
     */
    public void hide(){
        if(!isShow) return;
        try {
            mTN.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
        isShow = false;
    }

    public void setView(View view) {
        toast.setView(view);
    }

    public View getView() {
        return toast.getView();
    }

    /**
     * Set how long to show the view for.
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     * @see #LENGTH_ALWAYS
     */
    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setMargin(float horizontalMargin, float verticalMargin) {
        toast.setMargin(horizontalMargin,verticalMargin);
    }

    public float getHorizontalMargin() {
        return toast.getHorizontalMargin();
    }

    public float getVerticalMargin() {
        return toast.getVerticalMargin();
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        toast.setGravity(gravity,xOffset,yOffset);
    }

    public int getGravity() {
        return toast.getGravity();
    }

    public int getXOffset() {
        return toast.getXOffset();
    }

    public int getYOffset() {
        return toast.getYOffset();
    }

    public static ExToast makeText(Context context, CharSequence text, int duration) {
        Toast toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
        ExToast exToast = new ExToast(context);
        exToast.toast = toast;
        exToast.mDuration = duration;

        return exToast;
    }

    public static ExToast makeText(Context context, int resId, int duration)
            throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    public void setText(int resId) {
        setText(mContext.getText(resId));
    }

    public void setText(CharSequence s) {
        toast.setText(s);
    }

    public int getAnimations() {
        return animations;
    }

    public void setAnimations(int animations) {
        this.animations = animations;
    }

    private void initTN() {
        try {
            Field tnField = toast.getClass().getDeclaredField("mTN");
            tnField.setAccessible(true);
            mTN = (ITransientNotification) tnField.get(toast);

            /**设置动画*/
            if (animations != -1) {
                Field tnParamsField = mTN.getClass().getDeclaredField("mParams");
                tnParamsField.setAccessible(true);
                WindowManager.LayoutParams params = (WindowManager.LayoutParams) tnParamsField.get(mTN);
                params.windowAnimations = animations;
            }

            /**调用tn.show()之前一定要先设置mNextView*/
            Field tnNextViewField = mTN.getClass().getDeclaredField("mNextView");
            tnNextViewField.setAccessible(true);
            tnNextViewField.set(mTN, toast.getView());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
