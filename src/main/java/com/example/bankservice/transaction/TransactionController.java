package com.example.bankservice.transaction;

import com.example.bankservice.bank.BankDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transactions")
@Tag(name = "API Endpoints for Transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Send Transaction From a Bank Account to Another Bank Account", description = "This API presenting originatingAccountId and resultingAccountId as Long, amount as double transaction and transactionReason as String in query params" +
            " which enables to be saved in h2 in-memory database in transactions table.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "When transaction is created successfully",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TransactionDto.class))}),
            @ApiResponse(responseCode = "400", description = "If amount have more than two decimal error 400 will display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "If one or both accounts not found 404 will display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "If you try to send and accept transfers in same bank account and there are not enough funds in originating account error 409 will display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})

    public TransactionDto performTransaction(@RequestParam Long originatingAccountId,
                                             @RequestParam Long resultingAccountId,
                                             @RequestParam double amount,
                                             @RequestParam String transactionReason){
        return transactionService.performTransaction(originatingAccountId,
                resultingAccountId,
                amount,
                transactionReason);
    }

    @GetMapping("/{accountId}/accounts")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Transactions For Amount of Bank Account", description = "This API enables by presenting account id as Long in path, will display sum of transaction for an account")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "When transaction amount of bank account is founded successfully status 200 is showed",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BankDto.class))}),
            @ApiResponse(responseCode = "404", description = "If transaction amount of bank account is not found 404 will be display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public List<TransactionDto> getTransactionsForAccount(@PathVariable Long accountId){
        return transactionService.getTransactionsForAccount(accountId);
    }
}
