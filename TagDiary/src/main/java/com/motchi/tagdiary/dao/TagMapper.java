package com.motchi.tagdiary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.motchi.tagdiary.common.annotation.SqlMapper;
import com.motchi.tagdiary.dto.TagDto;

@SqlMapper
public interface TagMapper {

	@Insert("INSERT INTO tag (" +
			"	idtag," +
			"	iduser," +
			"	tagseq," +
			"	x," +
			"	y," +
			"	width," +
			"	height," +
			"	contents" +
			") VALUES (" +
			"	(SELECT maxnumber + 1 FROM (SELECT IFNULL(MAX(idtag), -1) AS maxnumber FROM tag) maxnum)," +
			"	#{idUser}," +
			"	(SELECT maxnumber + 1 FROM (SELECT IFNULL(MAX(tagseq), -1) AS maxnumber FROM tag WHERE iduser = #{idUser}) maxnum)," +
			"	#{x}," +
			"	#{y}," +
			"	#{width}," +
			"	#{height}," +
			"	#{contents}" +
			")")
	public void insertTag(TagDto tag);

	@Select("SELECT idtag AS idTag," +
			"		iduser AS idUser," +
			"		tagseq AS tagSeq," +
			"		x," +
			"		y," +
			"		width," +
			"		height," +
			"		contents" +
			"  FROM tag" +
			" WHERE iduser = #{idUser}")
	public List<TagDto> selectTags(int idUser);


	@Delete("DELETE FROM tag" +
			" WHERE iduser = #{idUser}")
	public void deleteUserTags(int idUser);

}
