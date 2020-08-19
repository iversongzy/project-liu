package com.lgt.basicknowledge.interface2polymorphism;

public class FootballPlayer extends Player {
    FootballPlayer(String name, int age, String gender){
        super(name, age, gender);
    }
    @Override
    void train() {
        System.out.println("They play football everyday!");
    }
}
