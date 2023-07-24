package com.endava.TicketManagement.Service;

import com.endava.TicketManagement.Model.EventType;
import com.endava.TicketManagement.Repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventTypeService {
    @Autowired
    private EventTypeRepository eventTypeRepository;

    public EventType findByName(String name) {
        return eventTypeRepository.findByName(name);
    }
}
