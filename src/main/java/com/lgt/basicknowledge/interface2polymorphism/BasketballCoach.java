package com.lgt.basicknowledge.interface2polymorphism;

public class BasketballCoach extends Coach implements SpeakEnglish {

    @Override
    void teach() {
        System.out.println("They teach palyers of basketball.");
    }

    @Override
    public void talkWithEnglish() {
        System.out.println("They can speak English too!");
    }
}
