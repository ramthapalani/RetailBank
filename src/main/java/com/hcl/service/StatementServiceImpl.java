package com.hcl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.StatementResDto;
import com.hcl.entity.Transaction;
import com.hcl.repository.StatementRepository;

@Service
public class StatementServiceImpl implements StatementService {
	

	@Autowired
	StatementRepository statementRepository;

	@Override
	public List<StatementResDto> getTransactionHistory(Long accountNumber) {
		List<Transaction> transactions = statementRepository.findAllByFromAccountOrToAccount(accountNumber, accountNumber);
		List<StatementResDto> statementsDtos = new ArrayList<>(); 
		
		for(Transaction transaction : transactions) {
			StatementResDto statementsDto = new StatementResDto();
			statementsDto.setTransactiondate(transaction.getTransactionDate());
			statementsDto.setTransactionAmount(transaction.getTransferAmount());
			statementsDto.setDescription(transaction.getDescription());
			statementsDto.setFromAccount(transaction.getFromAccount());
			statementsDto.setToAccount(transaction.getToAccount());
			statementsDto.setBalance(transaction.getBalance());
			
			if(transaction.getFromAccount().longValue() == accountNumber) {
				statementsDto.setTransactionType("Dr");
				
			}
			else if(transaction.getToAccount().longValue() == accountNumber) {
				statementsDto.setTransactionType("Cr");
				
			}
			statementsDtos.add(statementsDto);
		}
		
		return statementsDtos;		
	
	}

}
