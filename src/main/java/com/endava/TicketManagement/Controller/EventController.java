package com.endava.TicketManagement.Controller;

import com.endava.TicketManagement.Model.*;
import com.endava.TicketManagement.Service.EventService;
import com.endava.TicketManagement.Service.EventTypeService;
import com.endava.TicketManagement.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@CrossOrigin
@RestController
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private VenueService venueService;
    @Autowired
    protected EventTypeService eventTypeService;

    @GetMapping("/event/{resourceId}")
    public Optional<Event> getEvents(@PathVariable Long resourceId) {
        return eventService.findEvent(resourceId);
    }

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.findAll();
    }


    @GetMapping("/getEvents")
    public List<EventRequestDto> getEventsRequest() throws Exception {
        return eventService.getEvents();
    }

    @GetMapping("/eventsByVenueIDAndEventType")
    public List<Event> getEventsByVenueIDAndEventType(
            @RequestParam("venueID") Integer venueID,
            @RequestParam("eventType") String eventType) {
        return eventService.findAllByVenueIDAndEventType1(eventType, venueID);
    }

    @GetMapping("/eventsByVenueLocationAndEventType")
    public List<EventRequestDto> getEventsByVenueLocationAndEventType(
            @RequestParam("eventType") String eventType,
            @RequestParam("venue") String venue) {
        return eventService.findAllByVenueIDAndEventType2(eventType, venue);
    }

    @GetMapping("/eventsByVenueIDAndEventTypeDTO")
    public List<EventDTO> getEventsByVenueIDAndEventTypeDTORequiredResponseFormat(
            @RequestParam("venueID") Integer venueID,
            @RequestParam("eventType") String eventType) throws Exception {
        Venue venue = venueService.findByID(Long.valueOf(venueID));

        if (venue == null) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find id");
        }
        EventType eventTypeObj = eventTypeService.findByName(eventType);

        if (eventTypeObj == null) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find id");
        }
        return eventService.getEventsByVenueIDAndEventTypeDTORequiredResponseFormat(venueID, eventType);
    }

}

