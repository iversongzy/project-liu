package com.lgt.datastructures;

public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        array = new int[maxSize];
    }

    private boolean isEmpty(){
        return front == rear;
    }

    private boolean isFull(){
        return rear == maxSize - 1;
    }

    void addQueue(int value) {
        if(isFull()) {
            System.out.println("Queue is saturated and data can't be added!");
            return;
        }
        rear++;
        array[rear] = value;
    }

    int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        front++;
        return array[front];
    }

    void showQueue() {
        if(isEmpty()) {
            System.out.println("This Queue is empty!");
            return;
        }
        for (int i : array) {
            System.out.println(i + " ");
        }
    }

    int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return array[front+1];
    }
}
