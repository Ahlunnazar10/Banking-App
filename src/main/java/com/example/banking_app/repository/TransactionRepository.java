package com.example.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking_app.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    TransactionEntity findByTransactionNumber(String transactionNumber);
}