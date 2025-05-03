package com.dsa.recursion.basics;

public class Nto1 {

    public static void main(String[] args) {
        printTill1(5);

    }

    public static void printTill1(int n){
        if(n <= 0) return;
        printTill1(n-1);
        System.out.println(n);
    }
}
