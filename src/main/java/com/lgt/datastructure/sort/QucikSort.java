package com.lgt.datastructure.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QucikSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivot - 1);
        quickSort(arr, pivot + 1, endIndex);
    }

    public static void quickSort1(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
        HashMap rootMap = new HashMap();
        rootMap.put("startIndex", startIndex);
        rootMap.put("endIndex", endIndex);
        stack.push(rootMap);
        while (!stack.isEmpty()) {
            Map<String, Integer> pop = stack.pop();
            int pivot = partition1(arr,pop.get("startIndex"), pop.get("endIndex"));
            if(pop.get("startIndex") < pivot-1) {
                HashMap<String, Integer> left = new HashMap<String, Integer>();
                left.put("startIndex", pop.get("startIndex"));
                left.put("endIndex", pivot-1);
                stack.push(left);
            }
            if(pivot+1<pop.get("endIndex")){
                HashMap<String, Integer> right = new HashMap<String, Integer>();
                right.put("startIndex", pivot+1);
                right.put("endIndex", pop.get("endIndex"));
                stack.push(right);
            }
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public static int partition1(int[] arr, int startIndex, int endIndex){
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex+1; i <= endIndex ; i++) {
            if(arr[i]<pivot){
                mark++;
                int tem =arr[mark];
                arr[mark] = arr[i];
                arr[i] = tem;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    public static void main(String[] args) {
        int[] array = {4, 4, 6, 5, 3, 2, 8, 1};
        //quickSort(array, 0, array.length - 1);
        quickSort1(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
