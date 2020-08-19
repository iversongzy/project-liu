package com.lgt.basicknowledge.interface2polymorphism;

class Person {
    String name;
    int age;
    String gender;

    Person() {
    }

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

   /* public Person getNewInstance() {
        return new Person();
    }

    public Person getNewInstanceWithInfo(String name, int age, String gender) {
        return new Person(name, age, gender);
    }*/

    void eat() {
        System.out.println("People can eat!");
    }

    void sleep() {
        System.out.println("People can sleep!");
    }
}
