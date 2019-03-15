package com.zyh.test;

import com.zyh.spring.MyApplicationContext;
import com.zyh.spring.MyClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		// 创建一个自己的spring容器
		MyApplicationContext myApplicationContext = new MyClassPathXmlApplicationContext(
				"beans.xml");
	//	myApplicationContext.getBean("userService");
	}

}
