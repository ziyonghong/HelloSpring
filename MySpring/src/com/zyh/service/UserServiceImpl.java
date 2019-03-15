package com.zyh.service;

import com.zyh.dao.UserDao;

public class UserServiceImpl implements UserService{
private UserDao userDao;

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}
}
