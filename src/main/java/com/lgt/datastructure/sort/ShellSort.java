package com.lgt.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
         /* int arr1[] = {3, 9, -1, 10, 20,2,9,7,8};
        shellSort(arr1);
        System.out.println(Arrays.toString(arr1));*/
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    private static void shellSort(int[] arr) {
        //根据数组长度设置步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 遍历各组中所有的元素(共step组，每组有个元素), 步长step
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        arr[j] = arr[j + step] - arr[j] + (arr[j + step] = arr[j]);
                    }
                }
            }
        }
    }

    /**
     * 优化  交换--->位移
     *
     * @param arr
     */
    private static void shellSort2(int[] arr) {
        //根据数组长度设置步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 从第step个元素起，逐个对其所在的组进行直接插入排序
            /*for (int i = step; i < arr.length; i++) {
                for (int j = i; j - step >= 0 && arr[j] < arr[j - step]; j -= step) {
                    arr[j] = arr[j - step] - arr[j] + (arr[j - step] = arr[j]);
                }
            }*/
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - step]) {
                    while (j - step >= 0 && temp < arr[j - step]) {
                        //移动
                        arr[j] = arr[j - step];
                        j -= step;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }
}
