package com.lida.dy.schedle.linuxSpider;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/2 0002 11:42
 * @Version: 1.0
 */
@Component
@Data
public class LinuxConf {
    @Value("${my.categoryfilepath}")
    String categoryFilePath;
    @Value("${my.linuxpath}")
    String tempFilePath;
    @Value("${my.emailto}")
    String emailTarget;
}
