package com.example.bankservice.transaction;

import java.util.List;

public interface TransactionService {

    TransactionDto performTransaction(Long originatingAccountId, Long resultingAccountId, double amount, String transactionReason);
    List<TransactionDto> getTransactionsForAccount(Long accountId);
}
