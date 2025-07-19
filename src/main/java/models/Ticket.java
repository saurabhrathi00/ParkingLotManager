package models;

import enums.TicketStatus;

import java.sql.Timestamp;

public class Ticket {
    private String ticketId;
    private ParkingSpot parkingSpot;
    private Timestamp entryTime;
    private int parkingFloor;
    private TicketStatus ticketStatus;


    public Ticket(String ticketId, ParkingSpot parkingSpot, Timestamp entryTime, int parkingFloor) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.parkingFloor = parkingFloor;
        this.ticketStatus = TicketStatus.ACTIVE; // Default status when ticket is created
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(int parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
