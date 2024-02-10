package com.practise.categorymapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.categorymapping.dto.ResponceDto;
import com.practise.categorymapping.dto.ResponceProductInfo;
import com.practise.categorymapping.model.Category;
import com.practise.categorymapping.model.Product;
import com.practise.categorymapping.service.CategoryService;
import com.practise.categorymapping.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/category")
	public ResponceDto getallCategory(){
		List<Category> categories = categoryService.viewAllCategory();
		return new ResponceDto(200,"All the Available Categories",categories);
	}
	
	@PostMapping("/category")
	public ResponceDto newCategory(@RequestBody Category category) {
		String message = categoryService.newCategory(category);
		return new ResponceDto(200,message);
	}
	
	@DeleteMapping("/category/{categoryId}")
	public ResponceDto deleteCategory(@PathVariable("categoryId") int categoryId) {
		String message = categoryService.deleteCategory(categoryId);
		return new ResponceDto(200,message);
	}
	
	@GetMapping("/product")
	public ResponceDto getallProducts() {
		List<Product> products = productService.viewAllProducts();
		return new ResponceDto(200,"All the Available Products",products);
	}
	
	@GetMapping("/product/{productId}")
	public ResponceDto getProduct(@PathVariable("productId") int productId) {
		Product product = productService.viewProductInfo(productId);
		return new ResponceDto(200,"The requested Product Information",product);
	}
	
	@PostMapping("/product")
	public ResponceDto newProduct(@RequestBody Product product) {
		String message = productService.newProduct(product);
		return new ResponceDto(200,message);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponceDto deleteProduct(@PathVariable("productId") int productId) {
		String message = productService.deleteProduct(productId);
		return new ResponceDto(200,message);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponceDto getProductsincategory(@PathVariable("categoryId") int categoryId) {
		List<ResponceProductInfo> productList = categoryService.viewAllProductsinCategory(categoryId);
		return new ResponceDto(200,"List of all the Products in Category",productList);
	}
}
