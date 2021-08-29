package com.lida.dy.schedle.linuxSpider;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * 应用关闭钩子
 * @Auther: lida
 * @Description:
 * @Date 2020/3/5 0005 17:44
 * @Version: 1.0
 */
public class ApplicationClosed implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        LinuxUtil.end();
    }
}
