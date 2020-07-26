package com.lgt.util;

import java.util.Calendar;
import java.util.Random;

public class UtilCase {
    public static void main(String[] args) {
        //random();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MONTH, -1);
        instance.set(Calendar.YEAR, 2020);
        System.out.println(instance.getTime());
    }

    private static void random() {
        Random random = new Random();
        //取值在[0,10)之间的随机数
        int num = random.nextInt(10);
        System.out.println(num);
    }
}
