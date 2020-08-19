package com.lgt.basicknowledge.extend2abstract;

public class Man extends Human {
    public Man(Builder builder) {
        super(builder);
        clother = new Shirt();
        swim = new Swim();
    }

}
