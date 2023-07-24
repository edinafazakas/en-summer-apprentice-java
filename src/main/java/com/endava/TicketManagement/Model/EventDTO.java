package com.endava.TicketManagement.Model;

import java.util.Date;
import java.util.List;

public class EventDTO {
    private Integer eventID;
    private String type;
    private String description;
    private String name;
    private Date startDate;
    private Date endDate;
    private List<TicketCategoryDTO> ticketCategoryDTOS;
    private Venue venues;


    public EventDTO() {

    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<TicketCategoryDTO> getTicketCategoryDTOS() {
        return ticketCategoryDTOS;
    }

    public void setTicketCategoryDTOS(List<TicketCategoryDTO> ticketCategoryDTOS) {
        this.ticketCategoryDTOS = ticketCategoryDTOS;
    }

    public Venue getVenues() {
        return venues;
    }

    public void setVenues(Venue venues) {
        this.venues = venues;
    }
}
