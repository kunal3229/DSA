package com.dsa.recursion.medium;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String str = "abc";
        subSeq("", str);
        System.out.println(subSeqList("", "abc"));
        System.out.println(subSeqList2("", "abc", new ArrayList<>()));
    }

    private static void subSeq(String p, String up) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(p + ch, up.substring(1));
        subSeq(p, up.substring(1));
    }

    private static ArrayList<String> subSeqList(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqList(p+ch,up.substring(1));
        ArrayList<String> right = subSeqList(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    private static ArrayList<String> subSeqList2(String p, String up, ArrayList<String> temp){
        if (up.isEmpty()){
            temp.add(p);
            return temp;
        }
        char ch = up.charAt(0);
        subSeqList2(p+ch,up.substring(1), temp);
        subSeqList2(p, up.substring(1), temp);
        return temp;
    }
}
