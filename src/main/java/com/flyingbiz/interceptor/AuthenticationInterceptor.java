package com.flyingbiz.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.whu.utils.Config;

import com.flyingbiz.user.controller.BaseController;
import com.flyingbiz.user.entity.User;


/**
 * This is for check whether the user is login platform
 * @author LLin
 *
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(BaseController.class);
    protected static final String COMMAND_TAG = "command";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String byPathURL = Config.get("byPassURL");
		String command = request.getServletPath();
		if(command.endsWith(byPathURL))
			return true;
		else {
			HttpSession session = request.getSession(false);
			if(session == null){
				//重定向到登录页面
				logger.info("User Unauthentication from IP: " + request.getRemoteAddr());
				response.sendRedirect("login");
			} else {
				User user = (User) session.getAttribute("loginUser");
				if(user != null) {
					logger.info("User login ");
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
