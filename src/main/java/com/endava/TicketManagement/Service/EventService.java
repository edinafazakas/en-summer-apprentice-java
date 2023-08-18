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
import java.util.stream.Collectors;

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

    public List<Event> findAllByVenueIDAndEventType1(String eventTypeName, Integer venueID) {
        return eventRepository.findAllByEventType_NameAndVenue_VenueID(eventTypeName, venueID);
    }

    public List<EventRequestDto> findAllByVenueIDAndEventType2(String eventTypeName, String venue) {
//        for(Event e: eventRepository.findAllByEventType_NameAndVenue_Location("Festival Muzica", "Aleea Stadionului 2, Cluj-Napoca")){
//            System.out.println(e.toString());
//        }

        List<EventRequestDto> eventDTOS = new ArrayList<>();
        List<Event> events = eventRepository.findAllByEventType_NameAndVenue_Location(eventTypeName, venue);
        for(Event e: events){
            EventRequestDto eventDTO = new EventRequestDto();
            eventDTO.setEventID(e.getEventID());
            eventDTO.setTicketCategoriest(ticketCategoryRepository.findAllByEvent_EventID(Long.valueOf(e.getEventID())));
            eventDTO.setName(e.getName());
            eventDTO.setVenue(e.getVenue());
            eventDTO.setEndDate(e.getEndDate());
            eventDTO.setStartDate(e.getStartDate());
            eventDTO.setEventType(e.getEventType());
            eventDTO.setDescription(e.getDescription());
            eventDTOS.add(eventDTO);
        }
        return eventDTOS;
    }

    public Event findByEventID(Long eventID) {
        return eventRepository.findByEventID(eventID);
    }

    public List<EventDTO> getEventsByVenueIDAndEventTypeDTORequiredResponseFormat(Integer venueID, String eventType) throws Exception {

        List<Event> events = findAllByVenueIDAndEventType1(eventType, venueID);
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
            List<TicketCategoryDTO> ticketCategoryDTOS = ticketCategories.stream()
                    .map(ticketCategory -> new TicketCategoryDTO(ticketCategory.getTicketCategoryID(), ticketCategory.getDescription(), ticketCategory.getPrice()))
                    .collect(Collectors.toList());

            eventDTO.setTicketCategoryDTOS(ticketCategoryDTOS);
            returnedEventsDTO.add(eventDTO);
        }
        return returnedEventsDTO;
    }

    public List<EventRequestDto> getEvents() throws Exception {

        List<EventRequestDto> eventDTOS = new ArrayList<>();
        List<Event> events = (List<Event>) eventRepository.findAll();

        for (Event event : events) {
            EventRequestDto eventDTO = new EventRequestDto();
            eventDTO.setEventType(event.getEventType());
            eventDTO.setVenue(event.getVenue());
            eventDTO.setDescription(event.getDescription());
            eventDTO.setName(event.getName());
            eventDTO.setStartDate(event.getStartDate());
            eventDTO.setEndDate(event.getEndDate());
            eventDTO.setEventID(event.getEventID());

            List<TicketCategory> ticketCategories = ticketCategoryRepository.findAll();

            eventDTO.setTicketCategoriest(ticketCategories);
            eventDTOS.add(eventDTO);
        }
        return eventDTOS;
    }

}