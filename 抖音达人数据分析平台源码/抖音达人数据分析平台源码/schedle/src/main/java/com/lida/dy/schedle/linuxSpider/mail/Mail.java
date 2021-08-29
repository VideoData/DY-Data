package com.lida.dy.schedle.linuxSpider.mail;

import com.lida.dy.schedle.linuxSpider.LinuxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/5 0005 20:20
 * @Version: 1.0
 */
@Component
public class Mail {
    @Autowired
    private JavaMailSender mailSender;


    /**
     * 发送文本邮件
     *
     * @param to      邮件接收方
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1941189375@qq.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
