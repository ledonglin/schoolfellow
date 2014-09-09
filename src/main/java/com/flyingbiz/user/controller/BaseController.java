package com.flyingbiz.user.controller;

import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.flyingbiz.user.entity.LoginLog;
import com.flyingbiz.user.entity.User;
import com.flyingbiz.utils.Constant;

public class BaseController {
	private static final Logger logger = Logger.getLogger(BaseController.class);

	public User getSessionUser(HttpServletRequest request) {
		logger.debug("invoke getSessionuser...");
		return (User) request.getSession().getAttribute(Constant.USER_CONTEXT);
	}

	public void setSessionUser(HttpServletRequest request, User user) {
		logger.debug("invoke setSessionUser..." + user.toString());

		request.getSession().setAttribute(Constant.USER_CONTEXT, user);
	}
	

	protected LoginLog initLoginLog(HttpServletRequest request) {
		LoginLog loginLog = new LoginLog();
		loginLog.setLoginId(UUID.randomUUID().toString());
		loginLog.setIp(request.getRemoteAddr());
		loginLog.setLoginTime(new Timestamp(System.currentTimeMillis()));

		return loginLog;
	}

}
