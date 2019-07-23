package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	Registration findByUserId(Long userId);
	Registration findByUserIdAndPassword(long userId, String password);
	
	
}
