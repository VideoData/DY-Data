package com.lida.dy.interceptor;

import com.lida.dy.conf.ApplicationConf;
import com.lida.dy.interceptor.LoginInterceptor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Log
public class LoginConfiguration implements WebMvcConfigurer {
    @Autowired
    ApplicationConf applicationConf;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("===========" + applicationConf.isCertification());
        if (applicationConf.isCertification()) {
            // 注册拦截器
            LoginInterceptor loginInterceptor = new LoginInterceptor();
            InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
            // 拦截路径
            loginRegistry.addPathPatterns("/**");
            // 排除路径
            loginRegistry.excludePathPatterns("/");
            loginRegistry.excludePathPatterns("/login*");
            loginRegistry.excludePathPatterns("/druid/**");
            loginRegistry.excludePathPatterns("/druid/index.html");
            loginRegistry.excludePathPatterns("/loginout");
            loginRegistry.excludePathPatterns("/register/**");
            loginRegistry.excludePathPatterns("/findPasswd/**");
            loginRegistry.excludePathPatterns("/login/findPasswd/inputInfo");
            // 排除资源请求
            loginRegistry.excludePathPatterns("/static/**");
        }
    }
}