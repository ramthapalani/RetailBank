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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.StatementService;
import com.hcl.dto.StatementResDto;
@RestController
@RequestMapping("/ingretail")
@CrossOrigin(allowedHeaders= {"*", "*/"}, origins = {"*", "*/"})
public class StatementController {
	

	private Logger logger = LoggerFactory.getLogger(StatementController.class);

	@Autowired
	StatementService statementService;
	
	@GetMapping("/accountstatement/{accountNumber}")
	public ResponseEntity<List<StatementResDto>> getStatements(@PathVariable Long accountNumber) {
		logger.info("statements controller starts");
		List<StatementResDto> statementsDtos = statementService.getTransactionHistory(accountNumber);
		logger.info("statements controller ends");
		return new ResponseEntity<>(statementsDtos, HttpStatus.OK);
	}

}
