package models;

import enums.ParkingSpotStatus;
import enums.SpotType;

public class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private ParkingSpotStatus status;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false; // Initially not occupied
        this.parkedVehicle = null; // Initially no vehicle parked
        this.status = ParkingSpotStatus.AVAILABLE; // Initially available
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        if (parkedVehicle != null && !isValidSpotTypeForVehicle(parkedVehicle)) {
            throw new IllegalArgumentException("Vehicle type does not match the parking spot type.");
        }
        this.parkedVehicle = parkedVehicle;
    }

    public boolean isValidSpotTypeForVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicle.getVehicleType() == null) {
            return false; // Invalid vehicle
        }
        return vehicle.getVehicleType().getAllowedSpotTypes()
                .contains(this.spotType);
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }
}
