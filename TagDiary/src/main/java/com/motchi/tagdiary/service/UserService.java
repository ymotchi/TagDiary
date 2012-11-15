package com.motchi.tagdiary.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.motchi.tagdiary.common.util.Converter;
import com.motchi.tagdiary.dao.UserMapper;
import com.motchi.tagdiary.dto.UserDto;

@Service
public class UserService {

	@Resource
	private UserMapper userMapper;

	public void insertUser(String userId, String password) {
		String hashedPassword = Converter.hashPassword(password);
		userMapper.insertUser(new UserDto(userId, hashedPassword));
	}

	public UserDto selectUser(String userId, String password) {
		String hashedPassword = Converter.hashPassword(password);
		return userMapper.selectUser(new UserDto(userId, hashedPassword));
	}

}
