package com.practise.categorymapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	private String brand;
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
}
