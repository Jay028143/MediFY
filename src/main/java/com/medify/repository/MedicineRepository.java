package com.medify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	Optional<Medicine> findByStoreIdAndMedicineCode(Long storeId,String medicineCode);
	
	List<Medicine> findByStoreId(Long storeId);
	
}
