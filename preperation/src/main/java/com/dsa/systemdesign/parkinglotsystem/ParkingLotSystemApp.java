package com.dsa.systemdesign.parkinglotsystem;

public class ParkingLotSystemApp {
    public static void main(String[] args) throws InterruptedException {
        FeeCalculator calculator = new HourlyFeeCalculator();
        ParkingLot lot = new ParkingLot(1, 2, 2, calculator);

        Vehicle car1 = new Car("HR26-1111");
        Vehicle bike1 = new Bike("HR26-2222");

        lot.park(car1);
        Thread.sleep(1000); // simulate time passing
        lot.park(bike1);

        Thread.sleep(2000); // simulate time before unparking
        lot.unPark("HR26-1111");
        lot.unPark("HR26-2222");

    }
}
