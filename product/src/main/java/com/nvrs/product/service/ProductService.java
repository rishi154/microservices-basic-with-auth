package com.nvrs.product.service;

import org.springframework.data.domain.Page;

import com.nvrs.product.entity.Product;

import java.util.List;


public interface ProductService {

	List<Product> getAllProducts();

	Page<Product> getAllProductsByPage();

	void saveProduct(Product body);

	Product getProductById(Long productId);
}