package com.motchi.tagdiary.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.motchi.tagdiary.service.IndexService;

@Results({
	@Result(name = "success", location = "index.jsp"),
	@Result(name = "submit", location = "submit.jsp")
})
public class IndexAction {

	@Resource
	private IndexService indexService;

	@Action("/index")
	public String index() {
		return "success";
	}

	public String message;
	public String result;

	@Action("/submit")
	public String submit() throws Throwable {
		indexService.insertTestData(message);
		result = String.format("「%s」が入力されました", message);
		return "submit";
	}

}
