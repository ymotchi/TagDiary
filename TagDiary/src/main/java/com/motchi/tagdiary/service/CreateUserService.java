package com.motchi.tagdiary.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.motchi.tagdiary.common.util.Converter;
import com.motchi.tagdiary.dao.CreateUserMapper;
import com.motchi.tagdiary.dto.UserDto;

@Service
public class CreateUserService {

	@Resource
	private CreateUserMapper createUserMapper;

	public void insertUser(String userId, String password) {
		String hashedPassword = Converter.hashPassword(password);
		createUserMapper.insertUser(new UserDto(userId, hashedPassword));
	}

}
