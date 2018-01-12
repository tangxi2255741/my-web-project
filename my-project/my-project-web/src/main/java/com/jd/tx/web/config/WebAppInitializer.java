package com.jd.tx.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by tangxi on 2018/1/12.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取Spring应用容器的配置文件
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {// 获取应用容器
        return new Class<?>[]{WebConfig.class};
    }

    // 指定需要由DispatcherServlet映射的路径，这里给定的是"/"，意思是由DispatcherServlet处理所有向该应用发起的请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
