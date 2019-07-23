package com.hcl.service;

import com.hcl.dto.AccountRequestDTO;
import com.hcl.dto.AccountResponseDTO;
import com.hcl.entity.Account;

public interface AccountService {

	AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO);

}
