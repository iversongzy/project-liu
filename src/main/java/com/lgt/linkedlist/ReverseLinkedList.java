package com.lgt.linkedlist;

public class ReverseLinkedList {
    private Node newHead;
    private Node head;

    public ReverseLinkedList(Node head) {
        this.head = head;
    }

    private Node getReverseList(Node node) {
        //边界条件和递归终止条件，判断是否遍历到链表尾部
        if (node == null || node.next == null) {
            newHead = node;
            return node;
        }
        //找到链表尾部，将其反转
        Node tail = getReverseList(node.next);
        tail.next = node;
        node.next = null;
        return node;
    }

    public Node getReverseList() {
        getReverseList(head);
        return newHead;
    }

    public static void main(String[] args) {
        ListUtility newLinkedList = new ListUtility();
        Node head = newLinkedList.createList(10);
        System.out.println("Before:");
        newLinkedList.printList(head);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList(head);
        System.out.println("After:");
        newLinkedList.printList(reverseLinkedList.getReverseList());
    }

}
