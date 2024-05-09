package com.example.bankservice.transaction;

import com.example.bankservice.bank.BankDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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
    public List<TransactionDto> getTransactionsForAccount(@PathVariable Long accountId){
        return transactionService.getTransactionsForAccount(accountId);
    }
}
