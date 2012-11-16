package com.motchi.tagdiary.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.motchi.tagdiary.dto.TagDto;
import com.motchi.tagdiary.service.TagService;

@ParentPackage("tagdiary")
@Results({
	@Result(name = "edit", location = "edit_diary.jsp"),
	@Result(name = "save", type = "json", params = {"root", "result"})
})
public class EditAction {

	private static final Log log = LogFactory.getLog(EditAction.class);

	@Resource
	private TagService tagService;

	private List<TagDto> tag;

	private List<String> data;

	public List<TagDto> getTag() {
		return tag;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	@Action("/edit")
	public String editDiary() {
		tag = tagService.selectTags();
		return "edit";
	}

	@Action("/save")
	public String save() {
		log.debug(data.size() + " tags received");
		tagService.updateTags(data);
		return "save";
	}

	public List<String> getResultList() {
		List<String> result = new ArrayList<>();
		result.add("success");
		return result;
	}

}
