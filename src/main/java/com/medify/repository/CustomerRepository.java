package com.medify.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medify.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value= "select * from customers where store_id in :storeIds and date_Of_birth =:dob",nativeQuery = true )
	List<Customer> findByStoreIdsAndDateOfBirth(@Param("storeIds") List<Long> storeIds,@Param("dob") Date dateOfBirth);

	@Query(value= "select * from customers where store_id in :storeIds ",nativeQuery = true )
	List<Customer> findByStoreIds(@Param("storeIds")List<Long> ids);
	
}
