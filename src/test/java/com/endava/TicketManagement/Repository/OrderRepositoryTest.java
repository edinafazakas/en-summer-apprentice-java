package com.endava.TicketManagement.Repository;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrdersRepository ordersRepository;
    /*@Autowired
    private OrdersService ordersService;*/

    /*@Test
    public void findAll(){
        List<Orders> orders = ordersRepository.findAll();
        //List<Orders> ordersList = ordersService.findAllOrders();

        //System.out.println(orders.size());
        assertEquals(11, orders.size());
    }*/
}
