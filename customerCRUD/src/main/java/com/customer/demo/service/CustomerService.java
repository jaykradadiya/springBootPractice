package com.customer.demo.service;

import java.util.List;

import com.customer.demo.DTO.CustomerDTO;
import com.customer.demo.entity.Customer;

public interface CustomerService {
	
	Customer customerToCustomerDTO(CustomerDTO customerDTO);
	
	CustomerDTO customerDTOToCustomer(Customer customer);
	
	List<CustomerDTO> findAll();
	
	CustomerDTO findAllById(Integer id);
	
	CustomerDTO save(CustomerDTO customerDTO);
	
	CustomerDTO updateByID(Integer id,CustomerDTO customerDTO);
	
	CustomerDTO deleteById(Integer Id);
}
