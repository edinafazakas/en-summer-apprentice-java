package com.endava.TicketManagement.Service;
import com.endava.TicketManagement.Model.Event;
import com.endava.TicketManagement.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;


    public Event create(Event event){
        event.setEventID(10);
        return eventRepository.save(event);
    }

    public List<Event> findAll(){
        return (List<Event>) eventRepository.findAll();
    }

    public Optional<Event> findEvent(Long eventID) {
        return eventRepository.findById(eventID);
    }

    public List<Event> findAllByVenueIDAndEventType(String eventTypeName, Integer venueID){
        return eventRepository.findAllByEventType_NameAndVenue_VenueID(eventTypeName, venueID);
    }

    public Event findByEventID(Long eventID){
        return  eventRepository.findByEventID(eventID);
    }
}