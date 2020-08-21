package com.lgt.datastructures;

public class BigNumber {
    public static String bigNumberSum(String num1, String num2) {
        //将两个大数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = num1.length() > num2.length() ? num1.length() + 1 : num2.length() + 1;
        int[] arrA = new int[maxLength];
        for (int i = 0; i < num1.length(); i++) {
            arrA[i] = num1.charAt(num1.length() - 1 - i) - '0';
        }
        int[] arrB = new int[maxLength];
        for (int i = 0; i < num2.length(); i++) {
            arrB[i] = num2.charAt(num2.length() - 1 - i) - '0';
        }
        //构建result数组
        int[] result = new int[maxLength];
        //遍历数组按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrA[i];
            temp += arrB[i];
            //判断是否进位
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        //把result再次逆序转成字符串
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        //找到最高有效位
        for (int i = result.length - 1; i >= 0; i--) {
            if (!flag) {
                if (result[i] == 0) {
                    continue;
                }
                flag = true;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }
}
