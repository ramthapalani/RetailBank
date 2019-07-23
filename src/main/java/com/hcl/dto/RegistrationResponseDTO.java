package com.hcl.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty

	private long regId;

	@JsonProperty

	private String firstName;

	@JsonProperty

	private String lastName;

	@JsonProperty

	private String email;
	@JsonProperty

	private long contactNumber;

	@JsonProperty

	private String city;
	@JsonProperty

	private String accountType;
	public long getRegId() {
		return regId;
	}
	public void setRegId(long regId) {
		this.regId = regId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public RegistrationResponseDTO(long regId, String firstName, String lastName, String email, long contactNumber,
			String city, String accountType) {
		super();
		this.regId = regId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.city = city;
		this.accountType = accountType;
	}
	public RegistrationResponseDTO() {
		super();
	}

}
