package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.Orders;
import com.endava.TicketManagement.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;


    public Orders create(Orders order) {
        return ordersRepository.save(order);
    }

    public List<Orders> findAllByCustomerID(Long customerID){
        return ordersRepository.findAllByCustomer_CustomerID(customerID);
    }
}
