package com.example.bankservice.banks;

import com.example.bankservice.commons.BaseDto;

public class BankDto extends BaseDto {

    private String name;

    //accountList

    private Double totalTransactionFee;
    private Double totalTransactionAmount;
    private Double transactionFlatFee;
    private Double transactionPercentFee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalTransactionFee() {
        return totalTransactionFee;
    }

    public void setTotalTransactionFee(Double totalTransactionFee) {
        this.totalTransactionFee = totalTransactionFee;
    }

    public Double getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public void setTotalTransactionAmount(Double totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
    }

    public Double getTransactionFlatFee() {
        return transactionFlatFee;
    }

    public void setTransactionFlatFee(Double transactionFlatFee) {
        this.transactionFlatFee = transactionFlatFee;
    }

    public Double getTransactionPercentFee() {
        return transactionPercentFee;
    }

    public void setTransactionPercentFee(Double transactionPercentFee) {
        this.transactionPercentFee = transactionPercentFee;
    }
}
