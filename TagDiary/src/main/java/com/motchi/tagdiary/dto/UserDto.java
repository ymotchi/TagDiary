package com.motchi.tagdiary.dto;

public class UserDto {

	private String userId;
	private String hashedPassword;

	public UserDto(String userId, String hashedPassword) {
		this.userId = userId;
		this.hashedPassword = hashedPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

}
