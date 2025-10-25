package com.dsa.java8;

import lombok.ToString;

import java.util.Comparator;

@ToString
public class Student implements Comparable<Student>{

    String name;
    int marks;

    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}

class Student2 implements Comparator<Student2> {
    String name;
    int marks;

    Student2(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.name.compareTo(o2.name);
    }
}
