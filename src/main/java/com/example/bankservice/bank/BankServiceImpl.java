package com.example.bankservice.bank;

// BankService.java
import com.example.bankservice.bank.utils.BankMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    public BankServiceImpl(BankRepository bankRepository,
                           BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }

    @Override
    @Transactional
    public BankEntity createBank(String name, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setName(name);
        bankEntity.setTransactionFlatFeeAmount(transactionFlatFeeAmount);
        bankEntity.setTransactionPercentFeeValue(transactionPercentFeeValue);

        bankEntity.setCreatedAt(LocalDateTime.now());
        bankEntity.setCreatedBy(1L);
        bankEntity.setUpdatedAt(LocalDateTime.now());
        bankEntity.setUpdatedBy(1L);

        return bankRepository.save(bankEntity);
    }

    @Override
    public BankDto findById(Long id) {
        BankEntity bankEntity = bankRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Bank with id: " + id + " is not found!"
                ));

        BankDto bankDto = new BankDto();

        bankMapper.mapEntityToDto(bankEntity, bankDto);

        return bankDto;
    }

    @Override
    public double getBankTotalTransactionFeeAmount(Long bankId) {
        Optional<BankEntity> optionalBank = bankRepository.findById(bankId);
        if (optionalBank.isPresent()) {
            return optionalBank.get().getTotalTransactionFeeAmount();
        } else {
            throw new RuntimeException("Bank not found with ID: " + bankId);
        }
    }

    @Override
    public double getBankTotalTransferAmount(Long bankId) {
        Optional<BankEntity> optionalBank = bankRepository.findById(bankId);
        if (optionalBank.isPresent()) {
            return optionalBank.get().getTotalTransferAmount();
        } else {
            throw new RuntimeException("Bank not found with ID: " + bankId);
        }
    }
}
