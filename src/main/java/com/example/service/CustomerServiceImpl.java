package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.model.CustomerList;
import com.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(final Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public CustomerList readCustomers() {

		final CustomerList customerList = new CustomerList();
		customerList.setCustomers(customerRepository.findAll());
		return customerList;
	}

	@Override
	public Customer readCustomer(final Long customerId) {

		return customerRepository.findOne(customerId);
	}

	@Override
	public void updateCustomer(final Long customerId, final Customer customer) {

		throw new RuntimeException("not yet implemented");
	}

	@Override
	public void deleteCustomer(final Long customerId) {

		throw new RuntimeException("not yet implemented");
	}

}
