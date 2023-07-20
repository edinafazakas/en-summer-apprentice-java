package com.endava.TicketManagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "venue")
public class Venue {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venueID", nullable = false)
    private Integer venueID;

    @Column(name = "location")
    private String location;
    @Column(name = "type")
    private String type;

    @Column(name = "capacity")
    private int capacity;

    public Venue() {

    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Venue{venueID='" + venueID + "'}";
    }
}