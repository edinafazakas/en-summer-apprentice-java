package com.endava.TicketManagement.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class EventRequestDto {
    private Integer eventID;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Venue venue;
    private EventType eventType;
    private List<TicketCategory> ticketCategories;

    public EventRequestDto() {

    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<TicketCategory> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategoriest(List<TicketCategory> ticketCategoryDTOS) {
        this.ticketCategories = ticketCategoryDTOS;
    }

    @Override
    public String toString() {
        return "Event{eventID='" + eventID + "'}";
    }
}
