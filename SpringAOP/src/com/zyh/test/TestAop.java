package com.zyh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyh.pojo.User;
import com.zyh.service.UserService;

public class TestAop {
	public static void main(String[] args) {

		// ����Spring����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

		// �������л�ȡ��ʵ���Ѿ�����ǿ�˵Ĵ������
		UserService userService = applicationContext.getBean(UserService.class);
		//���÷���֮ǰ��Ҫ�Է����������أ������������׷������ϱ��ʽ��Ҫ��
		userService.save(new User());
	}
}
