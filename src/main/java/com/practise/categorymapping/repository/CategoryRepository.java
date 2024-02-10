package com.practise.categorymapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practise.categorymapping.dto.ResponceProductInfo;
import com.practise.categorymapping.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query("SELECT new com.practise.categorymapping.dto.ResponceProductInfo( p.productId , p.productName) FROM Product p WHERE category.categoryId = :id")
	public List<ResponceProductInfo> allProductsInCategory(@Param("id") int id);
	
}
