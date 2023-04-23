package com.medify.service;


import java.util.List;

import com.medify.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	List<Customer> fetchAllCustomers();
	
	Customer getCustomerById(Long id);
	
	Customer updateCustomerById(Long id,Customer customer);
	
	void deleteCustomerById(Long id);
}
