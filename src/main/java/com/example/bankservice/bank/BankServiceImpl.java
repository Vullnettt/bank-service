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
        if (!isValidAmount(transactionFlatFeeAmount) || !isValidAmount(transactionPercentFeeValue)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value for transactionFlatFeeAmount or transactionPercentFeeValue");
        }

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

    private boolean isValidAmount(double amount) {
        // Convert the amount to string to check the decimal part
        String amountString = String.valueOf(amount);

        // Split the amount into integer and decimal parts
        String[] parts = amountString.split("\\.");

        // Check if the decimal part exists and has more than two digits
        if (parts.length > 1 && parts[1].length() > 2) {
            return false;
        }

        return true;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank not found with ID: " + bankId);
        }
    }

    @Override
    public double getBankTotalTransferAmount(Long bankId) {
        Optional<BankEntity> optionalBank = bankRepository.findById(bankId);
        if (optionalBank.isPresent()) {
            return optionalBank.get().getTotalTransferAmount();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank not found with ID: " + bankId);
        }
    }
}
