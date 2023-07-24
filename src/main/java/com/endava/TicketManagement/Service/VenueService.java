package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.Venue;
import com.endava.TicketManagement.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

    public Venue findByID(Long venueID) {
        return venueRepository.findByVenueID(venueID);
    }

}
