package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Product;
import com.medify.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> fetchAllProducts() {	
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent())
		{
			return product.get();
		}
		return null;
	}

	@Override
	public Product updateProductById(Integer id, Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		 productRepository.deleteById(id);
	}

}
