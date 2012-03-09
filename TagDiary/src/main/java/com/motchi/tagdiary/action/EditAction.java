package com.motchi.tagdiary.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Result(name = "edit", location = "edit_diary.jsp")
public class EditAction {

	@Action("/edit")
	public String editDiary() {
		return "edit";
	}

}
