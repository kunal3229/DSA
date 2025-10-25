package com.dsa.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Streams feature introduced in java 8
        // process collection of data in a functional and declarative manner
        // Simplify Data Processing
        // Embrace functional Programming
        // Improve Readability and Maintainability
        // Enable Easy parallelism

        // What is Stream
        // a sequence of elements supporting functional and declarative programing

        List<Integer> numbers = Arrays.asList(1,2 ,3 ,4, 5);
        System.out.println(numbers.stream().filter(x -> x%2 == 0).count());

        // Creating Streams
        // 1. From Collections
        List<Integer> list = Arrays.asList(1,2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // 2. From Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> stringStream = Arrays.stream(array);

        // 3. Using Stream.of()
        Stream<String> stream1 = Stream.of("a", "b", "c");

        // Infinite Stream
        Stream<Integer> generate = Stream.generate(() -> 1).limit(100);
        System.out.println(Stream.iterate(1, x-> x+1).limit(100).collect(Collectors.toList()));
    }
}
