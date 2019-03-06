package com.zyh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyh.spring.dao.UserDao;

public class HelloSpring {
	public static void main(String[] args) {
		String name = "dBUtilsUser";
		// 读取配置文件中的class的名字创建对象
		// ApplicationContext相当于是容器的引用
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");
		// 在beans.xml用配置好了，通过反射实例化
		// UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// UserDao userDao = (UserDao) applicationContext.getBean("mybatisUserDaoImp");
		UserDao userDao = (UserDao) applicationContext.getBean(name);
		userDao.getById(10L);

	}

}
