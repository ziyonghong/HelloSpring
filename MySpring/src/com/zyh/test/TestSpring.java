package com.zyh.test;

import com.zyh.spring.MyApplicationContext;
import com.zyh.spring.MyClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		// ����һ���Լ���spring����
		MyApplicationContext myApplicationContext = new MyClassPathXmlApplicationContext(
				"beans.xml");
	//	myApplicationContext.getBean("userService");
	}

}
