package strategy;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Vehicle;

public interface ParkingSpotFindingStrategy {

    /**
     * Finds a parking spot for the given vehicle.
     *
     * @param vehicle the vehicle for which to find a parking spot
     * @return the parking spot number if found, or -1 if no spot is available
     */
    ParkingSpot findParkingSpot(ParkingFloor floor,Vehicle vehicle);
}
