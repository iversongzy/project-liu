package com.lgt.datastructure.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test(4);
    }

    private static void test(int i) {
        if (i > 2) {
            test(i - 1);
        }
            System.out.println("n="+i);

    }
}
