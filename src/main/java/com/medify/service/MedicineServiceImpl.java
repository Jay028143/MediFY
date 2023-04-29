package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Medicine;
import com.medify.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository productRepository;
	
	@Override
	public Medicine saveMedicine(Medicine product) {
		
		Optional<Medicine> optional=productRepository.findByStoreIdAndMedicineCode(product.getStoreId(), product.getMedicineCode());
		
		if(optional.isPresent())
		{
			Medicine medicine=optional.get();
			product.setMedicineId(medicine.getMedicineId());
			
			long totalstock=medicine.getTotalStock()+product.getStock().get(0).getQuantity();
			product.setTotalStock(totalstock);
			System.err.println("sss..."+product.getStock());
			product.setStock(product.getStock());
		}
		else
		{
			long totalstock=product.getStock().get(0).getQuantity();
			product.setTotalStock(totalstock);
		}
		return productRepository.save(product);
	}

	@Override
	public List<Medicine> fetchAllMedicines() {	
		return productRepository.findAll();
	}

	@Override
	public Medicine getMedicineById(Long id) {
		Optional<Medicine> product=productRepository.findById(id);
		if(product.isPresent())
		{
			return product.get();
		}
		return null;
	}

	@Override
	public Medicine updateMedicineById(Long id, Medicine product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteMedicineById(Long id) {
		 productRepository.deleteById(id);
	}

}
