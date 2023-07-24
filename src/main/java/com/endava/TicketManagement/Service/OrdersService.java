package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.Event;
import com.endava.TicketManagement.Model.OrderDTO;
import com.endava.TicketManagement.Model.Orders;
import com.endava.TicketManagement.Model.TicketCategory;
import com.endava.TicketManagement.OrdersRepositoryTesta.EventRepository;
import com.endava.TicketManagement.OrdersRepositoryTesta.OrdersRepository;
import com.endava.TicketManagement.OrdersRepositoryTesta.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private TicketCategoryRepository ticketCategoryRepository;
    @Autowired
    private EventRepository eventRepository;


    public Orders create(Orders order) {
        return ordersRepository.save(order);
    }

    public List<Orders> findAllByCustomerID(Long customerID){
        return ordersRepository.findAllByCustomer_CustomerID(customerID);
    }

    public Orders findByOrderID(Long orderID){
        return ordersRepository.findByOrderID(orderID);
    }

    public List<Orders> findAllOrders(){
        return ordersRepository.findAll();
    }

    public List<OrderDTO> getOrdersDTORequiredResponseFormat(){
        Long customerID = 1L;
        List<Orders> ordersByCustomerID = findAllByCustomerID(customerID);
        List<OrderDTO> returnedOrdersDTO = new ArrayList<>();

        for(Orders orders: ordersByCustomerID){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setEventID(Long.valueOf(orders.getTicketCategory().getEvent().getEventID()));
            orderDTO.setTimestamp(orders.getOrderedAt());
            orderDTO.setTicketCategoryID(Long.valueOf(orders.getTicketCategory().getTicketCategoryID()));
            orderDTO.setNumberOfTickets(orders.getNumberOfTickets());
            orderDTO.setTotalPrice(orders.getTotalPrice());
            returnedOrdersDTO.add(orderDTO);
        }
        return returnedOrdersDTO;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Orders orders = new Orders();
        orders.setOrderID(12);

        TicketCategory ticketCategory = ticketCategoryRepository.findByTicketCategoryID(orderDTO.getTicketCategoryID());
        Event event = eventRepository.findByEventID(orderDTO.getEventID());

        int totalPrice = orderDTO.getNumberOfTickets() * ticketCategory.getPrice();
        ticketCategory.setEvent(event);
        orders.setTotalPrice(totalPrice);
        orders.setTicketCategory(ticketCategory);
        orders.setNumberOfTickets(orderDTO.getNumberOfTickets());
        orders.setOrderedAt(java.sql.Date.valueOf(LocalDate.now()));
        create(orders);

        orderDTO.setTimestamp(java.sql.Date.valueOf(LocalDate.now()));
        orderDTO.setTotalPrice(totalPrice);
        return orderDTO;
    }
}
