package com.hcl.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.entity.Registration;
import com.hcl.repository.ManageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManageServiceImplTest {

    @InjectMocks
    private ManageServiceImpl managerServiceImp;

    @Mock
    private ManageRepository adminRepository;

    @Test
    public void approveUsers() throws Exception {
        
        Registration admin = new Registration();
        admin.setAccountType("savings");
        admin.setCity("Bangalore");
        admin.setContactNumber(9244);
        admin.setEmail("abc@gmail");
        admin.setFirstName("Anirudh");
        admin.setLastName("Chowdhury");
        admin.setPassword("admin");
        admin.setRegId(6L);
        admin.setUserId(1);
        Mockito.when(adminRepository.findByRegId(6L)).thenReturn(admin);
        String result = managerServiceImp.approveUsers(6L);
        Assert.assertEquals("User Approved Successfully",result);
    }
}