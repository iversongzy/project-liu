package com.lgt.datastructure;

import java.util.Stack;

public class MyQueue2 {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public void enQueue(int element) {
        stackA.push(element);
    }

    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        System.out.println(myQueue.deQueue());
        myQueue.enQueue(4);
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
    }
}
