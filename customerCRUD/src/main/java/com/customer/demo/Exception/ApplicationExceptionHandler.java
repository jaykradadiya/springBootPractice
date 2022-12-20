package com.customer.demo.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customer.demo.DTO.ApplicationErrorResponseDTO;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = CustomerServiceException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ApplicationErrorResponseDTO handleUserServiceException(CustomerServiceException ex) {
		return new ApplicationErrorResponseDTO(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
	}

}
