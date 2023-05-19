package com.medify.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.medify.entity.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	Optional<Medicine> findByStoreIdAndMedicineCode(Long storeId,String medicineCode);
	
	List<Medicine> findByStoreId(Long storeId);

	@Query(value= "select store_id from medicines where store_id in :storeIds and available_stock>10 and medicine_code= :medicineCode",nativeQuery = true )
	List<Long> findMedicineAvailabilityAtStore(@Param("storeIds") List<Long> storeIds,@Param("medicineCode") String medicineCode);
	
	Optional<Medicine> findByMedicineId(Long medicineId);
}
