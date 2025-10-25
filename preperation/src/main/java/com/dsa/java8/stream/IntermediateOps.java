package com.dsa.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked

        // 1. Filter
        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // no filtering at this point bcz we are not doing terminal operation (like Collecting and counting)
        long res = list.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(res);

        // 2. map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);
        System.out.println(stringStream);

        //3. sorted
        Stream<String> sortedStream = list.stream().sorted();
        System.out.println(sortedStream);
        Stream<String> customStream = list.stream().sorted((a, b) -> a.length() - b.length());
        System.out.println(customStream);

        // 4. distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5. limit
        System.out.println(Stream.iterate(1, x-> x+1).limit(100).count());

        // 6. skip
        System.out.println(Stream.iterate(1, x-> x+1).skip(10).limit(100).count());

        // 7. peek

        // 8. Max/ Min
        System.out.println("Max: " + Stream.of(2, 44, 67).max(Comparator.naturalOrder()));
        System.out.println("Min: " + Stream.of(2, 44, 67).min(Comparator.naturalOrder()));

        // 9. flatmap
        // Handles Streams of Collections, lists, or arrays where element is itself a Collections
        // Flatten nested structures ( e.g. lists within lists)
        // Transform and flatten elements at the same time
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        System.out.println(lists.get(1).get(1));
        System.out.println(lists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());


    }
}
