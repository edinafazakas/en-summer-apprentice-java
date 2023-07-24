package com.endava.TicketManagement.OrdersRepositoryTesta;

import com.endava.TicketManagement.Model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByEventType_NameAndVenue_VenueID(String eventTypeName, Integer venue_venueID);
    Event findByEventID(Long eventID);

}
