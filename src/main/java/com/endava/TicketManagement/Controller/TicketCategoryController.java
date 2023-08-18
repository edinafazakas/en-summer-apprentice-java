package com.endava.TicketManagement.Controller;

import com.endava.TicketManagement.Model.TicketCategory;
import com.endava.TicketManagement.Repository.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TicketCategoryController {
    @Autowired
    TicketCategoryRepository ticketCategoryRepository;

    @GetMapping("/ticketCategories")
    public List<TicketCategory> getTicketCategories() {
        return ticketCategoryRepository.findAll();
    }
}

