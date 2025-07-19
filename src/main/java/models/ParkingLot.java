package models;

import exceptions.NoAvailableFloorException;
import exceptions.NoAvailableSpotException;
import exceptions.TicketGenerationException;
import managers.ParkingManager;
import strategy.FeeCalculationStrategy;
import strategy.FloorFindingStrategy;
import strategy.ParkingSpotFindingStrategy;
import strategy.PaymentStrategy;

import java.util.List;

public class ParkingLot {
    private String name;
    private String location;
    private List<ParkingFloor> parkingFloors;
    private Entry entry;
    private Exit exit;
    private ParkingManager parkingManager;


    public ParkingLot(String name, String location, List<ParkingFloor> parkingFloors, Entry entry, Exit exit) {
        this.name = name;
        this.location = location;
        this.parkingFloors = parkingFloors;
        this.entry = entry;
        this.exit = exit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Exit getExit() {
        return exit;
    }

    public void setExit(Exit exit) {
        this.exit = exit;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public void addParkingFloor(ParkingFloor floor) {
        this.parkingFloors.add(floor);
    }
    public void removeParkingFloor(ParkingFloor floor) {
        this.parkingFloors.remove(floor);
    }

    public ParkingManager getParkingManager() {
        return parkingManager;
    }

    public void setParkingManager(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        return parkingManager.parkVehicle(vehicle, this);
    }

    public void unparkVehicle(Ticket ticket) {
        parkingManager.unparkVehicle(ticket, this);
    }

    public void setFloorFindingStrategy(FloorFindingStrategy strategy) {
        this.entry.setFloorFindingStrategy(strategy);
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategy strategy) {
        this.exit.getPaymentProcessor().setFeeCalculationStrategy(strategy);
    }
    public void setParkingSpotFindingStrategy(ParkingSpotFindingStrategy strategy) {
        for (ParkingFloor floor : parkingFloors) {
            floor.setParkingSpotFindingStrategy(strategy);
        }
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.exit.getPaymentProcessor().setPaymentStrategy(strategy);
    }

}
