package com.motchi.tagdiary.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.motchi.tagdiary.common.util.Converter;
import com.motchi.tagdiary.dao.LoginMapper;
import com.motchi.tagdiary.dto.UserDto;

@Service
public class LoginService {

	@Resource
	private LoginMapper loginMapper;

	public boolean login(String userId, String password) {
		String hashedPassword = Converter.hashPassword(password);
		return loginMapper.countUser(new UserDto(userId, hashedPassword)) > 0;
	}

}
