package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.*;
import com.endava.TicketManagement.Repository.CustomerRepository;
import com.endava.TicketManagement.Repository.EventRepository;
import com.endava.TicketManagement.Repository.OrdersRepository;
import com.endava.TicketManagement.Repository.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class OrdersService {
    private static int orderID = 28;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private TicketCategoryRepository ticketCategoryRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public Orders create(Orders order) {
        return ordersRepository.save(order);
    }

    public List<Orders> findAllByCustomerID(Long customerID) {
        return ordersRepository.findAllByCustomer_CustomerID(customerID);
    }

    public Orders findByOrderID(Long orderID) {
        return ordersRepository.findByOrderID(orderID);
    }

    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    public List<OrderDTO> getOrdersDTORequiredResponseFormat() {
        Long customerID = 1L;

        Customer customer = customerRepository.findByCustomerID(Long.valueOf(customerID));

        if (customer == null) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find id");
        }
        List<Orders> ordersByCustomerID = findAllByCustomerID(customerID);
        List<OrderDTO> returnedOrdersDTO = new ArrayList<>();

        for (Orders orders : ordersByCustomerID) {
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
        orders.setOrderID(orderID++);

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

    public void deleteOrder(Long orderID) {
        Orders orderToDelete = ordersRepository.findByOrderID(orderID);

        if (orderToDelete == null) {
            throw new ResponseStatusException(NOT_FOUND, "Order not found");
        }

        ordersRepository.delete(orderToDelete);
    }

    public OrderDTOPatch updateOrder(Long id, OrderDTOPatch updatedOrder) {
        Orders existingOrder = ordersRepository.findByOrderID(id);

        if (existingOrder == null) {
            throw new ResponseStatusException(NOT_FOUND, "Order not found");
        }

        existingOrder.setNumberOfTickets(updatedOrder.getNumberOfTickets());
        TicketCategory ticketCategory = ticketCategoryRepository.findByTicketCategoryID((long) updatedOrder.getTicketCategoryID());

        int totalPrice = updatedOrder.getNumberOfTickets() * ticketCategory.getPrice();
        existingOrder.setTotalPrice(totalPrice);
        existingOrder.setTicketCategory(ticketCategory);
        ordersRepository.save(existingOrder);

        return updatedOrder;
    }
}
