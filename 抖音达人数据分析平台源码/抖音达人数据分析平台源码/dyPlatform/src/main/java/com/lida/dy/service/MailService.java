package com.lida.dy.service;

import javax.mail.MessagingException;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/16 0016 11:20
 * @Version: 1.0
 */
public interface MailService {
    void sendMailVerificationCode(String to, String code);

    void sendSimpleMail(String to, String subject, String content);

    void sendRegisterMailCode(String to, String code);

    void sendSimpleMail(String to, String subject, String content, String... cc);

    void sendHtmlMail(String to, String subject, String content) throws MessagingException;

    void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException;

    void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException;
}
