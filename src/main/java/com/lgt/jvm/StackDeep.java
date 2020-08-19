package com.lgt.jvm;

public class StackDeep {
    private static int count = 0;
    public static void recursion(){
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try{
            recursion();
        }catch (Throwable throwable) {
            System.out.println("deep of calling = "+count);
        }
    }
}
