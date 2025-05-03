package com.dsa.recursion.basics;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sumDigit(1342));
    }

    private static int sumDigit(int n) {
        if (n%10 == n) return n;

        int rem = n % 10;
        n = n/10;
        return rem + sumDigit(n);
    }
}
