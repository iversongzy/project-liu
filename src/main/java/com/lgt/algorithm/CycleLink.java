package com.lgt.algorithm;

public class CycleLink {

    public static boolean isCycle(Node head) {
        Node n1 = head;
        Node n2 = head;
        while (n1 != null && n1.next != null) {
            n1 = n1.next.next;
            n2 = n2.next;
            if(n1 == n2) {
                return true;
            }
        }
        return false;
    }

    private static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
    }
}
