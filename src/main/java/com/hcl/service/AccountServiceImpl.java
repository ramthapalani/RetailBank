package com.hcl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.AccountRequestDTO;
import com.hcl.dto.AccountResponseDTO;
import com.hcl.entity.Account;
import com.hcl.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService  {
@Autowired
AccountRepository accountRepository;
	@Override
	public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
	List<Account> account=	accountRepository.findByUserId(accountRequestDTO.getUserId());
	for (Account account2 : account) {
		
		if(account2.getAccountType().equals("savings")) {
			AccountResponseDTO accountResponseDTO=new AccountResponseDTO("savings account is already exist");
			return accountResponseDTO;
			
		}if(account2.getAccountType().equals("current")) {
			AccountResponseDTO accountResponseDTO=new AccountResponseDTO("current account is already exist");
			return accountResponseDTO;
			
		}
		else
		{
			account2.setAccountType(accountRequestDTO.getAccountType());
			accountRepository.save(account2);
			AccountResponseDTO accountResponseDTO=new AccountResponseDTO(" account created succefully");
			return accountResponseDTO;
			
		}
	}
	AccountResponseDTO accountResponseDTO=new AccountResponseDTO();
	return accountResponseDTO;
		
	}

}
