package com.motchi.tagdiary.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.motchi.tagdiary.service.LoginService;

@Results({
		@Result(name = "loginInit", location = "login.jsp"),
		@Result(name = "login", location = "/edit", type = "redirect")
})
public class LoginAction {

	@Resource
	private LoginService loginService;

	public String userId;
	public String password;

	@Action("/login_init")
	public String initDisplay() {
		return "loginInit";
	}

	@Action("/login")
	public String login() {
		return loginService.login(userId, password) ? "login" : "loginInit";
	}

}
