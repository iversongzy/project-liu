package com.lgt.thread;

public class InterruptTest extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 170000; i++) {
            System.out.println("i=" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
      /*  Thread.currentThread().interrupt();
        System.out.println("isInterrupt1: "+ Thread.interrupted());
        System.out.println("isInterrupt2: "+ Thread.interrupted());*/
        InterruptTest thread = new InterruptTest();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("isInterrupt1: "+ thread.isInterrupted());
        System.out.println("isInterrupt2: "+ thread.isInterrupted());
        System.out.println("end!");

    }
}
