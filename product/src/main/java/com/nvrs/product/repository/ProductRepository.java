package com.nvrs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nvrs.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
