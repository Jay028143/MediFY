package com.medify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findByStoreId(Long storeId);

}
