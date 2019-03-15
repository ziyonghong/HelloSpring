package com.zyh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyh.pojo.User;
import com.zyh.service.UserService;

public class TestAop {
	public static void main(String[] args) {

		// 创建Spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

		// 从容器中获取的实例已经是增强了的代理对象
		UserService userService = applicationContext.getBean(UserService.class);
		//调用方法之前，要对方法进行拦截，看看方法到底符不符合表达式的要求
		userService.save(new User());
	}
}
