package com.hcl.dto;

import java.io.Serializable;

public class AccountResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AccountResponseDTO() {
		super();
	}
	public AccountResponseDTO(String message) {
		super();
		this.message = message;
	}
	
	

}
