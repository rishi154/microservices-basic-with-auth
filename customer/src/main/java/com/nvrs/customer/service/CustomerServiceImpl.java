package com.nvrs.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.stream.Stream;

import com.nvrs.customer.entity.Customer;
import com.nvrs.customer.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Page<Customer> getAllCustomersByPage(int pageNo) {
		return customerRepo.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public void saveCustomer(Customer body) {
		customerRepo.save(body);
	}
	
	@Override
	public Customer getCustomerById(Long id){
		return customerRepo.findById(id).orElse(null);
	}

}
