package com.lgt.basicknowledge.extend2abstract;

public class Swim implements SwimBehavior {
    @Override
    public void swim(){
        System.out.println("I can swim!");
    }
}
