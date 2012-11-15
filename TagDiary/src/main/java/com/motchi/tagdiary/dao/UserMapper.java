package com.motchi.tagdiary.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.motchi.tagdiary.common.annotation.SqlMapper;
import com.motchi.tagdiary.dto.UserDto;

@SqlMapper
public interface UserMapper {

	@Insert("INSERT INTO user (" +
			"	iduser," +
			"	userid," +
			"	password" +
			") VALUES (" +
			"	(SELECT maxnumber + 1 FROM (SELECT IFNULL(MAX(iduser), -1) AS maxnumber FROM user) maxnum)," +
			"	#{userId}," +
			" 	#{hashedPassword}" +
			")")
	public void insertUser(UserDto user);

	@Select("SELECT iduser AS idUser," +
			"		userid AS userId," +
			"		password AS hassedPassword" +
			"  FROM user" +
			" WHERE userid = #{userId}" +
			"   AND password = #{hashedPassword}")
	public UserDto selectUser(UserDto user);

}
