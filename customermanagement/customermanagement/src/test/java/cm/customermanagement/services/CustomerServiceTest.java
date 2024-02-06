package cm.customermanagement.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cm.customermanagement.doa.CustomerServiceDoa;
import cm.customermanagement.entities.Customer;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@Mock
	CustomerServiceDoa customerServiceDoa ;
	
	
	CustomerServiceImpl customerServiceImpl ;
	
	@BeforeEach
	void setup()
	{
		this.customerServiceImpl = new CustomerServiceImpl(customerServiceDoa) ;
	}
	
	@Test
	void getAllCustomer()
	{
		Customer c1 = new Customer("ram","srivatstava","ram@email.com","75369",new Date(1998-01-14));
		Customer c2 = new Customer("shyam","srivastava","shyam@yahoo.com","456654",new Date(1995-8-8));
		
		List<Customer> expectedList = new ArrayList<>() ;
		
		expectedList.add(c1);
		expectedList.add(c2);
		
		when(this.customerServiceDoa.findAll()).thenReturn(expectedList);
		
		
		List<Customer> actualList = customerServiceImpl.getAllCustomer();
		
		assertThat(actualList).isEqualTo(expectedList);
	}
	
	
}
