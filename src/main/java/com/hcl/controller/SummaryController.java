package com.hcl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.RegistrationDTO;
import com.hcl.service.SummaryService;

@RestController
@RequestMapping("/ingretail")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })

public class SummaryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SummaryController.class);

	@Autowired
	private SummaryService summaryService;
	
	@GetMapping("/summary/{userId}")
	public ResponseEntity<RegistrationDTO> accountSummary(@PathVariable Long userId){
		LOGGER.debug("accountSummary of user id :"+userId);
		RegistrationDTO registrationDTO=summaryService.accountSummaryDetails(userId);
		return new ResponseEntity<>(registrationDTO,HttpStatus.OK);
	}

}
