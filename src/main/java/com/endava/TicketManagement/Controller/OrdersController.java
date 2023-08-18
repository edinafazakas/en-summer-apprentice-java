package com.endava.TicketManagement.Controller;

import com.endava.TicketManagement.Model.*;
import com.endava.TicketManagement.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders")
    public List<Orders> getAllOrdersByCustomerID() {
        Long customerID = 3L;
        return ordersService.findAllByCustomerID(customerID);
    }

    @GetMapping("/allOrders")
    public List<Orders> getAllOrders() {
        return ordersService.findAllOrders();
    }

    @GetMapping("/order/{resourceId}")
    public Orders getOrders(@PathVariable Long resourceId) {
        return ordersService.findByOrderID(resourceId);
    }

    @GetMapping("/ordersDTO")
    public List<OrderDTO> getOrdersDTORequiredResponseFormat() {
        return ordersService.getOrdersDTORequiredResponseFormat();
    }

    @PostMapping("/createOrder")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        orderDTO = ordersService.createOrder(orderDTO);
        return orderDTO;
    }

    @DeleteMapping("/deleteOrder/{resourceId}")
    public void deleteOrder(@PathVariable Long resourceId) {
        ordersService.deleteOrder(resourceId);
    }

    @PatchMapping("/updateOrder/{resourceId}")
    public OrderDTOPatch updateOrder(@PathVariable Long resourceId, @RequestBody OrderDTOPatch updatedOrder) {
        return ordersService.updateOrder(resourceId, updatedOrder);
    }
}
