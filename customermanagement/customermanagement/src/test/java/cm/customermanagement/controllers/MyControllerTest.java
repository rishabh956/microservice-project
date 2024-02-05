package cm.customermanagement.controllers;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cm.customermanagement.controller.MyController;
import cm.customermanagement.entities.Customer;
import cm.customermanagement.services.CustomerService;

@WebMvcTest(MyController.class)
public class MyControllerTest {
	
	@MockBean
	CustomerService customerService ;
	@Autowired
	MockMvc  mockMvc ;
	
	@Test
	void addCustomer()
	{
		Customer cust = new Customer("Bharat","Srivastava","bharat@gmail.com","741258",new Date(1997-12-4));
		when(customerService.addCustomer(cust)).thenReturn(cust);
		mockMvc.perform(post("/customer/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cust)))
				.andExpect(status().isOk());
	}

}
