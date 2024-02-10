package com.practise.categorymapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.categorymapping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
