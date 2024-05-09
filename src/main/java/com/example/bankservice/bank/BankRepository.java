package com.example.bankservice.bank;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findByIdAndDeletedAtIsNotNull(Long id);
}
