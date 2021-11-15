package com.nvrs.merchant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nvrs.merchant.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
