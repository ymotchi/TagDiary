package com.motchi.tagdiary.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.motchi.tagdiary.service.CreateUserService;

@Results({
	@Result(name = "createUserInit", location = "create_user.jsp"),
	@Result(name = "createUser", location = "/init", type = "redirect")
})
public class CreateUserAction {

	@Resource
	private CreateUserService createUserService;

	public String userId;
	public String password;

	@Action("/create_user_init")
	public String createUserInit() {
		return "createUserInit";
	}

	@Action("/create_user")
	public String createUser() {
		createUserService.insertUser(userId, password);
		return "createUser";
	}

}
