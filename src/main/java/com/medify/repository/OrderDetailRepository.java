package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}

