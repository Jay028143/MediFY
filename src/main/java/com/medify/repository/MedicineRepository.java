package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
