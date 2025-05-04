package com.dsa.recursion.basics;

public class ReverseNumber {
     static int sum = 0;

    public static void main(String[] args) {
        reverseNumber(1829);
        System.out.println(sum);
        System.out.println(reverse2(1875));
    }

    private static void reverseNumber(int n) {
        if (n == 0) return;

        int rem = n%10;
        sum = sum*10 + rem;
        reverseNumber(n/10);
    }

    private static int reverse2(int n){

        int digits = (int)(Math.log10(n))+1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if ( n%10 == n)return n;

        return n%10 * (int)Math.pow(10, digits-1) + helper(n/10, digits-1);
    }
}
