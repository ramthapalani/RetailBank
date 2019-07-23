package com.hcl.dto;

public class AdminDTO {
	private Long userId;
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminDTO(Long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

}
