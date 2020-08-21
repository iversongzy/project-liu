package com.lgt.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
       /* int arr1[] = {3, 9, -1, 10, 20,2,9,7,8};
        insertSort1(arr1);
        System.out.println(Arrays.toString(arr1));*/
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort1(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void insertSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }

    public static void insertSort1(int[] arr) {
        //为什么从1开始，因为将0作为有序表，1以后的作为无序表插入过去
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                Utils.swap(arr, j, j - 1);
            }
        }
    }
}
