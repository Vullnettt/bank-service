package com.example.bankservice.transaction;

import com.example.bankservice.account.AccountEntity;
import com.example.bankservice.commons.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class TransactionEntity extends BaseEntity {

    private double amount;

    @ManyToOne
    @JoinColumn(name = "originating_account_id")
    @JsonIgnore
    private AccountEntity originatingAccountEntity;

    @ManyToOne
    @JoinColumn(name = "resulting_account_id")
    @JsonIgnore
    private AccountEntity resultingAccountEntity;

    private String transactionReason;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AccountEntity getOriginatingAccountEntity() {
        return originatingAccountEntity;
    }

    public void setOriginatingAccountEntity(AccountEntity originatingAccountEntity) {
        this.originatingAccountEntity = originatingAccountEntity;
    }

    public AccountEntity getResultingAccountEntity() {
        return resultingAccountEntity;
    }

    public void setResultingAccountEntity(AccountEntity resultingAccountEntity) {
        this.resultingAccountEntity = resultingAccountEntity;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }
}
