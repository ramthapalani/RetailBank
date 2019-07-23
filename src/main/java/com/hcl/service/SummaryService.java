package com.hcl.service;

import com.hcl.dto.RegistrationDTO;

public interface SummaryService {

	RegistrationDTO accountSummaryDetails(Long userId);

}
