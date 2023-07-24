package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.TicketCategory;
import com.endava.TicketManagement.OrdersRepositoryTesta.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryService {
    @Autowired
    TicketCategoryRepository ticketCategoryRepository;

    public TicketCategory findById(Long ticketCategoryID){
        return ticketCategoryRepository.findByTicketCategoryID(ticketCategoryID);
    }

    public List<TicketCategory> FindAllByEventID(Long eventID){
        return ticketCategoryRepository.findAllByEvent_EventID(eventID);
    }


}
