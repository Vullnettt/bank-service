package com.example.bankservice.transactions;

import com.example.bankservice.commons.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionEntity extends BaseEntity {

    private String amount;
    private String originatingAccountId;
    private String resultingAccountId;
    private String transactionReason;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOriginatingAccountId() {
        return originatingAccountId;
    }

    public void setOriginatingAccountId(String originatingAccountId) {
        this.originatingAccountId = originatingAccountId;
    }

    public String getResultingAccountId() {
        return resultingAccountId;
    }

    public void setResultingAccountId(String resultingAccountId) {
        this.resultingAccountId = resultingAccountId;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }
}
