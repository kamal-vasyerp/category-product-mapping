package com.practise.categorymapping.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.categorymapping.dto.ResponceProductInfo;
import com.practise.categorymapping.model.Category;
import com.practise.categorymapping.model.Product;
import com.practise.categorymapping.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> viewAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public String newCategory(Category category) {
		if(categoryRepository.save(category) != null) {
			return "New Category Created";
		}else {
			throw new RuntimeException("Category was not saved in the database");
		}
	}

	@Override
	public String deleteCategory(int categoryId) {
		if(categoryRepository.existsById(categoryId) == true) {
			categoryRepository.deleteById(categoryId);
			return "Category Deleted";
		}else {
			throw new RuntimeException("Id was not available in the database.");
		}
	}

	@Override
	public List<ResponceProductInfo> viewAllProductsinCategory(int categoryId) {
		if(categoryRepository.existsById(categoryId)) {
			return categoryRepository.allProductsInCategory(categoryId);
		}
		else {
			throw new RuntimeException("Category Id was not available in the database.");
		}
	}

}
