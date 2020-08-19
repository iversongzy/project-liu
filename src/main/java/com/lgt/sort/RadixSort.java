package com.lgt.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
       /*   int arr1[] = {53, 3, 542, 748,14,214};
        radixSort(arr1);
        System.out.println(Arrays.toString(arr1));*/
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    private static void radixSort(int[] arr) {
        //首先要得到最大值的位数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();
        //定义一个二维数组，表示有10个桶，每一个桶的大小为数组的长度（防止溢出），
        int[][] ultraBucket = new int[10][arr.length];
        //定义一个一维数组记录每个桶中的数据个数
        int[] bucketIndex = new int[10];
        int temp = 0;
        for (int i = 0; i < maxLength; i++) {
            //将数据放入桶中(每轮按照个 十 百 千 万的顺序放入对应的桶中)
            for (int j = 0; j < arr.length; j++) {
                temp = arr[j] / (int) Math.pow(10, i) % 10;
                ultraBucket[temp][bucketIndex[temp]++] = arr[j];
            }
            //再将桶中数据按顺序倒出到原数组中
            int index = 0;
            for (int j = 0; j < bucketIndex.length; j++) {
                if (bucketIndex[j] != 0) {
                    for (int k = 0; k < bucketIndex[j]; k++) {
                        arr[index++] = ultraBucket[j][k];
                    }
                }
                //清零留着下轮用
                bucketIndex[j] = 0;
            }
        }
    }
}
