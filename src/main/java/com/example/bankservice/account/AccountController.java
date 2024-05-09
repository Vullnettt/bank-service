package com.example.bankservice.account;

import com.example.bankservice.bank.BankDto;
import com.example.bankservice.transaction.TransactionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accounts")
@Tag(name = "API Endpoints for Accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/banks/{bankId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a Account", description = "This API by presenting bank id as Long in path, name as String and balance with 2 decimals as double in request body" +
            " enables to be saved in h2 in-memory database a account in accounts table.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "When account is created successfully",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AccountDto.class))}),
            @ApiResponse(responseCode = "400", description = "If amount have more than two decimal error 400 will display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public AccountDto createAccount(@PathVariable Long bankId, @Valid @RequestBody AccountDto accountDto) {
        return accountService.createAccount(bankId, accountDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Accounts as List", description = "This API enables to get all accounts which are not disabled as list")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "When accounts are founded successfully status 200 is showed",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BankDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Enabled Account by ID", description = "This API enables by presenting account id as Long in path, will display account details")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "When valid account id is give will be founded successfully account details nad status 200 will be showed showed",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BankDto.class))}),
            @ApiResponse(responseCode = "404", description = "If accounts is not found 404 will be display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public double getAccountBalance(@PathVariable Long id){
        return accountService.getAccountBalance(id);
    }
}
