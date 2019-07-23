package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Registration;

@Repository
public interface ManageRepository extends JpaRepository<Registration, Long>{
	@Query(value="select * from Registration r where r.user_Id=0",nativeQuery=true)
	List<Registration> findByUsersbyZero();

	Registration findByRegId(Long regId);

}
