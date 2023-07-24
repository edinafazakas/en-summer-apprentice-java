package com.endava.TicketManagement.Repository;

import com.endava.TicketManagement.Model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Venue findByVenueID(Long venueID);
}
