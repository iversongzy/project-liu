package com.lgt.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
       /* int arr1[] = {3, 9, -1, 10, 20};
        int temp[] = new int[arr1.length]; //归并排序需要一个额外空间
        mergeSort(arr1, 0, arr1.length - 1, temp);
        System.out.println(Arrays.toString(arr1));*/
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左递归分解
            mergeSort(arr, left, mid, temp);
            //右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //初始化左右索引
        int lCursor = left;
        int rCursor = mid + 1;
        //temp的当前索引
        int t = 0;
        //直到两边有一边处理完为止
        while (lCursor <= mid && rCursor <= right) {
            if (arr[lCursor] < arr[rCursor]) {
                temp[t++] = arr[lCursor++];
            } else {
                temp[t++] = arr[rCursor++];
            }
        }
        //把有剩余数据的一边的数据依次全部填充到temp
        while (lCursor <= mid) {
            temp[t++] = arr[lCursor++];
        }
        while ((rCursor <= right)) {
            temp[t++] = arr[rCursor++];
        }

        t = 0;
        //将temp数组的元素拷贝到arr
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];

        }
    }
}
