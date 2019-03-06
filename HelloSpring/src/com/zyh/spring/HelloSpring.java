package com.zyh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyh.spring.dao.UserDao;

public class HelloSpring {
	public static void main(String[] args) {
		String name = "dBUtilsUser";
		// ��ȡ�����ļ��е�class�����ִ�������
		// ApplicationContext�൱��������������
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");
		// ��beans.xml�����ú��ˣ�ͨ������ʵ����
		// UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// UserDao userDao = (UserDao) applicationContext.getBean("mybatisUserDaoImp");
		UserDao userDao = (UserDao) applicationContext.getBean(name);
		userDao.getById(10L);

	}

}
