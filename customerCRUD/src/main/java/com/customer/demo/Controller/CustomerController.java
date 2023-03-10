package com.customer.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.DTO.CustomerDTO;
import com.customer.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/")
	List<CustomerDTO> findAll(){
		return customerService.findAll();
	}
	

	@GetMapping("/{id}")
	CustomerDTO findAllById(@PathVariable("id") Integer id) {
		return customerService.findAllById(id);
	}
	
	@PostMapping("/")
	CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
		return customerService.save(customerDTO);
	}
	
	@PutMapping("/{id}")
	CustomerDTO updateByID(@PathVariable("id") Integer Id,@RequestBody CustomerDTO customerDTO) {
		return customerService.updateByID(Id,customerDTO);
	}
	
	@DeleteMapping("/{id}")
	CustomerDTO deleteById(@PathVariable("id") Integer Id) {
		return customerService.deleteById(Id);
	}
}

