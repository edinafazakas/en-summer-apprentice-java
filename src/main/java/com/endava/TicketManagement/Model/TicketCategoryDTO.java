package com.endava.TicketManagement.Model;

public class TicketCategoryDTO {

    private Integer ticketCategoryID;
    private String description;
    private int price;

    public TicketCategoryDTO() {

    }

    public TicketCategoryDTO(Integer ticketCategoryID, String description, int price) {
        this.ticketCategoryID = ticketCategoryID;
        this.description = description;
        this.price = price;
    }

    public Integer getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
