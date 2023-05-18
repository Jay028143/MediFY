package com.medify.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Medicine;
import com.medify.entity.Store;
import com.medify.repository.MedicineRepository;
import com.medify.repository.StoreRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository productRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Medicine saveMedicine(Medicine product) {

		Optional<Medicine> optional = productRepository.findByStoreIdAndMedicineCode(product.getStoreId(),
				product.getMedicineCode());

		if (optional.isPresent()) {
			Medicine medicine = optional.get();
			product.setMedicineId(medicine.getMedicineId());

			long totalstock = medicine.getTotalStock() + product.getStock().get(0).getQuantity();
			product.setTotalStock(totalstock);
		    product.setAvailableStock(( product.getStock().get(0).getQuantity() + medicine.getAvailableStock()));
			product.setStock(product.getStock());
			product.getStock().get(0).setMedicine(product);

		} else {
			long totalstock = product.getStock().get(0).getQuantity();
			product.setTotalStock(totalstock);
			product.setAvailableStock(totalstock);
			product.getStock().get(0).setMedicine(product);

		}
		return productRepository.save(product);
	}

	@Override
	public List<Medicine> fetchAllMedicines() {
		return productRepository.findAll();
	}

	@Override
	public Medicine getMedicineById(Long id) {
		Optional<Medicine> product = productRepository.findById(id);
		if (product.isPresent()) {
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

	@Override
	public List<Medicine> fetchAllMedicinesByStoreId(Long storeId) {
		// TODO Auto-generated method stub
		return productRepository.findByStoreId(storeId);
	}

	@Override
	public List<Store> getMedicineAvailabilityAtStore(Long storeId, String medicineCode) {
		List<Store> stores = storeRepository.getAllStore(storeId);
		List<Long> storeIds = stores.stream().map(Store::getStoreId).collect(Collectors.toList());
		List<Long> availble = productRepository.findMedicineAvailabilityAtStore(storeIds, medicineCode);
		List<Store> availableStore = new ArrayList<>();
		for (Long id : availble) {

			for (Store store : stores) {
				if (id == store.getStoreId()) {
					availableStore.add(store);
				}
			}
		}

		return availableStore;
	}

}
