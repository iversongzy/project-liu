package com.lgt.basicknowledge.interface2polymorphism;

public class BasketballPlayer extends Player implements SpeakEnglish {
    BasketballPlayer(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    void train() {
        System.out.println("They play basketball everyday!");
    }

    @Override
    public void talkWithEnglish() {
        System.out.println("They can speak English!");
    }
}
