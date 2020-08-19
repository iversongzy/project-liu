package com.lgt.basicknowledge.interface2polymorphism;

public class PlayerAndCoachTest {
    public static void main(String[] args) {
//        Person liuguotai = new BasketballPlayer("liuguotai", 24, "man");
        BasketballCoach liuguotai = new BasketballCoach();
        liuguotai.age = 25;
        liuguotai.gender = "man";
        liuguotai.name = "liuguotai";
        liuguotai.eat();
        liuguotai.talkWithEnglish();
        FootballPlayer wanghuiyu = new FootballPlayer("wanghuiyu", 18, "woman");
        wanghuiyu.eat();
        System.out.println(wanghuiyu.age);
    }
}
