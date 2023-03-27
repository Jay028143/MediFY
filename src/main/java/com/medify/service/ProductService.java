package com.medify.service;


import java.util.List;

import com.medify.entity.Product;

public interface ProductService {

	Product saveProduct(Product product);
	
	List<Product> fetchAllProducts();
	
	Product getProductById(Integer id);
	
	Product updateProductById(Integer id,Product product);
	
	void deleteProductById(Integer id);
}
