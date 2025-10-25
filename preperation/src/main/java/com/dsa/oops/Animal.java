package com.dsa.oops;

public class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {

    void eat() {
        System.out.println("Dog is eating");
    }
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Main2 {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Polymorphism reference
        animal.eat(); // will call Dog's eat method
        animal.sleep();
//         animal.bark(); // This will cause a compilation error

        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        dog.sleep();
    }
}
