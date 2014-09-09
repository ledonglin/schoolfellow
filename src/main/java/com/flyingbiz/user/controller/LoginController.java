package com.flyingbiz.user.controller;

import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.whu.utils.StringUtils;

import com.flyingbiz.user.entity.FileInfo;
import com.flyingbiz.user.entity.HoldType;
import com.flyingbiz.user.entity.LoginLog;
import com.flyingbiz.user.entity.Role;
import com.flyingbiz.user.entity.User;
import com.flyingbiz.user.service.LoginService;
import com.flyingbiz.user.service.RoleService;
import com.flyingbiz.user.service.UserService;
import com.flyingbiz.utils.Constant;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String welcome2(@RequestParam String rolename) {
		logger.debug("abc");

		Role role = new Role();
		role.setRoleId(UUID.randomUUID().toString());
		role.setRoleName("dawang");
		;
		role.setRolePath("this is path");
		roleService.addNewRole(role);

		ModelAndView mv = new ModelAndView();
		mv.addObject("role", roleService.getRoleById(role.getRoleId()));

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, User user) {
		logger.debug("User : " + user + " login start...");

		ModelAndView mv = new ModelAndView();
		LoginLog loginLog = initLoginLog(request);
		User dbUser = loginService.userLogin(user, loginLog);
		if (dbUser == null) {
			mv.addObject(Constant.ERROR_MSG_KEY, "用户名不存在或密码不正确");
		} else {
			setSessionUser(request, dbUser);
			mv.addObject("user", dbUser);

			String url = (String) request.getSession().getAttribute(
					Constant.FORWARD_URL);
			if (StringUtils.isBlank(url)) {
				url = "index";
			}
//			mv.setViewName("dashboard");
			mv.addObject("fileInfo", new FileInfo());
			mv.addObject("holdTypeValues", HoldType.values());
			mv.setViewName("uploadFile");

		}

		logger.debug("User : " + user + " login end..." + dbUser == null ? "SUCCESS"
				: "FAILURE");

		return mv;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		logger.debug("User : logout start...");
		session.removeAttribute(Constant.USER_CONTEXT);
		logger.debug("User : logout end ...");

		return "forward:/index.jsp";
	}

}
