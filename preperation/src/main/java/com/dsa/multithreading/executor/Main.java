package com.dsa.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(9);
        for (int i=1; i<10; i++){
            int finalI = i;
            service.submit(() ->{
                long res = factorial(finalI);
                System.out.println(res);
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS); // it will wait 10 seconds for all threads to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));

    }



    private static long factorial(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long res = 1;
        for (int i=1; i <= n; i++){
            res *= i;
        }
        return res;
    }
}
