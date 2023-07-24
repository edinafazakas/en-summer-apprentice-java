package com.endava.TicketManagement.Repository;

import com.endava.TicketManagement.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerID(Long customerID);
}
