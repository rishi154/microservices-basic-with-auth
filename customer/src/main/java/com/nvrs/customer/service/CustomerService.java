package com.nvrs.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nvrs.customer.entity.Customer;


public interface CustomerService {

	List<Customer> getAllCustomers();

	Page<Customer> getAllCustomersByPage(int pageNo);

	void saveCustomer(Customer body);

	Customer getCustomerById(Long id);

}