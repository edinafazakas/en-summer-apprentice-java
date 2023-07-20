package com.endava.TicketManagement.Repository;

import com.endava.TicketManagement.Model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    TicketCategory findByTicketCategoryID(Long ticketCategoryID);
}
