package com.example.bankservice.bank;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banks")
@Tag(name = "Bank Service API")
public class BankController {


    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    @Operation(summary = "Create a Bank Account", description = "This API presenting name as String, transaction flat fee amount and transaction percent fee value with 2 decimals as double in query params" +
            " enables to be saved in h2 in-memory database a bank account.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "When bank is created successfully",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BankDto.class))}),
            @ApiResponse(responseCode = "400", description = "If amount have more than two decimal error 400 will display", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public BankEntity createBank(@RequestParam String name, @RequestParam double transactionFlatFeeAmount, @RequestParam double transactionPercentFeeValue) {
        return bankService.createBank(name, transactionFlatFeeAmount, transactionPercentFeeValue);
    }

    @GetMapping("/{bankId}/total-transaction-fee")
    @Operation(summary = "Get Total Transaction Fee Amount of Bank Account", description = "This API enables by presenting bank id as Long in path, will display sum of transaction fee")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "When total transaction fee amount of bank account is founded successfully status 200 is showed",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BankDto.class))}),
            @ApiResponse(responseCode = "404", description = "If total transaction fee amount of bank account is not found 404 will be display with that message: Bank not found with ID:", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public double getBankTotalTransactionFeeAmount(@PathVariable Long bankId) {
        return bankService.getBankTotalTransactionFeeAmount(bankId);
    }

    @GetMapping("/{bankId}/total-transfer-amount")
    @Operation(summary = "Get Total Transfer Amount of Bank Account", description = "This API enables by presenting bank id as Long in path, will display sum of transfer")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "When total transfer amount of bank account is founded successfully status 200 is showed",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BankDto.class))}),
            @ApiResponse(responseCode = "404", description = "If total transfer fee amount of bank account is not found 404 will be display with that message: Bank not found with ID:", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json"))})
    public double getBankTotalTransferAmount(@PathVariable Long bankId) {
        return bankService.getBankTotalTransferAmount(bankId);
    }
}