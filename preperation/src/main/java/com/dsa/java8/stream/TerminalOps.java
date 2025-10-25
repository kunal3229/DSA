package com.dsa.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);

        // 1. Collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        // 2. foreach
        list.stream().forEach(x -> System.out.println(x));

        // 3. reduce : combines elements to produce a single result
        Optional<Integer> optionalI = list.stream().reduce(Integer::sum);
        System.out.println(optionalI.get());

        // 4. anymatch, allmatch, nonematch
        System.out.println(list.stream().anyMatch(x -> x%2 == 0));
        System.out.println(list.stream().allMatch(x -> x%2 == 0));
        System.out.println(list.stream().noneMatch(x -> x< 0));

        // 5. findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // Examples
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 3, 7);
        System.out.println(numbers.stream().map(x -> x*x).sorted().toList());

        // Summing values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        // Counting Occurrences of a character
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Example
        // Stream cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        List<String> list1 = stream.map(String::toUpperCase).toList(); // Exception

        // Grouping
        List<String> words = Arrays.asList("hello", "world", "java", "streams");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
//        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));

        // Partitioning Elements
        // Partition elements into two groups (true and false) based on a predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        // Mapping and Collecting
        // Applies a mapping function before collections
        System.out.println(Optional.ofNullable(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()))));

        // Stateful & Stateless operations



    }
}
