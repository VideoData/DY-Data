package com.lida.dy.serviceImpl;

import com.lida.dy.DyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/16 0016 10:28
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DyApplication.class})// 指定启动类
public class MailServiceTest {
    @Autowired
    MailServiceImpl mailService;

    @Test
    public void test() {
        mailService.sendSimpleMail("1941189375@qq.com", "抖音主题", "内容啥啥");
    }

    @Test
    public void tetCode() {

    }
}
