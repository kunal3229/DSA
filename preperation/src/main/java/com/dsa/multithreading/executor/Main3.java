package com.dsa.multithreading.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> submit = service.submit(() -> 1 +2);
        Integer i = submit.get();
        System.out.println("Sum is: "+ i);
        service.shutdown();
        System.out.println(service.isTerminated());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        List<Future<Integer>> futures = executorService.invokeAll(list);
        for (Future<Integer> f : futures){
            System.out.println(f.get());
        }
        executorService.shutdown();

    }
}
