package com.dsa.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorStudent implements Comparator<ComparatorStudent> {
    int id;
    String name;

    public ComparatorStudent(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compare(ComparatorStudent o1, ComparatorStudent o2) {
        return o1.name.compareTo(o2.name);
    }
    public String toString(){
        return id + " " + name;
    }

    public static void main(String[] args) {
        List<ComparatorStudent> list = List.of(new ComparatorStudent(1, "A"), new ComparatorStudent(2, "B"), new ComparatorStudent(3, "C"));
//        Collections.sort(list, Comparator.comparing(Comparator::naturalOrder));
        System.out.println(list);
    }
}
