package com.dsa.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReeentrantLock {

    private final Lock lock = new ReentrantLock(); // this will not cause deadlock condition, in the inner method it will
    // again lock in inner method means it will store count of lock acquired because same thread is trying to acquire again.
    // if we unlock in inner method lock count will be reduced by 1

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner Method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReeentrantLock task = new ReeentrantLock();
        task.outerMethod();
    }
}
