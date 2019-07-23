package com.hcl.service;

import com.hcl.dto.RegistrationRequestDTO;
import com.hcl.entity.Registration;

public interface RegistrationService {

	Registration registerCustomer(RegistrationRequestDTO registrationRequestDto);

}
