package com.dsa.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
    static List<String> generate(int num){
        List<String> res = new ArrayList<>();
        helper(0, 0, "", num, res);
        return res;
    }
    static void helper(int left, int right, String p, int n, List<String> res){
        if (p.length() == 2*n){
            res.add(p);
            return;
        }

        if(left < n) helper(left+1, right, p+"(", n, res);
        if(right < left) helper(left, right+1,p+")", n, res);
    }

}
