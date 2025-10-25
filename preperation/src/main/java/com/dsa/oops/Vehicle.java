package com.dsa.oops;

public class Vehicle implements Cloneable{
    String type;
    public Vehicle(String type) {
        this.type = type;
    }

    public Vehicle clone() throws CloneNotSupportedException {
        return (Vehicle) super.clone();
    }
}

class Car extends Vehicle {
    String model;
    public Car(String type, String model) {
        super(type);
        this.model = model;
    }

    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}

class Main1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car("Sedan", "Civic");
        Car car1 = car.clone();
        System.out.println(car1.type + car1.model);
        System.out.println(car.type + car.model);
        System.out.println(car + " == " + car1);
    }
}
