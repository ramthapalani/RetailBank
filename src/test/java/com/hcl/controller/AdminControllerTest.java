package com.hcl.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.dto.AdminResDTO;
import com.hcl.service.AdminService;

@RunWith(SpringRunner.class)

@WebMvcTest(value = AdminController.class)
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminService adminService;

	@Test
	public void login() throws Exception {
		AdminResDTO admin = new AdminResDTO();
		admin.setAdminMessage("retail");
		admin.setAdminUserID(555L);

		mockMvc.perform(post("/ingretail/login/retail/555").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(admin))).andExpect(status().isNotFound());
	}

	private byte[] asJsonString(AdminResDTO admin) {

		return null;
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
