package com.example.banking_app.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private String accountNumber;

    @SuppressWarnings("unused")
    private String accountTitle;

    @SuppressWarnings("unused")
    private BigDecimal balance;

    public void setBalance(BigDecimal zero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBalance'");
    }

    public BigDecimal getBalance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
    }
}   
