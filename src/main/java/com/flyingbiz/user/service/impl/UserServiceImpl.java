package com.flyingbiz.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyingbiz.user.dao.LoginLogDao;
import com.flyingbiz.user.dao.UserDao;
import com.flyingbiz.user.entity.User;
import com.flyingbiz.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	@Override
	public User findUserbyLoginName(User user) {
		return userDao.findUserByLoginName(user.getUserName());
	}

}
