package com.example.banking_app.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.banking_app.entity.AccountEntity;
import com.example.banking_app.entity.TransactionEntity;
import com.example.banking_app.service.AccountService;
import com.example.banking_app.service.TransactionService;

public class BankController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/accounts")
    public AccountEntity createAccount(@RequestBody AccountEntity account) {
        return accountService.addAccount(account);
    }

    @GetMapping("/accounts/{accountNumber}")
    public Optional<AccountEntity> getAccount(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    @PostMapping("/transactions/deposit")
    public TransactionEntity deposit(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
        return transactionService.deposit(accountNumber, amount);
    }

    @PostMapping("/transactions/withdraw")
    public TransactionEntity withdraw(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
        return transactionService.withdraw(accountNumber, amount);
    }
}
