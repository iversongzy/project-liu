package com.lgt.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static double[] bucketSort(double[] array){
        double max = array[0];
        double min = array[0];
        //得到最大值
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        double d = max -min;
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketLists = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketLists.add(new LinkedList<Double>());
        }
        for (int i = 0; i < array.length; i++) {
            int num = (int)((array[i]-min)*(bucketNum-1)/d);
            bucketLists.get(num).add(array[i]);
        }
        for (int i = 0; i < bucketLists.size(); i++) {
            Collections.sort(bucketLists.get(i));
        }

        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> bucketList : bucketLists) {
            for (Double element : bucketList) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = {4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        System.out.println(Arrays.toString(bucketSort(array)));
    }
}
