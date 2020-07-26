package com.lgt.datastructure;

public class MyLinkedList {
    private Node head;
    private Node last;
    //链表实际长度
    private int size;


    public void insert(int data, int index) {
        //判断边界条件
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index of input is error!");
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            //头部插入
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {
            //尾部插入
            last.next = insertedNode;
            last = insertedNode;
        } else {
            //中间插入
            Node preNode = get(index - 1);
            insertedNode.next = preNode.next;
            preNode.next = insertedNode;
        }
        size++;
    }

    public Node delete(int index) {
        //判断边界条件
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index of input is error!");
        }
        Node removedNode = null;
        if (index == 0) {
            //删除头结点
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾节点
            Node preNode = get(index - 1);
            removedNode = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            //删除中间节点
            Node preNode = get(index - 1);
            Node nextNode = get(index + 1);
            removedNode = preNode.next;
            preNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    public Node get(int index) {
        //判断边界条件
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index of input is error!");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;

    }

    public void show() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }


    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1, 0);
        myLinkedList.insert(3, 1);
        myLinkedList.insert(4, 2);
        myLinkedList.insert(2, 1);
        myLinkedList.insert(5, 4);
        System.out.println("--------------1------------");
        myLinkedList.show();
        myLinkedList.delete(0);
        myLinkedList.delete(3);
        myLinkedList.delete(1);
        System.out.println("--------------2------------");
        myLinkedList.show();
    }
}


