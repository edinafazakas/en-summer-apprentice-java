package com.endava.TicketManagement.Controller;

import com.endava.TicketManagement.Model.Event;
import com.endava.TicketManagement.Model.Venue;
import com.endava.TicketManagement.Service.EventService;
import com.endava.TicketManagement.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private VenueService venueService;

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

    @PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event eventRequest){
        System.out.println(eventRequest);
        Long venueID = Long.valueOf(eventRequest.getVenue().getVenueID());
        Venue venue = venueService.findByID(Math.toIntExact(venueID));

        eventRequest.setVenue(venue);
        eventRequest.setEventID(8);
        return eventService.create(eventRequest);
    }

}

