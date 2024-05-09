package com.example.bankservice.account;

import com.example.bankservice.commons.BaseDto;
import com.example.bankservice.transaction.TransactionEntity;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class AccountDto extends BaseDto {

    @NotBlank
    private String name;

    private double balance;

    private Long bankId;

    private List<TransactionEntity> outgoingTransactionEntities = new ArrayList<>();

    private List<TransactionEntity> incomingTransactionEntities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public List<TransactionEntity> getOutgoingTransactions() {
        return outgoingTransactionEntities;
    }

    public void setOutgoingTransactions(List<TransactionEntity> outgoingTransactionEntities) {
        this.outgoingTransactionEntities = outgoingTransactionEntities;
    }

    public List<TransactionEntity> getIncomingTransactions() {
        return incomingTransactionEntities;
    }

    public void setIncomingTransactions(List<TransactionEntity> incomingTransactionEntities) {
        this.incomingTransactionEntities = incomingTransactionEntities;
    }
}
