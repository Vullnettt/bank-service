package com.example.bankservice.bank;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByIdAndDeletedAtIsNotNull(Long id);
}
