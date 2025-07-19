package strategy;

import models.ParkingFloor;
import models.Vehicle;

public interface FloorFindingStrategy {


    ParkingFloor findParkingFloor(Vehicle vehicle);
}
