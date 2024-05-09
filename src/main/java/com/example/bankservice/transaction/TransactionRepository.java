package com.example.bankservice.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByOriginatingAccountEntityIdOrResultingAccountEntityId(Long originatingAccountId, Long resultingAccountId);
}
