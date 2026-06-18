package io.ivanbyone.backend.config;

import io.ivanbyone.backend.core.interceptor.HeaderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final HeaderInterceptor headerInterceptor;

    @Autowired
    public WebConfig(HeaderInterceptor headerInterceptor) {
        this.headerInterceptor = headerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor).addPathPatterns("/**").order(1);
    }
}
