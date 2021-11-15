package com.nvrs.merchant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nvrs.merchant.entity.Merchant;


public interface MerchantService {

	List<Merchant> getAllMerchants();

	Page<Merchant> getAllMerchantsByPage();

	void saveMerchant(Merchant body);

	Merchant getMerchantById(Long id);

}