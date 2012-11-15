package com.motchi.tagdiary.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.motchi.tagdiary.common.util.Constant;
import com.motchi.tagdiary.dao.TagMapper;
import com.motchi.tagdiary.dto.TagDto;
import com.motchi.tagdiary.dto.UserDto;
import com.opensymphony.xwork2.ActionContext;

@Service
public class TagService {

	@Resource
	private TagMapper tagMapper;

	public List<TagDto> selectTags() {
		UserDto loginUser = (UserDto) ActionContext.getContext().getSession().get(Constant.SESSION_USER_INFO);
		int idUser = loginUser.getIdUser();

		return tagMapper.selectTags(idUser);
	}

	public void updateTags(List<String> data) {
		// そのユーザの付箋を全削除し追加を行う。
		UserDto loginUser = (UserDto) ActionContext.getContext().getSession().get(Constant.SESSION_USER_INFO);
		int idUser = loginUser.getIdUser();

		tagMapper.deleteUserTags(idUser);

		for (String tagData : data) {
			String[] properties = tagData.split(",", 5);

			TagDto tag = new TagDto();
			tag.setIdUser(idUser);
			tag.setX(Integer.parseInt(properties[0]));
			tag.setY(Integer.parseInt(properties[1]));
			tag.setWidth(Integer.parseInt(properties[2]));
			tag.setHeight(Integer.parseInt(properties[3]));
			tag.setContents(properties[4]);

			tagMapper.insertTag(tag);
		}
	}

}
