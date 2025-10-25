package com.dsa.oops;

public abstract class Living {

    public abstract void eat();

    void sleep() {
        System.out.println("Living being is sleeping");
    }
}

class Human extends Living {

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

class LivingMain {
    public static void main(String[] args) {
        Living human = new Human();
        human.eat();
        human.sleep();
    }
}
