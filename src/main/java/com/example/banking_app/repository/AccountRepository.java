package com.example.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking_app.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByAccountNumber(String accountNumber);
}