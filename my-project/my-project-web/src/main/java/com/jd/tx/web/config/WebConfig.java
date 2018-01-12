package com.jd.tx.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by tangxi on 2018/1/12.
 */
@Configuration // 表示这是Java配置类
@EnableWebMvc // 用于启动Spring MVC特性
@ComponentScan("com.jd.tx.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() { //配置JSP视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // 设置视图路径的前缀
        resolver.setSuffix(".jsp"); //设置视图路径的前缀
        // 即如果给定一个逻辑视图名称——"home"，则会被解析成"/WEB-INF/views/home.jsp"
        //可以在JSP页面中通过${}访问beans
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); //配置静态文件处理
    }

}
