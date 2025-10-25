package com.dsa.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {

        // Collecting Names by Length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        // Counting Word Occurrences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // Partitioning Even and Odd Numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x%2==0)));

        // Creating a map from stream elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        String str = "This Book is a Comic book used for comic sense";
        System.out.println(Arrays.stream(str.split(" ")).map(String::toUpperCase).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

    }
}
