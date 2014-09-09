package com.flyingbiz.user.dao;

import com.flyingbiz.exception.UserExistException;
import com.flyingbiz.user.entity.User;

public interface UserDao {

	public User findUserByLoginName(String loginName);

	public void regeistUser(User user);

	public void update(User user);

}
