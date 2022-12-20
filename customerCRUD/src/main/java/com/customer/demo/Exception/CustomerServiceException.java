package com.customer.demo.Exception;

public class CustomerServiceException extends RuntimeException {

	private String message;
	
	public CustomerServiceException() {
		super();
	}
	
	public CustomerServiceException(String message) {
		super(message);
		this.message = message;
		
	}
}
