package com.zyh.spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zyh.spring.pojo.User;

@Component("dBUtilsUser")
//@Repository("dBUtilsUser")
//@Service("dBUtilsUser")
public class DBUtilsUserDaoImp implements UserDao{

	@Override
	public User getById(Long id) {
		System.out.println("使用DBUtils查找用户");
		return null;
	}

}
