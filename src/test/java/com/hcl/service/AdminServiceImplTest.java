package com.hcl.service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.entity.Admin;
import com.hcl.repository.AdminRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {

	@InjectMocks
	private AdminService adminService;

	@Mock
	private AdminRepository adminRepository;

	@Test
	public void login() {
		Admin myticket = new Admin();
		myticket.setUserId(1L);
		myticket.setPassword("abc");
		when(adminRepository.findById(1L)).toString();
		Assert.assertEquals(myticket, adminService.getClass());
	}

}