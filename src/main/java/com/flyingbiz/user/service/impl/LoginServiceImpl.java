package com.flyingbiz.user.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyingbiz.exception.UserExistException;
import com.flyingbiz.user.dao.LoginLogDao;
import com.flyingbiz.user.dao.UserDao;
import com.flyingbiz.user.entity.LoginLog;
import com.flyingbiz.user.entity.User;
import com.flyingbiz.user.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	@Override
	public User userLogin(User user, LoginLog loginLog) {
		User dbUser = this.userDao.findUserByLoginName(user.getUserName());
		if (null != dbUser) {
			loginLog.setUserId(dbUser.getUserId());
			loginLogDao.login(loginLog);
			return dbUser;
		} else {
			loginLog.setUserId("Unknow User:" + user.getUserName());
			loginLogDao.login(loginLog);
			return null;
		}

	}

	/**
	 * 注册一个新用户,如果用户名已经存在此抛出UserExistException的异常
	 * 
	 * @param user
	 */
	@Override
	public void save(User user) throws UserExistException {
		User dbUser = userDao.findUserByLoginName(user.getUserName());
		if (dbUser != null) {
			throw new UserExistException("用户名已经存在");
		} else {
			user.setUserId(UUID.randomUUID().toString());
			userDao.regeistUser(user);;
		}
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}


}
