package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.AccountRequestDTO;
import com.hcl.dto.AccountResponseDTO;
import com.hcl.dto.RegistrationRequestDTO;
import com.hcl.dto.RegistrationResponseDTO;
import com.hcl.service.AccountService;

@RestController

@RequestMapping("/ingretail")

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AccountController {
	@Autowired

	AccountService accountService;

	@PostMapping("/account")
	public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {

		accountService.createAccount(accountRequestDTO);
		AccountResponseDTO accountResponseDTO=new AccountResponseDTO();
		accountResponseDTO.setMessage("You have been Successfully Registered");

			return new ResponseEntity<>(accountResponseDTO, HttpStatus.CREATED);

	}

}
