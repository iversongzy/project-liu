package com.lgt.datastructure.sort;

public class Utils {
    private Utils() {
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[j] - arr[i] + (arr[j] = arr[i]);
    }
}
