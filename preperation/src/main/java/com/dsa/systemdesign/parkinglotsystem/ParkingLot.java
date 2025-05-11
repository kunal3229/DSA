package com.dsa.systemdesign.parkinglotsystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;
    private FeeCalculator calculator;

    public ParkingLot(int numberOfFloors, int carSlotsPerFloor, int bikeSlotsPerFloor, FeeCalculator calculator){
        this.floors = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        this.calculator = calculator;
        for (int i=0; i<numberOfFloors; i++){
            floors.add(new ParkingFloor("F" + i, carSlotsPerFloor, bikeSlotsPerFloor));
        }
    }

    public boolean park(Vehicle vehicle){
        for (ParkingFloor floor : floors){
            ParkingSlot slot = floor.parkVehicle(vehicle);
            if (slot != null){
                Ticket ticket = new Ticket(vehicle.getNumber(), slot.getSlotId(), LocalDateTime.now());
                activeTickets.put(vehicle.getNumber(), ticket);
                System.out.println(vehicle.getVehicleType() + "parked at slot: " + slot.getSlotId());
                return true;
            }
        }
        System.out.println("No available slot for: " + vehicle.getVehicleType());
        return false;
    }

    public boolean unPark(String vehicleNumber){
        Ticket ticket = activeTickets.get(vehicleNumber);
        if (ticket == null) {
            System.out.println("No ticket found for vehicle: " + vehicleNumber);
            return false;
        }
        for (ParkingFloor floor : floors){
            if (floor.unParkVehicle(vehicleNumber)){
                LocalDateTime exitTime = LocalDateTime.now();
                int fee = calculator.calculateFee(ticket.getEntryTime(), exitTime);
                System.out.println("Vehicle "+vehicleNumber + " unparked.");
                System.out.println("Fee: ₹" + fee);
                activeTickets.remove(vehicleNumber);
                return true;
            }
        }
        return false;
    }
}
