package com.wondersgroup.store;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import com.wondersgroup.store.intercepter.ApiInterceptor;

/**
 * 应用相关配置
 */
@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport{
	
	/**
	 * 拦截器
	 */
	@Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new ApiInterceptor());
    }
	
}
