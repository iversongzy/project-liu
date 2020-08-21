package com.lgt.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
       /* int arr1[] = {3, 9, -1, 10, 20};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));*/
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr,0,arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    private static void quickSort(int[] arr, int left, int right) {
        //左右光标
        int lCursor = left;
        int rCursor = right;
        //设基准点为数组中间点
        int pivot = arr[(left + right) / 2];
        //比基准值小的放左边，比基准值大的放右边
        while (lCursor < rCursor) {
            //找到左边比基准值大的
            while (arr[lCursor] < pivot) {
                lCursor += 1;
            }
            //找到右边比基准值小的
            while (arr[rCursor] > pivot) {
                rCursor -= 1;
            }
            //说明已经是左边都比基准值大右边都比基准值小了
            if (lCursor >= rCursor) {
                break;
            }
            //两值交换
            arr[lCursor] = arr[rCursor] - arr[lCursor] + (arr[rCursor] = arr[lCursor]);
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[lCursor] == pivot) {
                rCursor -= 1;
            }
            //同理
            if (arr[rCursor] == pivot) {
                lCursor += 1;
            }
        }
        //防止栈溢出
        if (lCursor == rCursor) {
            lCursor += 1;
            rCursor -= 1;
        }
        //向左递归
        if (left < rCursor) {
            quickSort(arr, left, rCursor);
        }
        //向右递归
        if (lCursor < right) {
            quickSort(arr, lCursor, right);
        }

    }
}
