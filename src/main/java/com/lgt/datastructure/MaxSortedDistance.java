package com.lgt.datastructures;

public class MaxSortedDistance {
    public static int getMaxSortedDistance(int[] array) {
        int max = array[0];
        int min = array[0];
        //得到最小最大值
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        if (d == 0) {
            return 0;
        }
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        //初始化桶
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        //确定每个桶的最大最小值
        for (int i = 0; i < array.length; i++) {
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }
        //遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        Integer max;
        Integer min;
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 4, 3, 5, 10, 9};
        System.out.println(getMaxSortedDistance(array));
    }
}
