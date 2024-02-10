package com.practise.categorymapping.service;

import java.util.List;

import com.practise.categorymapping.model.Product;

public interface ProductService {

	public List<Product> viewAllProducts();
	public Product viewProductInfo(int productId);
	public String newProduct(Product product);
	public String deleteProduct(int productId);
	
}
