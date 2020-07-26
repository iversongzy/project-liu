package com.lgt.datastructure.sort;

import java.util.Arrays;

public class CountSort {
    public static int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];
        //得到最大值
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int d = max - min;
        //因为下边从0开始,所以要+1
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]-min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i]+=countArray[i-1];
        }
        int[] sortedArray = new int[array.length];
        for (int i = array.length-1; i >= 0 ; i--) {
            sortedArray[countArray[array[i]-min]-1] = array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] array2 = {95,94,91,98,99,90,99,93,91,92};
        System.out.println(Arrays.toString(countSort(array2)));
    }
}
