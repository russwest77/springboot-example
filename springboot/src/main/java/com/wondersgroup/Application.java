package com.wondersgroup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot 启动注解
@SpringBootApplication 
@MapperScan("com.wondersgroup.store.user.dao")
public class Application{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 修改内置tomcat端口号(实现implements EmbeddedServletContainerCustomizerdaun接口，重写改方法，也可以在配置文件中配置)
	 */
	/*@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8094);
	}*/
}
