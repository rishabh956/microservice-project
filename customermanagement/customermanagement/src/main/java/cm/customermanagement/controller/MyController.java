package cm.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import cm.customermanagement.entities.Customer;
import cm.customermanagement.exceptions.CustomerNotFound;
import cm.customermanagement.services.CustomerService;

@RestController
public class MyController {
	
	
	@Autowired
	CustomerService customerService ;
	
	public MyController(CustomerService customerServiceD)
	{
		this.customerService = customerServiceD ;
	}
	
	
	@GetMapping("/customer/getAllCustomer")
	List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/customer/add")
	ResponseEntity<Customer> addCustomer(@RequestBody String jsonData)
	{
		Customer cust = new Customer() ;
		try {
			
			ObjectMapper objMapper = new ObjectMapper() ;
			Customer custTemp = objMapper.readValue(jsonData, Customer.class);
//			cust.setFirstName(custTemp.getFirstName());
//			cust.setLastName(custTemp.getLastName());
//			cust.setPhoneNumber(custTemp.getPhoneNumber());
//			cust.setEmail(custTemp.getEmail());
//			cust.setDOB(custTemp.getDOB());
			cust = custTemp ;
			Customer savedCustomer = this.customerService.addCustomer(cust);
			return new ResponseEntity<>(savedCustomer,HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/customer/delete/{customerId}")
	ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customerId)
	{
		try {
			
			this.customerService.deleteCustomer(Long.parseLong(customerId));
			return new ResponseEntity<>(HttpStatus.OK) ;
		}
		catch(CustomerNotFound e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
