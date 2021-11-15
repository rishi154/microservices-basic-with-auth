package com.nvrs.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nvrs.transaction.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
