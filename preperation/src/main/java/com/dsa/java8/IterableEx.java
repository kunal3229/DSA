package com.dsa.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IterableEx {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        List<String> list2 = List.of("A", "B", "C", "D", "E");

//        for(String s : list2){
////            if (Objects.equals(s, "A")) list2.remove(s); // fail fast iterator failing
//            System.out.println(s);
//        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if (Objects.equals(entry.getKey(), "A")) map.remove(entry.getKey()); // fail fast iterator failing
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Iterator iterator = list2.iterator();
        while (iterator.hasNext()){
            String s = (String) iterator.next();
            if (Objects.equals(s, "A")) iterator.remove();
            System.out.println(s);
        }
    }
}
