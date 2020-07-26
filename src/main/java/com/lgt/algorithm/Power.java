package com.lgt.algorithm;

public class Power {
    public static boolean isPower(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPower(32));
        System.out.println(isPower(19));
    }
}
