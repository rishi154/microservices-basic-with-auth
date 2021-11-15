package com.nvrs.transaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvrs.transaction.client.CustomerClient;
import com.nvrs.transaction.client.MerchantClient;
import com.nvrs.transaction.entity.Customer;
import com.nvrs.transaction.entity.Merchant;
import com.nvrs.transaction.entity.TranProduct;
import com.nvrs.transaction.entity.Transaction;
import com.nvrs.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	TransactionRepository tranRepo;
	
	@Autowired
	MerchantClient merchantClient;
	
	@Autowired
	CustomerClient customerClient;
	
	@Override
	public void createTransaction(Transaction body) throws Exception {
		
		if(!isValidMerchant(body.getMerchantId())) {			
			throw new Exception("Invalid Merchant");
		}
		
		if(!isValidCustomer(body.getCustomerId())) {
			throw new Exception("Invalid Customer");
		}
		
		Transaction xtn = new Transaction();
		xtn.setMerchantId(body.getMerchantId());
		xtn.setCustomerId(body.getCustomerId());
		
		List<TranProduct> prodInTran = new ArrayList<TranProduct>();
		TranProduct tp = null;
		for(int i=0;i<body.getProducts().size();i++) {
			TranProduct prodBean = body.getProducts().get(i);
			tp = new TranProduct();
			tp.setTransaction(xtn);
			tp.setDescription(prodBean.getDescription());
			tp.setQuantity(prodBean.getQuantity());
			tp.setPrice(prodBean.getPrice());
			prodInTran.add(tp);
		}
		xtn.setProducts(prodInTran);
		xtn.setStatus("SUCCESS");
		
		tranRepo.save(xtn);
	}

	@Override
	public Transaction getTransactionById(long tranId) {
		return tranRepo.findById(tranId).orElse(null);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return tranRepo.findAll();
	}

	private boolean isValidCustomer(Long customerId) {
		Optional<Customer> customer = customerClient.getCustomerById(customerId);		
		System.out.println(customer.isPresent());
		if(customer.isPresent()) {
			return true;
		}		
		return false;
	}

	private boolean isValidMerchant(Long merchantId) {		
		Optional<Merchant> merchant = merchantClient.getMerchantById(merchantId);		
		System.out.println(merchant.isPresent());
		if(merchant.isPresent()) {
			return true;
		}		
		return false;
	}

}
