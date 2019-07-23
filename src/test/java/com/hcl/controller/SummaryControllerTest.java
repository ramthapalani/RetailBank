package com.hcl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.dto.RegistrationDTO;
import com.hcl.service.SummaryServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value=SummaryController.class)
public class SummaryControllerTest {
	

	@Autowired 
	MockMvc mockMvc;
	
	@MockBean
	SummaryServiceImpl summaryServiceImpl;
	
	@Test
	public void accountSummaryTest() throws Exception{
		RegistrationDTO registrationDTO = new RegistrationDTO();
		registrationDTO.setUserId(1L);
		Mockito.when(summaryServiceImpl.accountSummaryDetails(1L)).thenReturn(registrationDTO);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/ingretail/summary/{userId}", 1L)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapToJson(registrationDTO)))
				.andExpect(MockMvcResultMatchers.status().isOk());
			}
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
}
