package com.medify.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Customer;
import com.medify.repository.CustomerRepository;
import com.medify.repository.StoreRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
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

	@Override
	public List<Customer> getCustomerByDateOfBirth(Date dateofBirth, Long storeId) {
		
		List<Long> storeIds=storeRepository.getAllStoreIds(storeId);
		return customerRepository.findByStoreIdsAndDateOfBirth(storeIds,dateofBirth);
	}

	@Override
	public List<Customer> getCustomerByStoreId(Long storeId) {
		List<Long> storeIds=storeRepository.getAllStoreIds(storeId);
		return customerRepository.findByStoreIds(storeIds);
	}

}
