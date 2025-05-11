package com.dsa.systemdesign.parkinglotsystem;

import java.time.LocalDateTime;

public interface FeeCalculator {
    int calculateFee(LocalDateTime entryTime, LocalDateTime exitTime);
}
