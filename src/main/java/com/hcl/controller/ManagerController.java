package com.hcl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.ManageService;
import com.hcl.dto.*;

@RestController
@RequestMapping("/ingretail")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ManagerController {
	private Logger logger = LoggerFactory.getLogger(ManagerController.class);
	@Autowired
	private ManageService adminService;

	@GetMapping("/admin")
	public ResponseEntity<List<RegistrationDetailsResDTO>> getRegistrationDetails() {
		logger.info("starts get registration details");
		List<RegistrationDetailsResDTO> registratonListResDto = adminService.getRegistrationDetails();
		logger.info("end get registration details");
		return new ResponseEntity<>(registratonListResDto, HttpStatus.OK);
	}
	
	@PutMapping("/adminapprove/{regId}")
	public ResponseEntity<String>  approveUsers(@PathVariable Long regId){
		logger.info("starts approve registration details in controller");
		String message = adminService.approveUsers(regId);
		logger.info("starts approve registration details in controller");
		return new ResponseEntity<>(message, HttpStatus.CREATED);
		
		
	}
}
