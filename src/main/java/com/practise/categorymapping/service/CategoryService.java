package com.practise.categorymapping.service;

import java.util.List;

import com.practise.categorymapping.dto.ResponceProductInfo;
import com.practise.categorymapping.model.Category;

public interface CategoryService {

	public List<Category> viewAllCategory();
	public String newCategory(Category category);
	public String deleteCategory(int categoryId);
	public List<ResponceProductInfo> viewAllProductsinCategory(int categoryId);
}
