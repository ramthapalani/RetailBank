package com.hcl.exception;

public class InvalidTransactionDataException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  InvalidTransactionDataException(String exception) {
		super(exception);
	}

}
