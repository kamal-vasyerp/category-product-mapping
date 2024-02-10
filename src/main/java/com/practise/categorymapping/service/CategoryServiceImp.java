package com.practise.categorymapping.service;

import java.util.List;

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
		categoryRepository.save(category);
		return "New Category Created";
	}

	@Override
	public String deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		return "Category Deleted";
	}

	@Override
	public List<ResponceProductInfo> viewAllProductsinCategory(int categoryId) {
		return categoryRepository.allProductsInCategory(categoryId);
	}

}
