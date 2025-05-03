package com.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,7,9,8,6,4,1};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int mini = select(arr, i);
            if(mini != i){
                int temp = arr[i];
                arr[i] = arr[mini];
                arr[mini] = temp;
            }
        }
    }

    private static int select(int[] arr, int j){
        int mini = j;
        for(int i=j; i <= arr.length-1; i++){
            if(arr[i] < arr[mini]) mini = i;
        }
        return mini;
    }
}
