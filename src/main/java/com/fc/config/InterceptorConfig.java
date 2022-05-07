package com.fc.config;

import com.fc.interceptor.InitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InitInterceptor())
                .excludePathPatterns("/user_login.jsp")
                .order(-1)
                .addPathPatterns("/**");
    }
}
