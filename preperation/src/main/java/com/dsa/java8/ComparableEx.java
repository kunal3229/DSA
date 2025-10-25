package com.dsa.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableEx implements Comparable<ComparableEx>{
    int id;
    String name;

    ComparableEx(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableEx o) {
        return this.id - o.id;
    }

    public String toString(){
        return id + " " + name;
    }

    public static void main(String[] args) {
        List<ComparableEx> list = new ArrayList<>(List.of(new ComparableEx(1, "A"), new ComparableEx(2, "B"), new ComparableEx(3, "C")));
        Collections.sort(list);
        System.out.println(list);
    }

}
