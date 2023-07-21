package com.endava.TicketManagement.Controller;

import com.endava.TicketManagement.Model.*;
import com.endava.TicketManagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;


    @GetMapping("/event/{resourceId}")
    public Optional<Event> getEvents(@PathVariable Long resourceId){
        return eventService.findEvent(resourceId);
    }

    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventService.findAll();
    }

    @GetMapping("/eventsByVenueIDAndEventType")
    public List<Event> getEventsByVenueIDAndEventType(
            @RequestParam("venueID") Integer venueID,
            @RequestParam("eventType") String eventType) {
        return eventService.findAllByVenueIDAndEventType(eventType, venueID);
    }

    @GetMapping("/eventsByVenueIDAndEventTypeDTO")
    public List<EventDTO> getEventsByVenueIDAndEventTypeDTORequiredResponseFormat(
            @RequestParam("venueID") Integer venueID,
            @RequestParam("eventType") String eventType) {
        List<EventDTO> returnedEventsDTO = eventService.getEventsByVenueIDAndEventTypeDTORequiredResponseFormat(venueID, eventType);
        return returnedEventsDTO;
    }

}

