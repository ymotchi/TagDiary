package com.motchi.tagdiary.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.motchi.tagdiary.service.UserService;

@Results({
	@Result(name = "createUserInit", location = "create_user.jsp"),
	@Result(name = "createUser", location = "/create_user_init", type = "redirect")
})
public class CreateUserAction {

	@Resource
	private UserService userService;

	private String userId;
	private String password;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Action("/create_user_init")
	public String createUserInit() {
		return "createUserInit";
	}

	@Action("/create_user")
	public String createUser() {
		userService.insertUser(userId, password);
		return "createUser";
	}

}
