package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.Venue;
import com.endava.TicketManagement.OrdersRepositoryTesta.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public Venue findByID(Integer venueID){
        return venueRepository.findByVenueID(venueID);
    }
}
