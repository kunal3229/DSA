package com.dsa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FI {

    public static void main(String[] args) {

        // Predicate --> Functional Interface ( Boolean valued function )
        Predicate<Integer> isEven = x -> x%2==0;
        System.out.println(isEven.test(4));

        Predicate<String> isWordStartingWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndingWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordEndingWithT.and(isWordStartingWithA);
        System.out.println(and.test("Akshay"));

        // Function --> work for you
        Function<Integer, Integer> doubleIt = x -> x*2;
        Function<Integer, Integer> tripleIt = x -> x*3;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(30));

        // Consumer
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        consumer.accept(5);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x){
                System.out.println(i);
            }
        };
        printList.accept(list);

        // Supplier
        Supplier<String> givenHelloWorld = () -> "Hello World";
        System.out.println(givenHelloWorld.get());

        // Combined Example
        Predicate<Integer> predicate = x -> x%2==0;
        Function<Integer, Integer> function = x -> x*x;
        Consumer<Integer> consumer1 = System.out::println;
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())){
            consumer1.accept(function.apply(supplier.get()));
        }

        // BiPredicate, BiConsumer, BiFunction
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a+b)%2==0;
        System.out.println(biPredicate.test(5, 5));

        BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept(4, 6);

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x+y).length();
        System.out.println(biFunction.apply("kuna", "dfdfs"));

        // Advanced Functions
        UnaryOperator<Integer> unaryOperator = x -> 2*x;
        unaryOperator.apply(12);

        BinaryOperator<Integer> binaryOperator = (x, y) -> x+y;
        binaryOperator.apply(12, 23);

    }
}
