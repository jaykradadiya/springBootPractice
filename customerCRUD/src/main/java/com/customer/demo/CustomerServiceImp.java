package com.customer.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.demo.DTO.CustomerDTO;
import com.customer.demo.Exception.CustomerServiceException;
import com.customer.demo.entity.Customer;
import com.customer.demo.repository.CustomerRepository;
import com.customer.demo.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Customer customerToCustomerDTO(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		
		if(customerDTO.getId()!= null)
			customer.setId(customerDTO.getId());
		customer.setAge(customerDTO.getAge());
		customer.setEmail(customerDTO.getEmail());
		customer.setName(customerDTO.getName());
		
		return customer;
	}
	
	public void customerToCustomerDTOUpdate(Customer customer,CustomerDTO customerDTO) {
		
		customer.setAge(customerDTO.getAge());
		customer.setEmail(customerDTO.getEmail());
		customer.setName(customerDTO.getName());

	}

	@Override
	public CustomerDTO customerDTOToCustomer(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer .getId());
		customerDTO.setAge(customer.getAge());
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getEmail());
		return customerDTO;
	}
	
	

	@Override
	public List<CustomerDTO> findAll() {
		
		List<Customer > customers = customerRepository.findAll();
		List<CustomerDTO> customerDTO = new ArrayList<CustomerDTO>(customers.size());
		
		for(Customer customer : customers) {
			customerDTO.add(this.customerDTOToCustomer(customer));
		}
	
		return customerDTO;
	}

	@Override
	public CustomerDTO findAllById(Integer id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerServiceException("User Not Found"));
		return this.customerDTOToCustomer(customer);
	}

	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		
		Customer customer = this.customerToCustomerDTO(customerDTO);
		customerRepository.save(customer);
		return this.customerDTOToCustomer(customer);
	}

	@Override
	public CustomerDTO updateByID(Integer id,CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerServiceException("User Not Found"));
		
		this.customerToCustomerDTOUpdate(customer, customerDTO);
		customerRepository.save(customer);
		return this.customerDTOToCustomer(customer);
	}


	@Override
	public CustomerDTO deleteById(Integer id) {
		
		CustomerDTO customer = this.findAllById(id);
		customerRepository.deleteById(id);
		return customer;
	}

	
}
