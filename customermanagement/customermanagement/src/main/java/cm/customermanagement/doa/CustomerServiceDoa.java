package cm.customermanagement.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.customermanagement.entities.Customer;

@Repository
public interface CustomerServiceDoa extends JpaRepository<Customer,Long> {

}
