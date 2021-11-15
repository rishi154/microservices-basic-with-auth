package com.nvrs.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvrs.product.entity.Product;
import com.nvrs.product.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	
	@Autowired
	private ProductService productService;

	@Autowired
	public ProductController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@GetMapping(path = "/product/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
		return new ResponseEntity<Product>(
				productService.getProductById(productId),
				HttpStatus.OK
		);
    }
	
	
	@GetMapping(path = "/product")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(
			productService.getAllProducts(),
			HttpStatus.OK
		);
    }
	
	@GetMapping(path = "/product/page/1")
	public ResponseEntity<Page<Product>> getAllProductsByPage() {
        return new ResponseEntity<Page<Product>>(
			productService.getAllProductsByPage(),
			HttpStatus.OK
		);
    }
	

	
	@PostMapping(path = "/product")
	public ResponseEntity<Void> addCustomer(@RequestBody Product body) {
		productService.saveProduct(body);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
