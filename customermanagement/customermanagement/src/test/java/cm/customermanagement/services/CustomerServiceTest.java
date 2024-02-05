package cm.customermanagement.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cm.customermanagement.doa.CustomerServiceDoa;

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
		customerServiceImpl.getAllCustomer();
		verify(this.customerServiceDoa).findAll();
	}
	
	
}
