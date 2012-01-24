package com.motchi.tagdiary.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.motchi.tagdiary.dao.IndexMapper;

@Service
public class IndexService {

	@Resource
	private IndexMapper indexMapper;

	public void insertTestData(String data) throws Throwable {
		indexMapper.insertTestData(data);

		switch (data) {
		case "throwable":
			throw new Throwable();
		case "exception":
			throw new Exception();
		default:
			return;
		}
	}

}
