package models;

import exceptions.NoAvailableFloorException;
import exceptions.NoAvailableSpotException;
import exceptions.TicketGenerationException;
import strategy.FloorFindingStrategy;

import java.util.Random;
import java.util.UUID;

public class Entry {
    private String id;
    private FloorFindingStrategy floorFindingStrategy;

    public Entry(String id) {
        this.id = id;
        this.floorFindingStrategy = null;
    }

    public String getId() {
        return id;
    }

    public FloorFindingStrategy getFloorFindingStrategy() {
        return floorFindingStrategy;
    }

    public void setFloorFindingStrategy(FloorFindingStrategy floorFindingStrategy) {
        this.floorFindingStrategy = floorFindingStrategy;
    }

    public ParkingFloor findParkingFloor(Vehicle vehicle) {
        if (floorFindingStrategy != null) {
            return floorFindingStrategy.findParkingFloor(vehicle);
        }
        return null;
    }

    public Ticket getTicket(Vehicle vehicle) throws NoAvailableFloorException, NoAvailableSpotException, TicketGenerationException {
        try {
            ParkingFloor floor = findParkingFloor(vehicle);
            if (floor == null) {
                throw new NoAvailableFloorException("No parking floor found for vehicle type: " + vehicle.getVehicleType());
            }

            ParkingSpot parkingSpot = floor.findAvailableSpot(vehicle);
            if (parkingSpot == null) {
                throw new NoAvailableSpotException("No available spot found for vehicle type: " + vehicle.getVehicleType());
            }

            String ticketId = UUID.randomUUID().toString();
            Ticket ticket = new Ticket(
                    ticketId,
                    parkingSpot,
                    new java.sql.Timestamp(System.currentTimeMillis()),
                    floor.getFloorNumber()
            );
            parkingSpot.setParkedVehicle(vehicle);
            parkingSpot.setOccupied(true);
            return ticket;
        } catch (NoAvailableFloorException | NoAvailableSpotException e) {
            throw e;
        } catch (Exception e) {
            throw new TicketGenerationException("Failed to generate ticket", e);
        }
    }

}
