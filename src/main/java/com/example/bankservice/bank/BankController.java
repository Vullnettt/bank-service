package com.example.bankservice.bank;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BankController {


    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/banks")
    public Bank createBank(@RequestParam String name, @RequestParam double transactionFlatFeeAmount, @RequestParam double transactionPercentFeeValue) {
        return bankService.createBank(name, transactionFlatFeeAmount, transactionPercentFeeValue);
    }

    @GetMapping("/banks/{bankId}/total-transaction-fee")
    public double getBankTotalTransactionFeeAmount(@PathVariable Long bankId) {
        return bankService.getBankTotalTransactionFeeAmount(bankId);
    }

    @GetMapping("/banks/{bankId}/total-transfer-amount")
    public double getBankTotalTransferAmount(@PathVariable Long bankId) {
        return bankService.getBankTotalTransferAmount(bankId);
    }
}