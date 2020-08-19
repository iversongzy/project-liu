package com.lgt.jvm;

public class SynchronizedCase extends Thread {
    private int count = 5;
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("Thread "+ currentThread().getName()+", result: "+count);
    }

    public static void main(String[] args) {
        SynchronizedCase mythred = new SynchronizedCase();
        Thread thread1 = new Thread(mythred, "a");
        Thread thread2 = new Thread(mythred, "b");
        Thread thread3 = new Thread(mythred, "c");
        Thread thread4 = new Thread(mythred, "d");
        Thread thread5 = new Thread(mythred, "e");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}


