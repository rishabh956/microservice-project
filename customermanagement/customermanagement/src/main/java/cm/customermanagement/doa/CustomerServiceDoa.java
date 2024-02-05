package cm.customermanagement.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cm.customermanagement.entities.Customer;

@Repository
public interface CustomerServiceDoa extends JpaRepository<Customer,Long> {
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Customer s WHERE s.firstName=?1")
	boolean isCustomerExistByName(String firstName);
	

}
