package com.example.service;

import com.example.model.Customer;
import com.example.model.CustomerList;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	CustomerList readCustomers();

	Customer readCustomer(Long customerId);

	void updateCustomer(Long customerId, Customer customer);

	void deleteCustomer(Long customerId);

}
