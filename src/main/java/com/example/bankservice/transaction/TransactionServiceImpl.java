package com.example.bankservice.transaction;

import com.example.bankservice.account.AccountEntity;
import com.example.bankservice.account.AccountRepository;
import com.example.bankservice.bank.BankEntity;
import com.example.bankservice.bank.BankRepository;
import com.example.bankservice.transaction.mapper.TransactionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    private final AccountRepository accountRepository;
    private final BankRepository bankRepository;
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  TransactionMapper transactionMapper,
                                  AccountRepository accountRepository,
                                  BankRepository bankRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public TransactionDto performTransaction(Long originatingAccountId,
                                             Long resultingAccountId,
                                             double amount,
                                             String transactionReason) {
        if(originatingAccountId == resultingAccountId){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "You cannot send and accept transfers!");
        }
        if (!isValidAmount(amount)) {
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST,
                            "Amount cannot have more than two decimals.");
        }

        Optional<AccountEntity> optionalOriginatingAccount = accountRepository.findById(originatingAccountId);
        Optional<AccountEntity> optionalResultingAccount = accountRepository.findById(resultingAccountId);

        if (optionalOriginatingAccount.isPresent() && optionalResultingAccount.isPresent()) {
            AccountEntity originatingAccountEntity = optionalOriginatingAccount.get();
            AccountEntity resultingAccountEntity = optionalResultingAccount.get();
            double transactionFee = calculateTransactionFee(amount, originatingAccountEntity.getBank());

            if (originatingAccountEntity.getBalance() >= (amount + transactionFee)) {
                // Deduct amount from originating account
                originatingAccountEntity.setBalance(originatingAccountEntity.getBalance() - (amount + transactionFee));

                // Add amount to resulting account
                resultingAccountEntity.setBalance(resultingAccountEntity.getBalance() + amount);

                // Create transaction
                TransactionEntity transactionEntity = new TransactionEntity();
                transactionEntity.setAmount(amount);
                transactionEntity.setOriginatingAccountEntity(originatingAccountEntity);
                transactionEntity.setResultingAccountEntity(resultingAccountEntity);
                transactionEntity.setTransactionReason(transactionReason);

                transactionEntity.setCreatedAt(LocalDateTime.now());
                transactionEntity.setCreatedBy(1L);
                transactionEntity.setUpdatedAt(LocalDateTime.now());
                transactionEntity.setUpdatedBy(1L);

                transactionRepository.save(transactionEntity);

                // Update accounts
                accountRepository.save(originatingAccountEntity);
                accountRepository.save(resultingAccountEntity);

                // Update bank transaction details
                BankEntity bankEntity = originatingAccountEntity.getBank();
                bankEntity.setTotalTransactionFeeAmount(bankEntity.getTotalTransactionFeeAmount() + transactionFee);
                bankEntity.setTotalTransferAmount(bankEntity.getTotalTransferAmount() + amount);
                bankRepository.save(bankEntity);

                TransactionDto transactionDto = new TransactionDto();
                transactionMapper.mapEntityToDto(transactionEntity, transactionDto);

                return transactionDto;
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Not enough funds in originating account.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "One or both accounts not found.");
        }
    }

    private double calculateTransactionFee(double amount, BankEntity bankEntity) {
        double flatFee = bankEntity.getTransactionFlatFeeAmount();
        double percentFee = (amount * bankEntity.getTransactionPercentFeeValue()) / 100.0;
        return Math.max(flatFee, percentFee);
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
    public List<TransactionDto> getTransactionsForAccount(Long accountId) {
        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            List<TransactionEntity> transactionEntities = transactionRepository.findByOriginatingAccountEntityIdOrResultingAccountEntityId(accountId, accountId);
            List<TransactionDto> transactionDtos = new ArrayList<>();

            transactionEntities.forEach(transaction -> {
                TransactionDto transactionDto = new TransactionDto();
                transactionMapper.mapEntityToDto(transaction, transactionDto);
                transactionDtos.add(transactionDto);
            });

            return transactionDtos;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found with ID: " + accountId);
        }
    }
}
