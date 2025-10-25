package com.dsa.multithreading;

public class CounterMain {

    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread c1 = new CounterThread(counter);
        CounterThread c2 = new CounterThread(counter);

        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
