package com.endava.TicketManagement.Repository;

import com.endava.TicketManagement.Model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    TicketCategory findByTicketCategoryID(Long ticketCategoryID);
    List<TicketCategory> findAllByEvent_EventID(Long eventID);
}
