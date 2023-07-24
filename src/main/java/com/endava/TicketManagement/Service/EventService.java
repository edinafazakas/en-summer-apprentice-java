package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.*;
import com.endava.TicketManagement.Repository.EventRepository;
import com.endava.TicketManagement.Repository.EventTypeRepository;
import com.endava.TicketManagement.Repository.TicketCategoryRepository;
import com.endava.TicketManagement.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketCategoryRepository ticketCategoryRepository;
    @Autowired
    private VenueRepository venueRepository;
    @Autowired
    private EventTypeRepository eventTypeRepository;


    public Event create(Event event) {
        event.setEventID(10);
        return eventRepository.save(event);
    }

    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll();
    }

    public Optional<Event> findEvent(Long eventID) {
        return eventRepository.findById(eventID);
    }

    public List<Event> findAllByVenueIDAndEventType(String eventTypeName, Integer venueID) {
        return eventRepository.findAllByEventType_NameAndVenue_VenueID(eventTypeName, venueID);
    }

    public Event findByEventID(Long eventID) {
        return eventRepository.findByEventID(eventID);
    }

    public List<EventDTO> getEventsByVenueIDAndEventTypeDTORequiredResponseFormat(Integer venueID, String eventType) throws Exception {

        List<Event> events = findAllByVenueIDAndEventType(eventType, venueID);
        List<EventDTO> returnedEventsDTO = new ArrayList<>();

        for (Event event : events) {
            EventDTO eventDTO = new EventDTO();
            eventDTO.setEventID(event.getEventID());
            eventDTO.setVenues(event.getVenue());
            eventDTO.setType(event.getEventType().getName());
            eventDTO.setDescription(event.getDescription());
            eventDTO.setName(event.getName());
            eventDTO.setStartDate(event.getStartDate());
            eventDTO.setEndDate(event.getEndDate());

            List<TicketCategory> ticketCategories = ticketCategoryRepository.findAllByEvent_EventID(Long.valueOf(event.getEventID()));
            List<TicketCategoryDTO> ticketCategoryDTOS = new ArrayList<>();

            for (TicketCategory ticketCategory : ticketCategories) {
                TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO();
                ticketCategoryDTO.setTicketCategoryID(ticketCategory.getTicketCategoryID());
                ticketCategoryDTO.setPrice(ticketCategory.getPrice());
                ticketCategoryDTO.setDescription(ticketCategory.getDescription());
                ticketCategoryDTOS.add(ticketCategoryDTO);
            }

            eventDTO.setTicketCategoryDTOS(ticketCategoryDTOS);
            returnedEventsDTO.add(eventDTO);
        }
        return returnedEventsDTO;
    }

}