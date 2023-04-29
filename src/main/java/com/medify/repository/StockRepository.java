package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medify.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
