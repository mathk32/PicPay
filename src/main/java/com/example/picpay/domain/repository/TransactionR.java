package com.example.picpay.domain.repository;

import com.example.picpay.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionR extends JpaRepository<Transaction, Integer> {
}
