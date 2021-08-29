package com.lida.dy.schedle.linuxSpider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 爬虫的定时启动管理
 * @Auther: lida
 * @Description:
 * @Date 2020/3/24 0024 15:01
 * @Version: 1.0
 */
@Component
public class SpiderMgmt {
    @Autowired
    Spider spider;

    @Scheduled(cron = "1 1 2/10 * * ?")
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        startSpiderThread();
    }

    public void startSpiderThread() {
        new Thread(() -> {
            try {
                System.out.println("start");
                spider.main(false);
                LinuxUtil.saveLinuxData();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LinuxUtil.saveLinuxData();
            }
        }, "myJobThread").start();
    }

}
