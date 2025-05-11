package com.dsa.systemdesign.parkinglotsystem;

import static com.dsa.systemdesign.parkinglotsystem.ParkingConstants.*;

public class ParkingSlot {

    private String slotId;
    private SlotType slotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(String slotId, SlotType slotType) {
        this.slotType = slotType;
        this.slotId = slotId;
        this.isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return !isOccupied && slotType.name().equals(vehicle.getVehicleType().name());
    }

    public boolean park(Vehicle vehicle){
        if (canFitVehicle(vehicle)){
            this.parkedVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void unPark(){
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public String getSlotId() {
        return slotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
