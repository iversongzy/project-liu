package com.lgt.chapter1;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*MyThread myThread = new MyThread();
        myThread.start();
        //Thread.sleep(300000);
        System.out.println("end!");*/
        /*Runnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("end");*/
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"="+thread.getId());
    }
}
