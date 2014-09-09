package com.flyingbiz.user.service;

import com.flyingbiz.exception.UserExistException;
import com.flyingbiz.user.entity.LoginLog;
import com.flyingbiz.user.entity.User;

public interface LoginService {

	User userLogin(User user, LoginLog log);
	
	void save(User user) throws UserExistException;
	
	void updateUser(User user);
}
