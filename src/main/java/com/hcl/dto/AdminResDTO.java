package com.hcl.dto;

public class AdminResDTO {

	private Long adminUserID;
	private String adminMessage;

	public AdminResDTO() {
		
	}
	public Long getAdminUserID() {
		return adminUserID;
	}
	public String getAdminMessage() {
		return adminMessage;
	}
	
	public void setAdminUserID(Long adminUserID) {
		this.adminUserID = adminUserID;
	}
	public void setAdminMessage(String adminMessage) {
		this.adminMessage = adminMessage;
	}
	
	public AdminResDTO(Long adminUserID, String adminMessage, Long registrationUserId, String registrationMessage) {
		super();
		this.adminUserID = adminUserID;
		this.adminMessage = adminMessage;
		
	}
}
	
	
