package com.light.datadispose.config;

import com.light.datadispose.Interceptor.FunInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Resource
//    private FunInterceptor funInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自己的拦截器,并设置拦截的请求路径
//        //addPathPatterns为拦截此请求路径的请求
//        //excludePathPatterns为不拦截此路径的请求
//        registry.addInterceptor(funInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/oldLogin");
//    }

}
