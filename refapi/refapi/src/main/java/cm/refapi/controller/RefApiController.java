package cm.refapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cm.refapi.entities.Customer;


@RestController
@RequestMapping("/refapi")
public class RefApiController {

	@Autowired
	RestTemplate restTemplate ;
	
	@GetMapping("/customer/getAllCustomer")
	List<Customer> getAllCustomer()
	{
		List<Customer> list = this.restTemplate.getForObject("http://customer-management/customer/getAllCustomer", List.class);
		return list ;
	}
	
	@DeleteMapping("/customer/delete/{customerId}")
	void deleteCustomer(@PathVariable String customerId)
	{
		  this.restTemplate.delete("http://customer-management/customer/delete/"+customerId);
	}
	
	@PostMapping("/customer/add")
	Customer addCustomer(@RequestBody String jsonData)
	{	
		Customer cust = this.restTemplate.postForObject("http://customer-management/customer/add", jsonData, Customer.class);
		return cust ;	
	}
	
	
}
