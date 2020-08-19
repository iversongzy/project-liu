package com.lgt.datastructures.linkedlist;

public class DoubleLinkedList {

    private NewNode head = new NewNode(0, "");

    public NewNode getHead() {
        return head;
    }

    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("This Linked List is empty!");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        NewNode temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 后移
            temp = temp.next;
        }
    }

    public void add(NewNode node) {
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        NewNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = node;
        node.pre = temp;
    }

    public void update(NewNode node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("This Linked List is empty!");
            return;
        }
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        NewNode temp = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.value == node.value) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = node.name;
        } else {
            System.out.println("No node to update was found");
        }
    }

    public void del(NewNode node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("This Linked List is empty!");
            return;
        }
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        NewNode temp = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.value == node.value) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = node.pre;
            }
        } else {
            System.out.println("No node to delete was found");
        }
    }

    public static void main(String[] args) {
        NewNode node0 = new NewNode(0, "liu");
        NewNode node1 = new NewNode(1, "liu");
        NewNode node2 = new NewNode(2, "liu");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node0);
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.list();
        System.out.println("----------------------------------");
        NewNode node3 = new NewNode(1, "guo");
        NewNode node4 = new NewNode(2, "tai");
        doubleLinkedList.update(node3);
        doubleLinkedList.update(node4);
        doubleLinkedList.list();
        System.out.println("----------------------------------");
        doubleLinkedList.del(node0);
        doubleLinkedList.list();
    }
}
