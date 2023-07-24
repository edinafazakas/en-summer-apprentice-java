package com.endava.TicketManagement.Repository;

import com.endava.TicketManagement.Model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {
    EventType findByName(String eventTypeName);
}
