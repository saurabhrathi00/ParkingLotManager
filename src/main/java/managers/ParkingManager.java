package managers;

import exceptions.NoAvailableFloorException;
import exceptions.NoAvailableSpotException;
import exceptions.TicketGenerationException;
import models.*;

public class ParkingManager {

    public Ticket parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        // Logic to park the vehicle
        ParkingFloor floor = parkingLot.getEntry().findParkingFloor(vehicle);
        ParkingSpot spot = floor.findAvailableSpot(vehicle);
        spot.setParkedVehicle(vehicle);
        spot.setOccupied(true);
        Ticket ticket = null;
        try {
            ticket = parkingLot.getEntry().getTicket(vehicle);
            System.out.println("Vehicle parked successfully. Ticket ID: " + ticket.getTicketId());
        } catch (
        NoAvailableFloorException e) {
            e.printStackTrace();
        } catch (
        NoAvailableSpotException e) {
            e.printStackTrace();
        } catch (
        TicketGenerationException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public void unparkVehicle(Ticket ticket, ParkingLot parkingLot) {
        ParkingSpot spot = ticket.getParkingSpot();
        Vehicle vehicle = spot.getParkedVehicle();
        Exit exit = parkingLot.getExit();
        double fee = exit.calculateFee(ticket);
        exit.processPayment(ticket, fee);
        if (vehicle != null) {
            spot.setParkedVehicle(null);
            spot.setOccupied(false);

        } else {
            System.out.println("No vehicle found in the specified parking spot.");
        }
    }
}
