package com.hcl.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.RegistrationRequestDTO;
import com.hcl.entity.Registration;
import com.hcl.repository.RegistrationRepository;

@Service

@Transactional

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired

	RegistrationRepository registrationRepository;

	public Registration registerCustomer(RegistrationRequestDTO registrationRequestDto) {

		{

			

			Registration registration = new Registration();

			BeanUtils.copyProperties(registrationRequestDto, registration);
			return registrationRepository.save(registration);
			


		}
		

	}
}
