package com.example.demo.test.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MyWebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LogHandlerInterceptor logHandlerInterceptor;
    /**
     * 注册 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(logHandlerInterceptor)
                .addPathPatterns("/**");//.excludePathPatterns("com/example/demo/**");
    }
}
