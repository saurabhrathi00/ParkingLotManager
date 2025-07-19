package models;

import enums.SpotType;
import strategy.ParkingSpotFindingStrategy;
import strategy.SimpleFindingStrategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingFloor {
    private int floorNumber;
    private Map<SpotType, Set<ParkingSpot>> parkingSpots;
    private ParkingSpotFindingStrategy parkingSpotFindingStrategy;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new HashMap<>(
            Map.of(
                SpotType.COMPACT, new HashSet<>(),
                SpotType.STANDARD, new HashSet<>(),
                SpotType.LARGE, new HashSet<>()
            )
        );
        this.parkingSpotFindingStrategy = new SimpleFindingStrategy();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Map<SpotType, Set<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<SpotType, Set<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot spot) {
        if (spot == null || spot.getSpotType() == null) {
            throw new IllegalArgumentException("Invalid parking spot.");
        }
        parkingSpots.computeIfAbsent(spot.getSpotType(), k -> new HashSet<>()).add(spot);
    }
    public void removeParkingSpot(ParkingSpot spot) {
        if (spot == null || spot.getSpotType() == null) {
            throw new IllegalArgumentException("Invalid parking spot.");
        }
        Set<ParkingSpot> spots = parkingSpots.get(spot.getSpotType());
        if (spots != null) {
            spots.remove(spot);
        }
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        ParkingSpot spot = parkingSpotFindingStrategy.findParkingSpot(this, vehicle);
        if (spot == null) {
            throw new IllegalStateException("No available parking spot found for the vehicle.");
        }
        return spot;
    }

    public ParkingSpotFindingStrategy getParkingSpotFindingStrategy() {
        return parkingSpotFindingStrategy;
    }

    public void setParkingSpotFindingStrategy(ParkingSpotFindingStrategy parkingSpotFindingStrategy) {
        this.parkingSpotFindingStrategy = parkingSpotFindingStrategy;
    }
}
