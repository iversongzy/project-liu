package com.lgt.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DivideRedPackage {
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {

        ArrayList<Integer> amountList = new ArrayList<Integer>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> redPackage = divideRedPackage(1000, 10);
        for (Integer integer : redPackage) {
            System.out.println("money: " + new BigDecimal(integer).divide(new BigDecimal(100)));
        }
    }
}
