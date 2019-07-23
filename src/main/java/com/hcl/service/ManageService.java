package com.hcl.service;

import java.util.List;

import com.hcl.dto.RegistrationDetailsResDTO;


public interface ManageService {

	List<RegistrationDetailsResDTO> getRegistrationDetails();

	String approveUsers(Long regId);

}
