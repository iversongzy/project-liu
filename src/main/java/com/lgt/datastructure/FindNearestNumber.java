package com.lgt.datastructure;

import java.util.Arrays;

public class FindNearestNumber {
    public static int[] findNearestNumber(int[] numbers) {
        //1从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字边界是0，说明整个数组已经逆序，无法获得更大的相同数字组成的整数
        if (index == 0) {
            return null;
        }
        //2把逆序区的前一位和逆序区中刚刚大于他的数字交换位置
        //复制入参，避免直接修改
        int[] numArray = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(index, numArray);
        //把原来逆序的区域变成顺序
        reverse(index, numArray);
        return numArray;
    }

    private static int[] exchangeHead(int index, int[] numArray) {
        int head = numArray[index - 1];
        for (int i = numArray.length - 1; i > 0; i--) {
            if (head < numArray[i]) {
                numArray[index - 1] = numArray[i];
                numArray[i] = head;
                break;
            }
        }
        return numArray;
    }

    private static int[] reverse(int index, int[] numArray) {
        for (int i = numArray.length, j = index; i < j; i--, j++) {
            int temp = numArray[j];
            numArray[j] = numArray[i];
            numArray[i] = temp;
        }
        return numArray;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            show(numbers);
        }
    }

    private static void show(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
