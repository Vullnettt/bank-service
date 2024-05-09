package com.example.bankservice.transaction;

import com.example.bankservice.account.AccountEntity;
import com.example.bankservice.commons.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction extends BaseEntity {

    private double amount;

    @ManyToOne
    @JoinColumn(name = "originating_account_id")
    @JsonIgnore
    private AccountEntity originatingAccount;

    @ManyToOne
    @JoinColumn(name = "resulting_account_id")
    @JsonIgnore
    private AccountEntity resultingAccount;

    private String transactionReason;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AccountEntity getOriginatingAccount() {
        return originatingAccount;
    }

    public void setOriginatingAccount(AccountEntity originatingAccountEntity) {
        this.originatingAccount = originatingAccountEntity;
    }

    public AccountEntity getResultingAccount() {
        return resultingAccount;
    }

    public void setResultingAccount(AccountEntity resultingAccountEntity) {
        this.resultingAccount = resultingAccountEntity;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }
}
