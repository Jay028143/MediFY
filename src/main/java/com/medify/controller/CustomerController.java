package com.medify.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.Customer;
import com.medify.service.CustomerService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.fetchAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }
    
    @GetMapping("/getCustomerByStoreId/{storeId}")
    public List<Customer> getCustomerByStoreId(@PathVariable Long storeId ){
    	
        return customerService.getCustomerByStoreId(storeId);
    }
    
    @GetMapping("/getCustomerByDateOfBirth/{storeId}/{dateofBirth}")
    public List<Customer> getCustomerByDateOfBirth(@PathVariable String dateofBirth ,@PathVariable Long storeId) throws ParseException {
    	
    	Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(dateofBirth);
        return customerService.getCustomerByDateOfBirth(dob,storeId);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer currentCustomer = customerService.updateCustomerById(customerId, customer);
        return ResponseEntity.ok(currentCustomer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok().build();
    }

}
