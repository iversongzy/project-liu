package com.lgt.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int temp = 0;
        //如果一趟比较下来没有交换说明有序
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    //交换公式 a = b - a + (b = a);
                    arr[j] = arr[j+1] - arr[j] + (arr[j+1] = arr[j]);
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        int lastExchangeIndex = 0;
        boolean isSorted;
        int sortBorder = arr.length - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            //isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if(arr[j] > arr[j+1]) {
                    //如果有交换就证明不是有序的，如果没有交换说明已经有序不需要往下进行了
                    isSorted = false;
                    //更新最后一次交换元素的位置
                    lastExchangeIndex = j;
                    //交换公式 a = b - a + (b = a);
                    arr[j] = arr[j+1] - arr[j] + (arr[j+1] = arr[j]);
                }
            }
            sortBorder = lastExchangeIndex;
            if(false) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {3, 9, -1, 10, 20};
        bubbleSort2(arr1);
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
        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);*/
    }
}
