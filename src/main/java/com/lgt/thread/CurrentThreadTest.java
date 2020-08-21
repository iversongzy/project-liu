package com.lgt.thread;

public class CurrentThreadTest extends Thread {
    public CurrentThreadTest() {
        System.out.println("Constructor(currentThread): " + Thread.currentThread().getName());
        System.out.println("Constructor(this): " + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run(currentThread): " + Thread.currentThread().getName());
        System.out.println("run(this): " + this.getName());
    }

    public static void main(String[] args) {
        CurrentThreadTest currentThreadTest = new CurrentThreadTest();
        Thread thread = new Thread(currentThreadTest);
        thread.setName("A");
        thread.start();
        //thread.run();
    }
}
