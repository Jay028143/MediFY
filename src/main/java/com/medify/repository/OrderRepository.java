package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
