package com.lgt.basicknowledge.extend2abstract;

public class NoSwim implements SwimBehavior{
    @Override
    public void swim() {
        System.out.println("I can't swim!");
    }
}
