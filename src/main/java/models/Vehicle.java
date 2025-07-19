package models;

import enums.VehicleType;

public class Vehicle {
    private String vehicleRegistrationNumber;
    private VehicleType vehicleType;


    public Vehicle(String vehicleRegistrationNumber, VehicleType vehicleType) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
