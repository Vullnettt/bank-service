package com.example.bankservice.bank;

public interface BankService {
    BankEntity createBank(String name, double transactionFlatFeeAmount, double transactionPercentFeeValue);
    double getBankTotalTransactionFeeAmount(Long bankId);
    double getBankTotalTransferAmount(Long bankId);

    BankDto findById(Long id);
}
