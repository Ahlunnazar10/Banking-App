package com.example.banking_app.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @SuppressWarnings("unused")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @SuppressWarnings("unused")
    private LocalDateTime transactionDate;

    public void setBalance(BigDecimal zero) {
        throw new UnsupportedOperationException("Unimplemented method 'setBalance'");
    }
    
    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }

    public void setAccount(AccountEntity account2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAccount'");
    }

    public void setAmount(BigDecimal amount2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
    }

    public void setTransactionType(TransactionType deposit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTransactionType'");
    }

    public void setTransactionDate(LocalDateTime now) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTransactionDate'");
    }
}

