package com.lgt.datastructure;

public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        //队列满：(队尾下标+1)%数组长度=队头下标
        if ((rear + 1) % array.length == front) {
            throw new Exception("queue is full!");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("Queue is empty!");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public void show() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(4);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        //队尾指向的位置永远空出一位，所以队列最大容量比数组小1。
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(5);
        myQueue.show();


    }
}
