package com.lida.dy.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/15 0015 20:15
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "my")
public class ApplicationConf {

    private boolean certification;

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }


}
