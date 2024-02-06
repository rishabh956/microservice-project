package cm.customermanagement.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import cm.customermanagement.controller.MyController;
import cm.customermanagement.entities.Customer;
import cm.customermanagement.services.CustomerService;

@WebMvcTest(MyController.class)
public class MyControllerTest {
	
	@Autowired
	MockMvc mockMvc ;
	
	@MockBean
	CustomerService customerService ;
	
	MyController myController ;
	
	@Test
	void addCustomerTest() throws Exception
	{
		Customer cust = new Customer("shiv","srivastava","shiv@email.com","123321",new Date(2001-9-11));
		
		when(this.customerService.addCustomer(cust)).thenReturn(cust);
		
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.post("/customer/add")
		 * .contentType(MediaType.APPLICATION_JSON) .content(new
		 * ObjectMapper().writeValueAsString(cust)))
		 * .andExpect(MockMvcResultMatchers.status().isOk());
		 */
		
		mockMvc.perform(MockMvcRequestBuilders.post("/customer/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cust)))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	void getCustomer() throws Exception
	{
		Customer c1 = new Customer("shiv","srivastava","shiv@email.com","123321",new Date(2001-9-11));
		Customer c2 = new Customer("parwati","srivastava","parwati@email.com","12344321",new Date(2001-9-11));
		
		when(this.customerService.getAllCustomer()).thenReturn(new ArrayList<>(Arrays.asList(c1,c2)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/getAllCustomer"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		
		
		
	}
	
	
		
		
		
		
	

}
