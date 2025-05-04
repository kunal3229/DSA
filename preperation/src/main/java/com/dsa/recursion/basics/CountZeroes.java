package com.dsa.recursion.basics;

public class CountZeroes {
    public static void main(String[] args) {
        System.out.println(countZeroes(1204050));
    }

    private static int countZeroes(int num) {
        return helperCount(num, 0);
    }

    private static int helperCount(int num, int count) {
        if (num == 0) return count;

        if (num%10 == 0) return helperCount(num/10, count+1);
        else return helperCount(num/10, count);
    }
}
