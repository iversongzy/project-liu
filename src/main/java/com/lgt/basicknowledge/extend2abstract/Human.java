package com.lgt.basicknowledge.extend2abstract;

public class Human {
    int age;
    private final String name;
    private final String gender;
    Clother clother;
    SwimBehavior swim;

    public void setClother(Clother clother) {
        this.clother = clother;
    }

    public void setSwim(SwimBehavior swim) {
        this.swim = swim;
    }

    public Human(Builder builder) {
        age = builder.age;
        name = builder.name;
        gender = builder.gender;
    }

    public void run() {
        System.out.println("People can run!");
    }

    public void performSwim() {
        swim.swim();
    }

    public void performDress() {
        clother.getDressed();
    }

    public static class Builder {
        private int age;
        private String name;
        private String gender;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }
}
