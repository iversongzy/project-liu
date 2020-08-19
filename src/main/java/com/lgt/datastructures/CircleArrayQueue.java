package com.lgt.datastructures;

import java.util.Scanner;

public class CircleArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] array;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("This Queue is full.");
            return;
        }
        array[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int temp = array[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.format("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }

    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front];
    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArrayQueue queue = new CircleArrayQueue(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}
