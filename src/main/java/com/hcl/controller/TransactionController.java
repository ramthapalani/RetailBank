package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.TransactionReqDTO;
import com.hcl.dto.FundTransaferResponse;
import com.hcl.service.TransactionServiceImpl;

@RestController
@RequestMapping(value="/ingretail")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class TransactionController {
	
	@Autowired
	TransactionServiceImpl  transactionServiceImpl;
	
	@PostMapping(value="/transaction")
	public ResponseEntity<FundTransaferResponse> fundTransfer(@RequestBody TransactionReqDTO transactionReqDTO)
	{
		
		FundTransaferResponse fundTransaferResponse=transactionServiceImpl.fundTransfer(transactionReqDTO);
		return new ResponseEntity<>(fundTransaferResponse,HttpStatus.OK) ;
		
	}

}
