package com.example.banking_app.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_app.entity.AccountEntity;
import com.example.banking_app.entity.TransactionEntity;
import com.example.banking_app.entity.TransactionEntity.TransactionType;
import com.example.banking_app.repository.AccountRepository;
import com.example.banking_app.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public TransactionEntity deposit(String accountNumber, BigDecimal amount) {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    @Transactional
    public TransactionEntity withdraw(String accountNumber, BigDecimal amount) {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.WITHDRAWAL);
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
