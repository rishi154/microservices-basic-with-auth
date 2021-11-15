package com.nvrs.transaction.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nvrs.transaction.entity.Merchant;

@FeignClient(name="merchant-service")
public interface MerchantClient {
	
	@GetMapping(path = "/merchant/{merchantId}")	
	Optional<Merchant> getMerchantById(@PathVariable("merchantId") Long merchantId);
}
