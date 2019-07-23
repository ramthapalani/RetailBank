package com.hcl.service;

import com.hcl.dto.FundTransaferResponse;
import com.hcl.dto.TransactionReqDTO;


public interface TransactionService {
	 FundTransaferResponse fundTransfer(TransactionReqDTO transactionReqDTO);

}
