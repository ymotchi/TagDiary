package com.motchi.tagdiary.dao;

import org.apache.ibatis.annotations.Insert;

import com.motchi.tagdiary.common.annotation.SqlMapper;

@SqlMapper
public interface IndexMapper {

	@Insert("INSERT INTO testtable (" +
			"	idtesttable," +
			"	testcolumn" +
			") VALUES (" +
			"	(SELECT maxnumber + 1 FROM (SELECT IFNULL(MAX(idtesttable), -1) AS maxnumber FROM testtable) maxnum)," +
			"	#{data}" +
			")")
	public void insertTestData(String data);

}
