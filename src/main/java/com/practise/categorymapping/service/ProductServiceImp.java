package com.practise.categorymapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.categorymapping.model.Product;
import com.practise.categorymapping.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> viewAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product viewProductInfo(int ProductId) {
		return productRepository.findById(ProductId).orElseThrow(() -> new EntityNotFoundException("Product was not in the DATABASE"));
	}

	@Override
	public String newProduct(Product product) {
		productRepository.save(product);
		return "Product saved";
	}

	@Override
	public String deleteProduct(int productId) {
		productRepository.deleteById(productId);
		return "Product Deleted";
	}

}
