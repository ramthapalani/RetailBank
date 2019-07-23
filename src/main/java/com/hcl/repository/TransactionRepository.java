package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Transaction> {

}
