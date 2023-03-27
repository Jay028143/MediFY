package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
