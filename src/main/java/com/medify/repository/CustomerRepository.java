package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
