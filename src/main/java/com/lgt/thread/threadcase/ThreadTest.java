package com.lgt.thread.threadcase;

public class ThreadTest {
    public static void main(String[] args) {
        //method1();
        method2();

    }

    private static void method2() {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.setName("t3");
        thread.start();
        MyThread2 myThread4 = new MyThread2();
        Thread thread1 = new Thread(myThread4);
        thread1.setName("t4");
        thread1.start();
    }

    private static void method1() {
        MyThread myThread = new MyThread();
        myThread.setName("t1");
        myThread.start();
        MyThread myThread2 = new MyThread();
        myThread2.setName("t2");
        myThread2.start();
    }
}
