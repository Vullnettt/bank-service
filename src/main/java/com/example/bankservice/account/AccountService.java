package com.example.bankservice.account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(Long bankId, AccountDto accountDto);
    List<AccountDto> getAllAccounts();
    double getAccountBalance(Long id);
    AccountDto findById(Long id);
}
