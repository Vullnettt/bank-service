package com.example.bankservice.accounts;

import com.example.bankservice.commons.BaseDto;

public class AccountDto extends BaseDto {

    private String username;
    private Double accountBalance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
