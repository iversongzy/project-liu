package com.lgt.thread;

public class InterruptExceptionTest extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 200000; i++) {
                if (this.interrupted()) {
                    System.out.println("I will exit");
                    throw new InterruptedException();
                }
                System.out.println("i=" + i);
            }
            System.out.println("hello, i am back");
        } catch (InterruptedException e) {
            System.out.println("run catch");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            InterruptExceptionTest thread = new InterruptExceptionTest();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
