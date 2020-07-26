package com.lgt.algorithm;

public class GreatestCommonDivisor {
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big - small, small);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(25,5));
        System.out.println(gcd(100,80));
        System.out.println(gcd(27,14));
    }
}
