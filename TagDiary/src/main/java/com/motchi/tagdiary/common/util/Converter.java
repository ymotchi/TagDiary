package com.motchi.tagdiary.common.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Converter {

	public static String hashPassword(String password) {
		return DigestUtils.sha512Hex(password + "_tagDiary");
	}

}
