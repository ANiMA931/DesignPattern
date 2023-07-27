package com.ballad.config;

import com.ballad.intercepter.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 * @Classname JwtConfig
 * @date 2023-07-13 15:26
 * @comment
 */
@Configuration
public class JwtConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                //添加拦截路径
                .addPathPatterns("/**")
                //添加放行路径
                .excludePathPatterns("/user/login");
    }
}
