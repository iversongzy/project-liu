package com.lgt.datastructure.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr1[] = {3, 9, -1, 10, 20};
        selectSort1(arr1);
        System.out.println(Arrays.toString(arr1));
       /* int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);*/
    }

    public static void selectSort(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void selectSort1(int[] arr) {
        //每次遍历的最小值
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            if(min != i) {
                Utils.swap(arr,i, min);
            }
        }
    }
}
