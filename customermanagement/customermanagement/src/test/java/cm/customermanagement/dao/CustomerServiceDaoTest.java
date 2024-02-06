package cm.customermanagement.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cm.customermanagement.doa.CustomerServiceDoa;
import cm.customermanagement.entities.Customer;

@SpringBootTest
public class CustomerServiceDaoTest {
	
	@Autowired
	CustomerServiceDoa customerServiceDoa ;
	
	@Test
	void isCustomerExistByName()
	{
		Customer cust = new Customer("anumeha","singh","anumeha@gmail.com","7845",new Date(2011-11-7));
		customerServiceDoa.save(cust);
		
		Boolean actualResult = customerServiceDoa.isCustomerExistByName("anumeha");
		
		assertThat(actualResult).isTrue();
	}
	
	@Test
	void isCustomerExistByNameFalse()
	{
		Customer cust = new Customer("anumeha","singh","anumeha@gmail.com","7845",new Date(2011-11-7));
		customerServiceDoa.save(cust);
		
		Boolean actualResult = customerServiceDoa.isCustomerExistByName("ritik");
		
		assertThat(actualResult).isFalse();
	}
	
	
	
	
	

}
