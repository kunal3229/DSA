package com.dsa.recursion.medium;

public class PhonePad {
    public static void main(String[] args) {
        phonePad("", "23");

    }
    static void phonePad(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1)*3; i < digit*3; i++){
            char ch = (char) ('a' + i);
            phonePad(p+ch, up.substring(1));
        }
    }
}
