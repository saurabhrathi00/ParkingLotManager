package strategy;

import enums.SpotType;
import models.ParkingFloor;
import models.ParkingSpot;
import models.Vehicle;

import java.util.Set;

public class SimpleFindingStrategy implements ParkingSpotFindingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingFloor floor,Vehicle vehicle) {
        if (floor == null || vehicle == null || vehicle.getVehicleType() == null) {
            throw new IllegalArgumentException("Floor and vehicle must not be null.");
        }
        Set<SpotType> allowedSpotTypes = vehicle.getVehicleType().getAllowedSpotTypes();


        for (SpotType spotType : allowedSpotTypes) {
            Set<ParkingSpot> spots = floor.getParkingSpots().get(spotType);
            if (spots != null) {
                for (ParkingSpot spot : spots) {
                    if (!spot.isOccupied()) {
                        return spot; // Return the first available spot found
                    }
                }
            }
        }
        return null; // No available spot found
    }

}
