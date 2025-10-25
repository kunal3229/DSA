package com.dsa.java8.stream;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        // Type of stream that parallel processing of elements
        // Allowing multiple threads to process parts of the simultaneously
        // This can significantly improve performance for larger data sets
        // workload is distributed across multiple streams
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x+1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(ParallelStreams::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream " + (endTime-startTime) + " ms");

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStreams::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with  parallel stream " + (endTime-startTime) + " ms");
    }
    private static long factorial(int n){
        long result = 1;
        for (int i=2; i<= n; i++){
            result *= i;
        }
        return result;
    }
}
