package com.lida.dy.schedle.linuxSpider;

import com.lida.dy.schedle.linuxSpider.mail.Mail;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送异常消息的，邮件
 *
 * @Auther: lida
 * @Description:
 * @Date 2020/3/5 0005 17:56
 * @Version: 1.0
 */
@Component
public class MessageNotifed {
    @Autowired
    Mail mail;
    @Autowired
    LinuxConf linuxConf;
    @Autowired
    State state;
    public static Map messageCache = new HashMap<Integer, MessageNode>();
    public static int failSpideTimes = 0;

    public void subFailSpideTimes() {
        if (failSpideTimes > 0) {
            failSpideTimes--;
        }
    }

    public boolean add(String message) {
        if (message == null) {
            System.out.println("message 为空");
            return true;
        }
        if (message.contains("无法爬取")) {
            failSpideTimes++;
            if (failSpideTimes > 10) {
                sendEmail(message + ":爬取接口頻繁，返回code不是正確的");
                /*退出*/
                return false;
            }
        } else {
            int code = message.hashCode();
            if (messageCache.containsKey(code)) {
                MessageNode node = (MessageNode) messageCache.get(code);
                if (node.getNum() < 10) {
                    node.setNum(node.getNum() + 1);
                } else {
                    sendEmail(node);
                    return false;
                }
            } else {
                MessageNode messageNode = new MessageNode();
                messageNode.setNum(1);
                messageNode.setMessage(message);
                messageCache.put(code, messageNode);
            }
        }
        return true;
    }

    private void sendEmail(String s) {
        s = LinuxUtil.getNowDate() + "  " + s;
        s = s + "\n" + state.toString();
//        if (LinuxUtil.linuxData != null) {
//            s = s + ":::" + LinuxUtil.linuxData.toString();
//        }
        mail.sendSimpleMail(linuxConf.getEmailTarget(), "星图平台爬虫异常提示", s);
    }

    private void sendEmail(MessageNode node) {
        sendEmail("错误信息:" + node.getMessage() + "    次数：" + node.getNum());
    }
}

@Data
class MessageNode {
    private int num;
    private String message;
}