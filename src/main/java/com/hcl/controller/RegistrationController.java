package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.RegistrationRequestDTO;
import com.hcl.dto.RegistrationResponseDTO;
import com.hcl.service.RegistrationService;

@RestController

@RequestMapping("/ingretail")

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })

public class RegistrationController {

	@Autowired

	RegistrationService registrationService;

	@PostMapping("/registration")

	public ResponseEntity<RegistrationResponseDTO> registerCustomer(
			@RequestBody RegistrationRequestDTO registrationRequestDto) {

		 registrationService.registerCustomer(registrationRequestDto);
		RegistrationResponseDTO registrationResponseDto= new RegistrationResponseDTO();
		
		

		return new ResponseEntity<>(registrationResponseDto, HttpStatus.CREATED);

	}
}
