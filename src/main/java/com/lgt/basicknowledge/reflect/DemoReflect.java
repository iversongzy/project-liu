package com.lgt.basicknowledge.reflect;

import com.lgt.basicknowledge.extend2abstract.Man;

import java.lang.reflect.Constructor;

public class DemoReflect {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.lgt.basicknowledge.extend2abstract.Man");
        /*Man man = (Man) clazz.newInstance();
        System.out.println(man);*/
        Constructor constructor = clazz.getConstructor(Man.Builder.class);
        Man man = (Man) constructor.newInstance(new Man.Builder());
        System.out.println(man);
    }
}
