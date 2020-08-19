package com.lgt.basicknowledge.extend2abstract;

public class Test {
    public static void main(String[] args) {
        Human man = new Man.Builder().setAge(25).setGender("man").setName("liuguotai").build();
        Man man1 = new Man(new Man.Builder());
        man1.performDress();
        System.out.println(man1.age);
        man.setClother(new Shirt());
        man.setSwim(new Swim());
        man.performSwim();
        man.performDress();
        man.run();

    }
}
