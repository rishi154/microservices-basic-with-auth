package com.nvrs.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nvrs.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
