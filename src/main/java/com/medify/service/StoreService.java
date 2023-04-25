package com.medify.service;


import java.util.List;

import com.medify.entity.Store;

public interface StoreService {

	Store saveStore(Store store);
	
	List<Store> fetchAllStores();
	
	List<Store> fetchAllStoresByAdminId(Long id);
	
	Store getStoreById(Long id);
	
	Store updateStoreById(Long id,Store store);
	
	void deleteStoreById(Long id);
}
