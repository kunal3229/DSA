package com.dsa.systemdesign.parkinglotsystem;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyFeeCalculator implements FeeCalculator{

    private static final int RATE_PER_HOUR = 10;

    @Override
    public int calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        long hours = Duration.between(entryTime, exitTime).toHours();
        hours = Math.max(1, hours);
        return (int) hours*RATE_PER_HOUR;
    }
}
