package com.motchi.tagdiary.dto;

public class UserDto {

	private int idUser;
	private String userId;
	private String hashedPassword;

	public UserDto() {}

	public UserDto(String userId, String hashedPassword) {
		this.userId = userId;
		this.hashedPassword = hashedPassword;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
