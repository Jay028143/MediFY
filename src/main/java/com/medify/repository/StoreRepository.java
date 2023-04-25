package com.medify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Store;



public interface StoreRepository extends JpaRepository<Store, Long>{

	List<Store> findByAdminId(Long adminId);
}
