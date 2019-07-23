package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
@Query(value="select * from account where user_id=?1 ",nativeQuery=true)
	List<Account> findByUserId(Long userId);
@Query(value="select * from Account where account_Number=?1",nativeQuery=true)
Account findByAccountNumber(Long fromAccountId);



}
