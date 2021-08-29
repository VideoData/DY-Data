package com.lida.dy.cal.track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TrackMgm {
    @Autowired
    TrackVideo trackVideo;
        @Scheduled(cron = "1 1/30 * * * ?")
    //或直接指定时间间隔，例如：5个小时
//    @Scheduled(fixedRate = 1800000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//        startSpiderThread();
    }

    int startTimes = 0;

    public void startSpiderThread() {
        startTimes++;
        System.out.println(getNowDate() + " 线程开始，次数：" + startTimes);
        new Thread(() -> {
            trackVideo.totalFailTime = 0;
            trackVideo.track(false);
        }, "myJobThread").start();
    }

    public static String getNowDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
