package com.example.bankservice.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByOriginatingAccount_IdOrResultingAccount_Id(Long originatingAccountId, Long resultingAccountId);
}
