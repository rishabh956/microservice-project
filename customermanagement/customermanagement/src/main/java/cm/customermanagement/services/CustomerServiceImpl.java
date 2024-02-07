package cm.customermanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.customermanagement.doa.CustomerServiceDoa;
import cm.customermanagement.entities.Customer;
import cm.customermanagement.exceptions.CustomerExistException;
import cm.customermanagement.exceptions.CustomerNotFound;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerServiceDoa customerServiceDoa ;
	
	CustomerServiceImpl(CustomerServiceDoa customerRepo)
	{
		this.customerServiceDoa = customerRepo ;
	}
	
	@Override
	public Customer addCustomer(Customer cust) throws CustomerExistException {
		// TODO Auto-generated method stub
		if(!customerServiceDoa.isCustomerExistByName(cust.getFirstName()))
		return customerServiceDoa.save(cust);
		else
			throw new CustomerExistException("Customer is already exist") ;
		
	}

	@Override
	public void deleteCustomer(Long id) throws CustomerNotFound {
		// TODO Auto-generated method stub
		
		Optional<Customer>  c = this.customerServiceDoa.findById(id);
		System.out.println("::::customer data:::::"+c);
		if(c.isPresent()) 
		customerServiceDoa.delete(c.get());
		else
			throw new CustomerNotFound("customer ID not found") ;

	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = customerServiceDoa.findAll().stream().sorted((a,b)->a.getFirstName().compareTo(b.getFirstName())).collect(Collectors.toList());
		return list ;
	}

}
