package com.dsa.multithreading;

public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.setDaemon(true); // it will not wait for t1 to finish if main thread will terminate t1 will also terminate
        MyThread t2 = new MyThread();
        t2.start();
        t1.start();
        t1.interrupt();
        t1.join(); // it will wait for thread t1 to finish then only flow will go to next line

    }

    @Override
    public void run() {
        for (int i=0; i<5; i++){
            try {
                Thread.sleep(1000);
                Thread.yield(); // it will give chance(hint to jvm) to other threads that you can also run
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
