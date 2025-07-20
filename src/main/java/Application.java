import enums.SpotType;
import enums.VehicleType;
import managers.PaymentProcessor;
import models.*;

public class Application {

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("ABC123", VehicleType.CAR);
        Vehicle v2 = new Vehicle("XYZ789", VehicleType.MOTORCYCLE);
        Vehicle v3 = new Vehicle("LMN456", VehicleType.TRUCK);


        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingSpot spot1 = new ParkingSpot("PS1", SpotType.COMPACT);
        ParkingSpot spot2 = new ParkingSpot("PS2", SpotType.STANDARD);
        ParkingSpot spot3 = new ParkingSpot("PS3", SpotType.LARGE);
        floor1.addParkingSpot(spot1);
        floor1.addParkingSpot(spot2);
        floor1.addParkingSpot(spot3);

        ParkingFloor floor2 = new ParkingFloor(2);
        ParkingSpot spot4 = new ParkingSpot("PS4", SpotType.COMPACT);
        ParkingSpot spot5 = new ParkingSpot("PS5", SpotType.STANDARD);
        ParkingSpot spot6 = new ParkingSpot("PS6", SpotType.LARGE);
        floor2.addParkingSpot(spot4);
        floor2.addParkingSpot(spot5);
        floor2.addParkingSpot(spot6);

        Entry entry1 = new Entry("E1");
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Exit exit1 = new Exit("X1",paymentProcessor);


        ParkingLot parkingLot = new ParkingLot("Main Parking Lot","Downtown");
        parkingLot.addParkingFloor(floor1);
        parkingLot.addParkingFloor(floor2);

        parkingLot.addEntry(entry1);
        parkingLot.addExit(exit1);

        // Simulate parking vehicles

        Ticket t1 = parkingLot.parkVehicle(v1);
        Ticket t2 = parkingLot.parkVehicle(v2);
        Ticket t3 = parkingLot.parkVehicle(v3);

        parkingLot.unparkVehicle(t1);
        parkingLot.unparkVehicle(t2);
        parkingLot.unparkVehicle(t3);
    }
}
