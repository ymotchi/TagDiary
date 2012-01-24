package com.motchi.tagdiary.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.motchi.tagdiary.service.IndexService;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name = "success", location = "index.jsp"),
	@Result(name = "submit", location = "submit.jsp")
})
public class IndexAction extends ActionSupport {

	@Resource
	private IndexService indexService;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

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
