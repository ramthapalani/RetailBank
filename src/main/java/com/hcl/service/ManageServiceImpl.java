package com.hcl.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.dto.RegistrationDetailsResDTO;
import com.hcl.entity.Account;
import com.hcl.entity.Registration;
import com.hcl.exception.DataNotFoundException;
import com.hcl.repository.AccountRepository;
import com.hcl.repository.ManageRepository;
import com.hcl.util.RandomNumberGen;
@Service
public class ManageServiceImpl implements ManageService{
	private Logger logger = LoggerFactory.getLogger(ManageServiceImpl.class);

	@Autowired
	ManageRepository adminRepository;
	@Autowired
	AccountRepository accountRepository;
	

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public List<RegistrationDetailsResDTO> getRegistrationDetails() {
		List<RegistrationDetailsResDTO> registrationDetailsResDTO = new ArrayList<>();		
		logger.info("starts get registration details in service");
		List<Registration>  regList = adminRepository.findByUsersbyZero();
		logger.info("starts get registration details in service");
		for(Registration regrec:regList) {
			RegistrationDetailsResDTO regdto = new RegistrationDetailsResDTO();
			BeanUtils.copyProperties(regrec, regdto);
			registrationDetailsResDTO.add(regdto);
		}
		return registrationDetailsResDTO;
	}
	@Override
	public String approveUsers(Long regId) {
		Registration reg = adminRepository.findByRegId(regId);
		Account account = new Account();
		if(reg != null) {
		   reg.setPassword(RandomNumberGen.getPassWord(reg.getFirstName()));
		   reg.setUserId(RandomNumberGen.getUserIdNumber());
		}else {
			throw new DataNotFoundException("User not found to approve");
		}
		logger.info("starts approve registration details in service");
		adminRepository.save(reg);	
		logger.info("starts approve registration details in service");
		try{
			sendMail(reg.getUserId(),reg.getPassword(),reg.getFirstName());
			System.out.println("Email sent successfully...");
		}catch(Exception e){
			System.out.println(e);
		}
		adminRepository.save(reg);
		
		account.setUserId(reg.getUserId());
		account.setAccountNumber(RandomNumberGen.getAccountNumber());
		account.setAccountType(reg.getAccountType());
		account.setBalance(new BigDecimal(5000));
		
		accountRepository.save(account);
		
		return "User Approved Successfully";
	}
	
	public void sendMail(Long userId,String password,String name) throws Exception{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("srao79@gmail.com");
		message.setSubject("Credentioals");
		message.setText("Hi " + name + " , please use these credentionals : userID : " +userId+" password : "+password);
		emailSender.send(message);
	}

}
