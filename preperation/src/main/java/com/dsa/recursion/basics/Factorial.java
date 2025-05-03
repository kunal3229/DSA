package com.dsa.recursion.basics;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(30));
    }

    private static int factorial(int i) {
        if (i == 1){
            return 1;
        }
        return i * factorial(i - 1);
    }
}
