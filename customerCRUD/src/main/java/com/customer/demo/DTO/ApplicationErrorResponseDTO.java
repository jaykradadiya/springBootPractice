package com.customer.demo.DTO;

public class ApplicationErrorResponseDTO {
	private int statusCode;
	private String message;
	public ApplicationErrorResponseDTO(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public ApplicationErrorResponseDTO() {
		super();
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
