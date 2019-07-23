package com.hcl.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.dto.RegistrationRequestDTO;
import com.hcl.entity.Registration;
import com.hcl.repository.RegistrationRepository;
import com.hcl.service.RegistrationServiceImpl;

@RunWith(SpringRunner.class)
public class RegistrationServiceImplTest {

	@Mock
	RegistrationRepository registrationRepository;

	@InjectMocks
	RegistrationServiceImpl registrationServiceImpl;

	@Test
	public void testRegistrationService() {

		RegistrationRequestDTO registrationRequestDTOtest = new RegistrationRequestDTO();
		registrationRequestDTOtest.setAccountType("savings");
		registrationRequestDTOtest.setCity("chennai");
		registrationRequestDTOtest.setContactNumber(987654321);
		registrationRequestDTOtest.setEmail("abc@gmail.com");
		registrationRequestDTOtest.setFirstName("raj");
		registrationRequestDTOtest.setLastName("raj");
		registrationRequestDTOtest.setRegId(1111);
		Registration registration = new Registration();
		registration.setAccountType("savings");
		registration.setCity("chennai");
		registration.setContactNumber(987654321);
		registration.setEmail("abc@gmail.com");
		registration.setFirstName("raj");
		registration.setLastName("raj");
		registration.setRegId(1111);
		Mockito.when(registrationServiceImpl.registerCustomer(registrationRequestDTOtest)).thenReturn(registration);
		assertNotNull(registrationRequestDTOtest);
		assertThat(registrationRequestDTOtest.getCity()).isEqualTo(registration.getCity());

	}

}
