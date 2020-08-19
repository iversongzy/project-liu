package com.lgt.basicknowledge.interface2polymorphism;

public abstract class Player extends Person {
    Player(String name, int age, String gender){
        super(name, age, gender);
    }
    abstract void train();
}
