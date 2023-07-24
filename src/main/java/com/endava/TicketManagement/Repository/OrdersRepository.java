package com.endava.TicketManagement.Repository;

import com.endava.TicketManagement.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findByOrderID(Long orderID);

    List<Orders> findAllByCustomer_CustomerID(Long customerID);

}
