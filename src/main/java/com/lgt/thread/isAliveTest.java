package com.lgt.chapter1;

public class isAliveTest extends Thread {
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }

    public static void main(String[] args) throws InterruptedException {
        isAliveTest isAliveTest = new isAliveTest();
        System.out.println("begin="+isAliveTest.isAlive());
        isAliveTest.start();
        Thread.sleep(1000);
        System.out.println("end="+isAliveTest.isAlive());
    }
}
