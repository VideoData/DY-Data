package com.dy.autocomment;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.List;

/**
 * manifest中注册此服务
 * connection自己编写实现类，用于调用service的方法
 * connection和intent设置为全局变量，执行以下语句
 * intent = new Intent();
 * intent.setClass(getContext(),MyNotifyService.class);
 * getActivity().startService(intent);
 * getActivity().bindService(intent,connection,BIND_AUTO_CREATE);
 *
 * 在退出时执行以下语句
 *  getActivity().unbindService(connection);
 *  getActivity().stopService(intent);
 */
public class MyNotifyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyWorkService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务的内容全部在这个类里面实现
     */
    public class MyWorkService extends Binder {
        public MyNotifyService service;

        public MyWorkService(MyNotifyService service) {
            this.service = service;
        }

        public MyNotifyService getService() {
            return service;
        }

        public void stopSelf(){
            MyNotifyService.this.stopSelf();
        }

        public void startForeground(int id, Notification notification){
            MyNotifyService.this.startForeground(id, notification);
        }

        public void stopForeground(){
            MyNotifyService.this.stopForeground(true);
        }
    }


    /**
     * 获取服务是否运行
     * @param context
     * @return
     */
    public static boolean isServiceRunning(Context context){
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(MyNotifyService.class.getName())){
                return true;
            }
        }
        return false;
    }




    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyWorkService workService = ((MyWorkService) service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
