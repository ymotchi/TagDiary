package com.motchi.tagdiary.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;

@InterceptorRefs({
	@InterceptorRef("clearSession"),
	@InterceptorRef("defaultStack")
})
@Result(name = "logout", location = "/login_init", type = "redirect")
public class LogoutAction {

	@Action("/logout")
	public String logout() {
		return "logout";
	}

}
