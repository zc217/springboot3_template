package com.zhou.common.config;

import com.zhou.common.interceptor.LoginInterceptor;
import com.zhou.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RedisUtils redisUtils;

    private static final String[] array = {"/","/login"};
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor(redisUtils));
        registration.excludePathPatterns(array).addPathPatterns("/**");
    }
}
