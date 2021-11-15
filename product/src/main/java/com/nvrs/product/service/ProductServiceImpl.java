package com.nvrs.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nvrs.product.entity.Product;
import com.nvrs.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Override
	public Page<Product> getAllProductsByPage() {
		return productRepo.findAll(PageRequest.of(0, 5));
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public void saveProduct(Product body) {
		productRepo.save(body);
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}

}
