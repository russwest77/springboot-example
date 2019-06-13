package com.wondersgroup.store;

import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
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
        registry.addInterceptor(new ApiInterceptor()).excludePathPatterns("/index,html","/","/login").addPathPatterns("/**");
        super.addInterceptors(registry);
    }

	/**
	 * 允许静态资源通过拦截器 
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	
	/**
	 * 请求的其他配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**")//允许跨域的路径
		.allowedOrigins("*")//允许跨域请求的域名
		.allowCredentials(true)//是否允许证书 不再默认开启
		.allowedMethods("GET","POST","PUT","DELETE")//允许方法
		.maxAge(3600);//跨域允许时间
	}
	
	/**
	 * 使用fastjson替代springboot默认使用jackson引擎
	 */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //定义一个convert转换消息对象
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
        //添加fastjson的配置信息，比如：是否要格式化返回json数据
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }
}
