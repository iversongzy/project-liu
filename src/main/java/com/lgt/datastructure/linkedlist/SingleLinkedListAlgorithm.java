package com.lgt.datastructure.linkedlist;

import java.util.Stack;

public class SingleLinkedListAlgorithm {

    /**
     * 获取单链表节点的个数（判断是否带头结点）
     */
    public static int getLength(Node head){
        if(head.next == null) {
            return 0;
        }
        int len = 0;
        Node temp = head.next;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static Node findLastKIndexNode(Node head, int index) {
        if (head.next == null) {
            System.out.println("No find answer.");
            return null;
        }
        int len = getLength(head);
        if(len<index||len<=0) {
            return null;
        }
        Node temp = head.next;
        for (int i = 0; i < len-index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void reverseList(Node head) {
        if (head.next == null || head.next.next == null) {
            System.out.println("No reverse");
            return;
        }
        Node temp = head.next;
        Node next = null;
        Node reverseHead = new Node(0, "", "");
        while(temp!=null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    public static void reversePrintLinkedList(Node head) {
        if(head.next == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node temp = head.next;
        while (temp != null) {
            nodeStack.push(temp);
            temp = temp.next;
        }
        while (nodeStack.size()>0) {
            System.out.println(nodeStack.pop());
        }
    }

    public static void main(String[] args) {
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero5 = new Node(4, "入云龙", "公孙胜");

        NewSingleLinkList newSingleLinkList = new NewSingleLinkList();
        newSingleLinkList.add(hero1);
        newSingleLinkList.add(hero3);
        newSingleLinkList.add(hero2);
        newSingleLinkList.add(hero5);

        System.out.println("origin");
        newSingleLinkList.show();

        System.out.println("reverse");
        reversePrintLinkedList(newSingleLinkList.getHead());

        System.out.println("lastIndex:");
        System.out.println(findLastKIndexNode(newSingleLinkList.getHead(), 2));

        newSingleLinkList.show();
        System.out.println("reverse List");
        reverseList(newSingleLinkList.getHead());
        newSingleLinkList.show();
    }
}
