package com.medify.service;


import java.util.List;

import com.medify.entity.Medicine;

public interface MedicineService {

	Medicine saveMedicine(Medicine medicine);
	
	List<Medicine> fetchAllMedicines();
	
	Medicine getMedicineById(Long id);
	
	Medicine updateMedicineById(Long id,Medicine medicine);
	
	void deleteMedicineById(Long id);
}
