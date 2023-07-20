package com.endava.TicketManagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_type")
public class EventType {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventTypeID", nullable = false)
    private Integer eventTypeID;

    @Column(name = "name")
    private String name;

    public EventType() {

    }

    public Integer getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventType{eventTypeID='" + eventTypeID + "'}";
    }
}
