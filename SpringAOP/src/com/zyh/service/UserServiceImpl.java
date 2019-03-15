package com.zyh.service;

import com.zyh.pojo.User;

public class UserServiceImpl implements UserService {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("调用DAO将数据保存到数据库");
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println("调用DAO将数据更新");
		
	}

}
