package com.dsa.multithreading.executor;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello";
        Future<String> stringFuture = executorService.submit(callable);
        Future<?> future = executorService.submit(() -> 42);
        if (future.isDone()){
            System.out.println("Task is completed");
        }
        System.out.println(future.get());
        System.out.println(stringFuture.get());
        executorService.shutdown();
    }
}
