package com.nvrs.merchant.controller;

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
import com.nvrs.merchant.entity.Merchant;
import com.nvrs.merchant.service.MerchantService;

import java.util.List;

@RestController
public class MerchantController {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	
	@Autowired
	private MerchantService merchantService;

	@Autowired
	public MerchantController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@GetMapping(path = "/merchant/{merchantId}")
	public ResponseEntity<Merchant> getMerchantById(@PathVariable("merchantId") Long merchantId) {
		return new ResponseEntity<Merchant>(
			merchantService.getMerchantById(merchantId),
			HttpStatus.OK
		);
    }
	
	
	@GetMapping(path = "/merchant")
	public ResponseEntity<List<Merchant>> getAllMerchants() {
		return new ResponseEntity<List<Merchant>>(
				merchantService.getAllMerchants(),
				HttpStatus.OK
		);
    }
	
	@GetMapping(path = "/merchant/page/1")
	public ResponseEntity<Page<Merchant>> getAllMerchantsByPage() {
        return new ResponseEntity<Page<Merchant>>(
				merchantService.getAllMerchantsByPage(),
				HttpStatus.OK);
    }
	

	
	@PostMapping(path = "/merchant")
	public ResponseEntity<Void> addMerchant(@RequestBody Merchant body) {
		merchantService.saveMerchant(body);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
