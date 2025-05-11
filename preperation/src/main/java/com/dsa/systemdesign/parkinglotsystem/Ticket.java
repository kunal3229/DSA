package com.dsa.systemdesign.parkinglotsystem;

import java.time.LocalDateTime;

public class Ticket {
    private String vehicleNumber;
    private String slotId;
    private LocalDateTime entryTime;

    public Ticket(String vehicleNumber, String slotId, LocalDateTime entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.slotId = slotId;
        this.entryTime = entryTime;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getSlotId() {
        return slotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
