package com.example.bankservice.banks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<BankEntity, UUID> {
}
