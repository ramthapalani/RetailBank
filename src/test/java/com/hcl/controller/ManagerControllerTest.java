package com.hcl.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.hcl.entity.Registration;
import com.hcl.service.ManageService;
@RunWith(SpringRunner.class)
@WebMvcTest(value = ManagerController.class)
public class ManagerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ManageService adminService;
    @Test
    public void approveUsers() throws Exception {
        Registration registration = new Registration();
        registration.setAccountType("savings");
        registration.setCity("Bangalore");
        registration.setContactNumber(9823);
        registration.setEmail("abc@gmail.com");
        registration.setFirstName("Anirudh");
        registration.setLastName("Chowdhury");
        registration.setPassword("admin");
        registration.setRegId(12);
        registration.setUserId(2345);
        
        mockMvc.perform(put("/ingretail/adminapprove/12").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(registration))).andExpect(status().isCreated());
        
        
        
        //Mockito.when(adminService.approveUsers(Mockito.anyLong())).thenReturn("Anything");
        /*
         * String URI = "/ingretail/adminapprove/12"; RequestBuilder requestBuilder =
         * MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON); MvcResult
         * result = mockMvc.perform(requestBuilder).andReturn(); String outputInJson =
         * result.getResponse().getContentAsString(); String inputInJson =
         * this.mapToJson(registration); assert.
         */
    }
    private byte[] asJsonString(Registration registration) {
        // TODO Auto-generated method stub
        return null;
    }
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
    
}
