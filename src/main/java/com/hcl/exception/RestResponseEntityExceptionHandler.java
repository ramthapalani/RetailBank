package com.hcl.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value 
			= { IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(
			RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), 
				new HttpHeaders(), HttpStatus.NO_CONTENT, request);
	}
	
	
	
	@ExceptionHandler(value 
			= { InvalidTransactionDataException.class, MinimumBalanceException.class })
	protected ResponseEntity<ErrorResponse> handleApplicationException(
			RuntimeException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
	}
	
	@ExceptionHandler(value 
			= { DataNotFoundException.class })
	protected ResponseEntity<ErrorResponse> handleApplicationDataNotFoundException(
			RuntimeException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}
	
}
