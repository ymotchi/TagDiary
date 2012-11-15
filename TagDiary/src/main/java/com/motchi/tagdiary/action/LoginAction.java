package com.motchi.tagdiary.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.motchi.tagdiary.common.util.Constant;
import com.motchi.tagdiary.dto.UserDto;
import com.motchi.tagdiary.service.UserService;

@Results({
		@Result(name = "loginInit", location = "login.jsp"),
		@Result(name = "login", location = "/edit", type = "redirect")
})
public class LoginAction implements SessionAware {

	@Resource
	private UserService loginService;

	private Map<String, Object> session;

	public String userId;
	public String password;

	@Action("/login_init")
	public String initDisplay() {
		return "loginInit";
	}

	@Action("/login")
	public String login() {
		UserDto user = loginService.selectUser(userId, password);
		if (user == null) {
			return "loginInit";
		} else {
			session.put(Constant.SESSION_USER_INFO, user);
			return "login";
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
