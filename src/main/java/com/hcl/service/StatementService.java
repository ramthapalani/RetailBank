package com.hcl.service;

import java.util.List;

import com.hcl.dto.StatementResDto;

public interface StatementService {

	List<StatementResDto> getTransactionHistory(Long accountNumber);

}
