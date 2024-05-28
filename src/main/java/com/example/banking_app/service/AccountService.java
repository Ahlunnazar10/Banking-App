package com.example.banking_app.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_app.entity.AccountEntity;
import com.example.banking_app.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountEntity addAccount(AccountEntity account) {
        account.setBalance(BigDecimal.ZERO);
        return accountRepository.save(account);
    }

    public Optional<AccountEntity> getAccountByNumber(String accountNumber) {
        return Optional.ofNullable(accountRepository.findByAccountNumber(accountNumber));
    }
}
