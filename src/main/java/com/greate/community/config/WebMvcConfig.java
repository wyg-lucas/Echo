package com.greate.community.config;

import com.greate.community.controller.interceptor.LoginRequiredInterceptor;
import com.greate.community.controller.interceptor.LoginTicketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对除静态资源外所有路径进行拦截
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/css/**", "/js/**", "/img/**");

        // 对除静态资源外所有路径进行拦截
        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/css/**", "/js/**", "/img/**");
    }


}