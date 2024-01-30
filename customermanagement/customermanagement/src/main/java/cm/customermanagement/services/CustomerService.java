package cm.customermanagement.services;

import java.util.List;

import cm.customermanagement.entities.Customer;
import cm.customermanagement.exceptions.CustomerNotFound;

public interface CustomerService {
	
	public Customer addCustomer(Customer cust);
	public void deleteCustomer(Long id) throws CustomerNotFound;
	public List<Customer> getAllCustomer();

}
