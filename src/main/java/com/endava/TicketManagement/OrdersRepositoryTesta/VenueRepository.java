package com.endava.TicketManagement.OrdersRepositoryTesta;
import com.endava.TicketManagement.Model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    Venue findByVenueID(Integer venueID);
}
