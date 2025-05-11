package com.dsa.systemdesign.parkinglotsystem;

import java.util.ArrayList;
import static com.dsa.systemdesign.parkinglotsystem.ParkingConstants.*;
import java.util.List;

public class ParkingFloor {
    private String floorId;
    List<ParkingSlot> slots;

    public ParkingFloor(String floorId, int carSlots, int bikeSlots){
        this.floorId = floorId;
        this.slots = new ArrayList<>();
        for (int i=0; i<carSlots; i++){
            slots.add(new ParkingSlot(floorId + "_CAR_" + i, SlotType.CAR));
        }
        for (int i=0; i<bikeSlots; i++){
            slots.add(new ParkingSlot(floorId + "_BIKE_" + i, SlotType.BIKE));
        }
    }

    public ParkingSlot parkVehicle(Vehicle vehicle){
        for (ParkingSlot slot : slots){
            if(slot.park(vehicle)){
                return slot;
            }
        }
        return null;
    }

    public boolean unParkVehicle(String vehicleNumber){
        for (ParkingSlot slot : slots){
            if (slot.isOccupied() && slot.getParkedVehicle().getNumber().equals(vehicleNumber)){
                slot.unPark();
                return true;
            }
        }
        return false;
    }
}
