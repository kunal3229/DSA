package com.dsa.systemdesign.parkinglotsystem;

import java.time.LocalDateTime;

public class FlatFeeCalculator implements FeeCalculator{

    private static final int FLAT_RATE = 50;

    @Override
    public int calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        return FLAT_RATE;
    }
}
