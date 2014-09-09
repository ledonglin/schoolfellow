package com.flyingbiz.user.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.flyingbiz.exception.UserExistException;
import com.flyingbiz.user.dao.BaseHibernateDAO;
import com.flyingbiz.user.dao.LoginLogDao;
import com.flyingbiz.user.entity.LoginLog;
import com.flyingbiz.user.entity.User;

@Repository
public class LoginLogDaoImpl extends BaseHibernateDAO implements LoginLogDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginLogDaoImpl.class);

	@Override
	public void login(LoginLog log) {
		logger.debug("login start...");
		getSession().save(log);
		logger.debug("login end...");
	}

}
