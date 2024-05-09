package com.example.bankservice.account;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/banks/{bankId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@PathVariable Long bankId, @Valid @RequestBody AccountDto accountDto) {
        return accountService.createAccount(bankId, accountDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double getAccountBalance(@PathVariable Long id){
        return accountService.getAccountBalance(id);
    }
}
