package com.example.bankservice.bank;

// BankService.java
import com.example.bankservice.account.AccountEntity;
import com.example.bankservice.account.AccountRepository;
import com.example.bankservice.bank.utils.BankMapper;
import com.example.bankservice.transaction.Transaction;
import com.example.bankservice.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
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
    public Bank createBank(String name, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        Bank bank = new Bank();
        bank.setName(name);
        bank.setTransactionFlatFeeAmount(transactionFlatFeeAmount);
        bank.setTransactionPercentFeeValue(transactionPercentFeeValue);

        bank.setCreatedAt(LocalDateTime.now());
        bank.setCreatedBy(1L);
        bank.setUpdatedAt(LocalDateTime.now());
        bank.setUpdatedBy(1L);

        return bankRepository.save(bank);
    }

    @Override
    public BankDto findById(Long id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Bank with id: " + id + " is not found!"
                ));

        BankDto bankDto = new BankDto();

        bankMapper.mapEntityToDto(bank, bankDto);

        return bankDto;
    }

    @Override
    public double getBankTotalTransactionFeeAmount(Long bankId) {
        Optional<Bank> optionalBank = bankRepository.findById(bankId);
        if (optionalBank.isPresent()) {
            return optionalBank.get().getTotalTransactionFeeAmount();
        } else {
            throw new RuntimeException("Bank not found with ID: " + bankId);
        }
    }

    @Override
    public double getBankTotalTransferAmount(Long bankId) {
        Optional<Bank> optionalBank = bankRepository.findById(bankId);
        if (optionalBank.isPresent()) {
            return optionalBank.get().getTotalTransferAmount();
        } else {
            throw new RuntimeException("Bank not found with ID: " + bankId);
        }
    }
}
