package com.nvrs.transaction.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nvrs.transaction.entity.Customer;

@FeignClient(name="customer-service")
public interface CustomerClient {
	
	@GetMapping(path = "/customer/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") Long customerId) ;
}
