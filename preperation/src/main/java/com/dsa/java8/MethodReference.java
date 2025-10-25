package com.dsa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {

        // Method Reference --> use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Sham", "Ghanshyam");
        students.forEach(x -> System.out.println(x)); // normal
        students.forEach(System.out::println); /// method reference

        //Constructor Reference
        List<String> names = Arrays.asList("A", "B", "C");
        names.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());
        List<MobilePhone> mobilePhones = names.stream().map(MobilePhone::new).toList();
        System.out.println(mobilePhones);

    }
}

class MobilePhone {
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
