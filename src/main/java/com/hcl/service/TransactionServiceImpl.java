package com.hcl.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.repository.AccountRepository;
import com.hcl.dto.FundTransaferResponse;
import com.hcl.dto.TransactionReqDTO;
import com.hcl.entity.Account;
import com.hcl.entity.Transaction;
import com.hcl.exception.InvalidTransactionDataException;
import com.hcl.exception.MinimumBalanceException;
import com.hcl.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	public FundTransaferResponse fundTransfer(TransactionReqDTO transactionReqDTO) {
		
		if(transactionReqDTO.getFromAccount().compareTo(transactionReqDTO.getToAccount()) == 0) {
			throw new InvalidTransactionDataException("from Account and to Account cannot be same");
		}
		
		Long fromAccountId = transactionReqDTO.getFromAccount();
		Long toAccountId = transactionReqDTO.getToAccount();
		BigDecimal transferamount = transactionReqDTO.getTransferAmount();
		
		Account fromAccount = accountRepository.findByAccountNumber(fromAccountId);
		BigDecimal fromAmount = fromAccount.getBalance();
		
		if(fromAmount.compareTo(transferamount) < 0) {
			throw new MinimumBalanceException("Insufficient funds to intiate fund transfer");
		}
		
		fromAccount.setBalance(fromAmount.subtract(transferamount));
		accountRepository.save(fromAccount);
		
		
		Account toAccount = accountRepository.findByAccountNumber(toAccountId);
		

		BigDecimal toAmount = toAccount.getBalance();
		toAccount.setBalance(toAmount.add(transferamount));
		accountRepository.save(toAccount);
		
		Date date =  new Date();
		Transaction transaction = new Transaction();
		transaction.setDescription(transactionReqDTO.getDescription());
		transaction.setFromAccount(fromAccountId);
		transaction.setToAccount(toAccountId);
		transaction.setTransactionDate(date);
		transaction.setBalance(fromAccount.getBalance());
		transaction.setTransferAmount(transferamount);
		transactionRepository.save(transaction);
		
		FundTransaferResponse fundTransaferResponse =  new FundTransaferResponse();
		fundTransaferResponse.setSetMessage("transferred successfull  ");
		return fundTransaferResponse;
	}
	
	

}



