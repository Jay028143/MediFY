package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Customer;
import com.medify.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> fetchAllCustomers() {	
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent())
		{
			return customer.get();
		}
		return null;
	}

	@Override
	public Customer updateCustomerById(Long id, Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		 customerRepository.deleteById(id);
	}

}
