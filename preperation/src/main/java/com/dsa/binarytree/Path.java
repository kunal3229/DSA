package com.dsa.binarytree;

import java.util.LinkedList;
import java.util.List;

public class Path {
    boolean findPath(TreeNode node, int[] arr){
        if(node == null) return arr.length == 0;

        return helper(node, arr, 0);
    }
    boolean helper(TreeNode node, int[] arr, int index){
        if(node == null) return false;

        if(index >= arr.length || node.value != arr[index]) return false;

        if(node.left == null && node.right == null && index == arr.length-1) return true;

        return helper(node.left, arr, index+1) || helper(node.right, arr, index+1);
    }

    int countPaths(TreeNode node, int sum){
        List<Integer> path = new LinkedList<>();
        return helperCountPath(node, sum, path);
    }

    private int helperCountPath(TreeNode node, int sum, List<Integer> path) {
            if(node == null) return 0;

            path.add(node.value);
            int count = 0;
            int currSum = 0;

            count += helperCountPath(node.left, sum, path) + helperCountPath(node.right, sum, path);

            // backtrack
            path.remove(path.size()-1);
            return count;

    }

}
