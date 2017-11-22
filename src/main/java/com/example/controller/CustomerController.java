package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.model.CustomerList;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping()
	public CustomerList getCustomers() {
		
		return customerService.readCustomers();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomer(final @PathVariable("customerId") Long customerId) {

		return customerService.readCustomer(customerId);
	}

	@PostMapping()
	public Customer postCutomer(final @RequestBody Customer customer) {

		return customerService.createCustomer(customer);
	}

}