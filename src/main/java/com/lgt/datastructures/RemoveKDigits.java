package com.lgt.datastructures;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeDigits("1593212", 3));
        System.out.println(removeDigits("30200", 1));
        System.out.println(removeDigits("10", 2));
        System.out.println(removeDigits("541270936", 3));
        System.out.println(removeDigits1("1593212", 3));
        System.out.println(removeDigits1("30200", 1));
        System.out.println(removeDigits1("10", 2));
        System.out.println(removeDigits1("541270936", 3));
    }

    public static String removeDigits(String s, int k) {
        String string = s;
        for (int i = 0; i < k; i++) {
            boolean flag = false;
            //从左往右遍历，找到比自己右侧数字大的数字并删除
            for (int j = 0; j < string.length() - 1; j++) {
                if (string.charAt(j) > string.charAt(j + 1)) {
                    string = string.substring(0, j) + string.substring(j + 1, string.length());
                    flag = true;
                    break;
                }
            }
            //如果没找到就删除最右边的数
            if (!flag) {
                string = string.substring(0, string.length() - 1);
            }
            //清空左侧的0
            string = removeZero(string);
        }
        if (string.length() == 0) {
            return "0";
        }
        return string;
    }

    public static String removeDigits1(String num, int k) {
        //新整数最终长度
        int newLength = num.length() - k;
        //创建一个栈接收所有数组
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈（删除）
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;
        }
        //找到栈中第一个非零数字的位置，以此构建新数字字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    private static String removeZero(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(0) != '0') {
                break;
            }
            string = string.substring(1, string.length());
        }
        return string;
    }
}
