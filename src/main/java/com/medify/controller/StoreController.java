package com.medify.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.Store;
import com.medify.service.StoreService;


@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getStore() {
        return storeService.fetchAllStores();
    }

    @GetMapping("/{storeId}")
    public Store getStore(@PathVariable Integer storeId) {
        return storeService.getStoreById(storeId);
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store savedStore = storeService.saveStore(store);
        return ResponseEntity.ok(savedStore);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Integer storeId, @RequestBody Store store) {
        Store currentStore = storeService.updateStoreById(null, store);
        return ResponseEntity.ok(currentStore);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Store> deleteStore(@PathVariable Integer storeId) {
        storeService.deleteStoreById(storeId);
        return ResponseEntity.ok().build();
    }

}
