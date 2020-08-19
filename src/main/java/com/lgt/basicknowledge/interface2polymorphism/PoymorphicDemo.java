package com.lgt.basicknowledge.interface2polymorphism;

public class PoymorphicDemo {
    public static void main(String[] args) {
        Dad d = new Kid();
        System.out.println(d.num);
        d.method();
        d.function();//使用变量去调用静态方法，其实相当于用变量类型的类名去调用
    }
}

class Dad {
    int num = 20;

    public void method() {
        System.out.println("我是父类方法");
    }

    public static void function() {
        System.out.println("我是父类静态方法");
    }
}

class Kid extends Dad {
    int num = 10;

    @Override
    public void method() {
        System.out.println("我是子类方法");
    }

    public static void function() {
        System.out.println("我是子类静态方法");
    }
}
