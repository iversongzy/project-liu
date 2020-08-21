package com.lgt.chapter1;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("myThread");
    }

   /* public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }*/
}
