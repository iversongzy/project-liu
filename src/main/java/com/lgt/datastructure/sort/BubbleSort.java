package com.lgt.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //如果有元素进行交换，就证明不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void bubbleSort3(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //如果有元素进行交换，就证明不是有序的
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void bubbleSort4(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - 1 - i; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        int[] array1 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        //bubbleSort1(array);
        //bubbleSort2(array);
        //bubbleSort3(array);
        bubbleSort4(array);
        System.out.println(Arrays.toString(array));
    }
}
