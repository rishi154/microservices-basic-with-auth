package com.nvrs.transaction.service;

import com.nvrs.transaction.entity.Transaction;

import java.util.List;

public interface TransactionService {

	void createTransaction(Transaction body) throws Exception;

    Transaction getTransactionById(long tranId);

    List<Transaction> getAllTransactions();
}
