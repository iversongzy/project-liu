package com.lgt.thread;

public class InterruptStopTest extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i="+i);
            }
            System.out.println("run begin");
            Thread.sleep(2000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("run catch" + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            InterruptStopTest thread = new InterruptStopTest();
            thread.start();
            thread.interrupt();
            System.out.println("end!");
    }
}
