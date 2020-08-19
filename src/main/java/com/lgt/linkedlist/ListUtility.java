package com.lgt.linkedlist;


public class ListUtility {
    private Node tail;

    Node createList(int nodeNum) {
        if (nodeNum <= 0) {
            return null;
        }

        Node head = null;
        int val = 0;
        Node node = null;

        while (nodeNum > 0) {

            if (head == null) {
                head = new Node();
                head.val = val;
                node = head;
                tail = head;

            } else {
                node.next = new Node();
                node = node.next;
                node.val = val;
                node.next = null;
                tail = node;
            }

            val++;
            nodeNum--;
        }

        return head;
    }

    public Node createCycleList(int totalNodeNum, int circleNodeNum) {
        if (totalNodeNum < circleNodeNum) {
            return null;
        }

        Node head = createList(totalNodeNum);
        Node temp = head;
        int stepCount = totalNodeNum - circleNodeNum;

        while (stepCount > 0) {
            temp = temp.next;
            stepCount--;
        }

        tail.next = temp;

        return head;
    }

    public void printList(Node head) {
        while (head != null && head.visited == false) {
            System.out.print(head.val + " -> ");
            head.visited = true;
            head = head.next;
        }

        System.out.println("null");
    }
}
