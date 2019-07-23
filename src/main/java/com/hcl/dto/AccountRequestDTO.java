package com.hcl.dto;

import java.io.Serializable;

public class AccountRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userId;
	private String accountType;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public AccountRequestDTO() {
		super();
	}
	public AccountRequestDTO(long userId, String accountType) {
		super();
		this.userId = userId;
		this.accountType = accountType;
	}

}
