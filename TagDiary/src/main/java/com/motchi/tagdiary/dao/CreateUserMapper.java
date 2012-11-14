package com.motchi.tagdiary.dao;

import org.apache.ibatis.annotations.Insert;

import com.motchi.tagdiary.common.annotation.SqlMapper;
import com.motchi.tagdiary.dto.UserDto;

@SqlMapper
public interface CreateUserMapper {

	@Insert("INSERT INTO user (" +
			"	iduser," +
			"	userid," +
			"	password" +
			") VALUES (" +
			"	(SELECT maxnumber + 1 FROM (SELECT IFNULL(MAX(iduser), -1) AS maxnumber FROM user) maxnum)," +
			"	#{userId}," +
			" 	#{hashedPassword}" +
			")")
	public void insertUser(UserDto userDto);

}
