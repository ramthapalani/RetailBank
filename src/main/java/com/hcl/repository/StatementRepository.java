package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Registration;
import com.hcl.entity.Transaction;

@Repository
public interface StatementRepository extends JpaRepository<Transaction, Long>  {

	List<Transaction> findAllByFromAccountOrToAccount(Long accountNumber, Long accountNumber2);

}
