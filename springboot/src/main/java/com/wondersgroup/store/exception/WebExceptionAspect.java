package com.wondersgroup.store.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 异常处理
 * @author oowangwang
 *
 */
@ControllerAdvice
public class WebExceptionAspect {
    
	/**
	 * 捕捉异常执行
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody // 捕获返回json格式的异常信息
	public Map<String,Object> excepitonHandler(){
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("code", "500");
    	result.put("msg", "系统错误！");
		return result;
    }
}
