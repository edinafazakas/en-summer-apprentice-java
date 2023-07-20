package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.TicketCategory;
import com.endava.TicketManagement.Repository.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketCategoryService {
    @Autowired
    TicketCategoryRepository ticketCategoryRepository;

    public TicketCategory findById(Long ticketCategoryID){
        return ticketCategoryRepository.findByTicketCategoryID(ticketCategoryID);
    }


}
