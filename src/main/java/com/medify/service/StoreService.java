package com.medify.service;


import java.util.List;

import com.medify.entity.Store;

public interface StoreService {

	Store saveStore(Store store);
	
	List<Store> fetchAllStores();
	
	Store getStoreById(Integer id);
	
	Store updateStoreById(Integer id,Store store);
	
	void deleteStoreById(Integer id);
}
