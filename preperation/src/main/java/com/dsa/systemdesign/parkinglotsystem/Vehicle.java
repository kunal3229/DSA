package com.dsa.systemdesign.parkinglotsystem;

import static com.dsa.systemdesign.parkinglotsystem.ParkingConstants.*;

public abstract class Vehicle {

    private String number;
    private VehicleType vehicleType;

    public Vehicle(String number, VehicleType type){
        this.number = number;
        this.vehicleType = type;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

class Bike extends Vehicle{

    public Bike(String number) {
        super(number, VehicleType.BIKE);
    }
}

class Car extends Vehicle{

    public Car(String number) {
        super(number, VehicleType.CAR);
    }
}
