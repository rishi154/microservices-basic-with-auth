package com.nvrs.transaction.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvrs.transaction.entity.Transaction;
import com.nvrs.transaction.service.TransactionService;

import java.util.List;

@RestController
public class TransactionController {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	public TransactionController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@PostMapping(path = "/transaction")
	public ResponseEntity<Void> createTransaction(@RequestBody Transaction body) {
		System.out.println(body.toString());
		try {
			transactionService.createTransaction(body);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/transaction/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long tranId){
		return new ResponseEntity<Transaction>(
				transactionService.getTransactionById(tranId),
				HttpStatus.OK
		);
	}

	@GetMapping(path = "/transaction")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		return new ResponseEntity<List<Transaction>>(
				transactionService.getAllTransactions(),
				HttpStatus.OK
		);
	}

}
