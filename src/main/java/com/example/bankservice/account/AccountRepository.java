package com.example.bankservice.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByDeletedAtIsNull();

    Optional<AccountEntity> findByIdAndDeletedAtIsNull(Long id);
}
