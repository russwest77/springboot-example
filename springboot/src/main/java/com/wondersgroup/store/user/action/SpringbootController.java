package com.wondersgroup.store.user.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wondersgroup.store.user.bo.User;
import com.wondersgroup.store.user.service.UserService;

@RestController
public class SpringbootController {

	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@RequestMapping("/findAllUsers")
	public String springbootTest() {
		userService.findAllUsers();
		return "springboot findAllUsers success ~";
	}
	
	/**
	 * 保存用户信息
	 */
	@RequestMapping("/saveUser")
	public String insertUser(){
		User user = new User();
		user.setId("2");
		user.setName("张三");
		user.setPassword("111111");
		user.setAge(20);
		userService.insert(user);
		return "springboot insert success ~";
	}
	
	/**
	 * 根据id查询用户信息
	 */
	@RequestMapping("/findUserById")
	public User findUserById(@Param("id")String id){
		User user = userService.findUserById(id);
		return user;
	}
	
	@RequestMapping("testExcepiton")
	public String textExcetpiton(){
		System.out.println("...异常测试");
		int i=1/0;
		return "testException success ~";
	}
	
	/**
	 * freemarker模板测试
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		List<String> userList=new ArrayList<String>();
        userList.add("admin");
        userList.add("1234");
        modelAndView.addObject("userList", userList);
		return modelAndView;
	}
}
