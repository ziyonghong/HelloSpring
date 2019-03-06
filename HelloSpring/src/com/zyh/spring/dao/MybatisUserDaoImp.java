package com.zyh.spring.dao;

import org.springframework.stereotype.Component;

import com.zyh.spring.pojo.User;

@Component("mybatisUser")
public class MybatisUserDaoImp implements UserDao{

	@Override
	public User getById(Long id) {
		System.out.println("使用Mybatis查找用户");
		return null;
	}

}
