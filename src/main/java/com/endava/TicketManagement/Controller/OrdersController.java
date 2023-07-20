package com.endava.TicketManagement.Controller;

import com.endava.TicketManagement.Model.*;
import com.endava.TicketManagement.Service.EventService;
import com.endava.TicketManagement.Service.OrdersService;
import com.endava.TicketManagement.Service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    TicketCategoryService ticketCategoryService;
    @Autowired
    EventService eventService;

    @GetMapping("/orders")
    public List<Orders> getAllOrdersByCustomerID(){
        Long customerID = 3L;
        return ordersService.findAllByCustomerID(customerID);
    }

    @PostMapping("/createOrder")
    public Orders createEvent(@RequestBody OrderDTO orderDTO) {
        Orders orders = new Orders();
        orders.setOrderID(9);

        TicketCategory ticketCategory = ticketCategoryService.findById(orderDTO.getTicketCategoryID());
        Event event = eventService.findByEventID(orderDTO.getEventID());
        int totalPrice = orderDTO.getNumberOfTickets() * ticketCategory.getPrice();
        ticketCategory.setEvent(event);
        orders.setTotalPrice(totalPrice);
        orders.setTicketCategory(ticketCategory);
        orders.setNumberOfTickets(orderDTO.getNumberOfTickets());
        orders.setOrderedAt(java.sql.Date.valueOf(LocalDate.now()));
        return ordersService.create(orders);
    }
}
