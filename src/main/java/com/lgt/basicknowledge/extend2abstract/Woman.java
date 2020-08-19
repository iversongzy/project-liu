package com.lgt.basicknowledge.extend2abstract;

public class Woman extends Human{
    public Woman(Builder builder) {
        super(builder);
        swim =new NoSwim();
        clother = new Skirt();
    }
}
