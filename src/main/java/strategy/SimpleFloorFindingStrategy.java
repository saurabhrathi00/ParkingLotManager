package strategy;

import enums.SpotType;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

import java.util.Map;
import java.util.Set;

public class SimpleFloorFindingStrategy implements FloorFindingStrategy{
    @Override
    public ParkingFloor findParkingFloor(ParkingLot parkingLot,Vehicle vehicle) {
        if (parkingLot == null || vehicle == null || vehicle.getVehicleType() == null) {
            throw new IllegalArgumentException("Parking lot and vehicle must not be null.");
        }

        Set<SpotType> spots = vehicle.getVehicleType().getAllowedSpotTypes();
        // Iterate through each parking floor in the parking lot
         for (ParkingFloor floor : parkingLot.getParkingFloors()) {
            Map<SpotType, Set<ParkingSpot>> parkingSpots = floor.getParkingSpots();

            // Check if the floor has any available spots of the required type
            for (SpotType spotType : spots) {
                Set<ParkingSpot> spotsOnFloor = parkingSpots.get(spotType);
                if (spotsOnFloor != null) {
                    for (ParkingSpot spot : spotsOnFloor) {
                        if (!spot.isOccupied()) {
                            return floor; // Return the first available floor found
                        }
                    }
                }
            }
        }
        // If no available floor is found, return null
        return null; // No available floor found
    }
}
