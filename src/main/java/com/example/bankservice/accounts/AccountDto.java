package com.example.bankservice.accounts;

import com.example.bankservice.commons.BaseDto;

public class AccountDto extends BaseDto {

    private String username;
    private Double account_balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }
}
