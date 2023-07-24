package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.Event;
import com.endava.TicketManagement.Model.EventDTO;
import com.endava.TicketManagement.OrdersRepositoryTesta.EventRepository;
import com.endava.TicketManagement.OrdersRepositoryTesta.TicketCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private TicketCategoryRepository ticketCategoryRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    public void testCreateEvent() {
        Event event = new Event();
        event.setEventID(10);

        when(eventRepository.save(event)).thenReturn(event);

        Event createdEvent = eventService.create(event);

        assertEquals(Optional.ofNullable(10L), Optional.ofNullable(createdEvent.getEventID()));
        verify(eventRepository, times(1)).save(event);
    }*/

    @Test
    public void testFindAllEvents() {
        List<Event> events = new ArrayList<>();

        when(eventRepository.findAll()).thenReturn(events);

        List<Event> result = eventService.findAll();

        assertEquals(events, result);
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    public void testFindEventById() {
        Long eventID = 123L;
        Event event = new Event();

        when(eventRepository.findById(eventID)).thenReturn(Optional.of(event));

        Optional<Event> result = eventService.findEvent(eventID);

        assertEquals(Optional.of(event), result);
        verify(eventRepository, times(1)).findById(eventID);
    }

}
