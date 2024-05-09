package com.example.bankservice.account;

import com.example.bankservice.bank.BankEntity;
import com.example.bankservice.commons.BaseEntity;
import com.example.bankservice.transaction.TransactionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class AccountEntity extends BaseEntity {

    private String name;
    private double balance;

    @ManyToOne
    @JsonIgnore
    private BankEntity bankEntity;

    @OneToMany(mappedBy = "originatingAccountEntity", cascade = CascadeType.ALL)
    private List<TransactionEntity> outgoingTransactionEntities = new ArrayList<>();

    @OneToMany(mappedBy = "resultingAccountEntity", cascade = CascadeType.ALL)
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

    public BankEntity getBank() {
        return bankEntity;
    }

    public void setBank(BankEntity bankEntity) {
        this.bankEntity = bankEntity;
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