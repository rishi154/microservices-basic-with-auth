package com.nvrs.merchant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nvrs.merchant.entity.Merchant;
import com.nvrs.merchant.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantRepository merchantRepo;

	@Override
	public Page<Merchant> getAllMerchantsByPage() {
		return merchantRepo.findAll(PageRequest.of(0, 5));
	}

	@Override
	public List<Merchant> getAllMerchants() {
		return merchantRepo.findAll();
	}

	@Override
	public void saveMerchant(Merchant body) {
		merchantRepo.save(body);
	}
	
	@Override
	public Merchant getMerchantById(Long id){
		return merchantRepo.findById(id).orElse(null);
	}

}
