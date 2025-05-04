package com.dsa.recursion.basics;

public class StringBasics {
    public static void main(String[] args) {
        String str = "apple";
        System.out.println(removeA(str, ""));
        System.out.println(skipApple("dsaapple"));
        System.out.println(skipAppNotApple("fseppdas"));
    }

    private static String removeA(String up, String p) {
        if (up.isEmpty()) return p;

        char ch = up.charAt(0);
        if (ch == 'a') return removeA(up.substring(1), p);
        return removeA(up.substring(1), p+ch);
    }

    private static String skipA(String up){
        if (up.isEmpty()) return "";
        char ch = up.charAt(0);
        if (ch != 'a'){
            return ch + skipA(up.substring(1));
        }
        return skipA(up.substring(1));
    }

    private static String skipApple(String up){
        if (up.isEmpty()) return "";

        char ch = up.charAt(0);

        if (up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
             return ch + skipApple(up.substring(1));
        }
    }

    private static String skipAppNotApple(String up){
        if (up.isEmpty()) return "";

        char ch = up.charAt(0);

        if (up.startsWith("app") && !up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return ch + skipApple(up.substring(1));
        }
    }
}
