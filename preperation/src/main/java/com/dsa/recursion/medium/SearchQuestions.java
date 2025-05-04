package com.dsa.recursion.medium;

import java.util.ArrayList;

public class SearchQuestions {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,8,2,9};
        int[] arr2 = new int[]{1,3,5,7,8,9};
        System.out.println(linearSearch(arr, 2, 0));
        System.out.println(linearSearch2(arr, 8, 0));
        System.out.println(sorted(arr, 0));
        System.out.println(linearSearchAll(arr, 2, 0, new ArrayList<>()));
        System.out.println(linearSearchAll2(arr, 2, 0));
        System.out.println(binarySearch(arr2, 8, 0, arr2.length-1));
        System.out.println(rotatedBS(arr2, 8, 0, arr2.length-1));
    }

    static ArrayList<Integer> list = new ArrayList<>();

    private static boolean sorted(int[] arr, int idx){
        if (idx == arr.length-1) return true;
        return arr[idx] < arr[idx+1] && sorted(arr, idx+1);
    }

    private static boolean linearSearch2(int[] arr, int target, int idx){
        if (idx == arr.length) return false;

        return arr[idx] == target || linearSearch2(arr, target, idx+1);
    }

    private static int linearSearch(int[] arr, int target, int idx) {
        if(idx == arr.length) return -1;

        if(arr[idx] == target) return idx;
        return linearSearch(arr, target, idx+1);
    }

    private static ArrayList<Integer> linearSearchAll(int[] arr, int target, int idx, ArrayList<Integer> temp){
        if (idx == arr.length) return temp;

        if (arr[idx] == target) temp.add(idx);
        return linearSearchAll(arr, target, idx+1, temp);
    }

    private static ArrayList<Integer> linearSearchAll2(int[] arr, int target, int idx){
        ArrayList<Integer> temp = new ArrayList<>();
        if (idx == arr.length) return temp;
        if (arr[idx] == target) temp.add(idx);
        ArrayList<Integer> belowIdx = linearSearchAll2(arr, target, idx+1);
        temp.addAll(belowIdx);
        return temp;
    }

    private static int binarySearch(int[] arr, int target, int s, int e){
        if (s > e) return -1;
        int m = (s+e) >>> 1;

        if (arr[m] == target) return m;
        if (arr[m] > target) return binarySearch(arr, target, s, m-1);
        return binarySearch(arr, target, m+1, e);
    }

    private static int rotatedBS(int[] arr, int target, int s, int e){
        if (s > e) return -1;
        int m = s + (e-s)/2;
        if (arr[m] == target) return m;
        if (arr[s] <= arr[m]){
            if (arr[s] <= target && target <= arr[m]) return rotatedBS(arr, target, s, m-1);
            else return rotatedBS( arr, target, m+1, e);
        } else{
            if (arr[m] <= target && target <= arr[e]) return rotatedBS(arr, target, m+1, e);
            else return rotatedBS(arr, target, s, m-1);
        }
    }
}
