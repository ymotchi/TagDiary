package com.motchi.tagdiary.dao;

import org.apache.ibatis.annotations.Select;

import com.motchi.tagdiary.common.annotation.SqlMapper;
import com.motchi.tagdiary.dto.UserDto;

@SqlMapper
public interface LoginMapper {

	@Select("SELECT COUNT(*)" +
			"  FROM user" +
			" WHERE userid = #{userId}" +
			"   AND password = #{hashedPassword}")
	public int countUser(UserDto userDto);

}
