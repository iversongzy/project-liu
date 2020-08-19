package com.lgt.linkedlist;

public class CircleLinkedList {
    private Node slow;
    private Node fast;
    private int stepCount;
    private int visitCount;
    int lenOfFirstVisit = 0;
    int lenOfSecondVisit = 0;

    public int getCircleLength(Node node) {
        slow = node;
        fast = node;
        stepCount = 0;
        visitCount = 0;
        do {
            if (!getOneStep() || !getTwoStep()) {
                break;
            }
            stepCount++;
            if (slow == fast) {
                visitCount++;
                if (visitCount == 1) {
                    lenOfFirstVisit = stepCount;
                }
                if (visitCount == 2) {
                    lenOfSecondVisit = stepCount;
                }
            }
        }while (visitCount < 2);
        return lenOfSecondVisit - lenOfFirstVisit;
    }

    private boolean getTwoStep() {
        if (fast == null || fast.next == null || fast.next.next == null) {
            return false;
        }
        fast = fast.next.next;
        return true;
    }

    private boolean getOneStep() {
        if (slow == null || slow.next == null) {
            return false;
        }
        slow = slow.next;
        return true;
    }

    public static void main(String[] args) {
        CircleLinkedList linkedList = new CircleLinkedList();
        ListUtility util = new ListUtility();

        Node head = util.createList(10);
        util.printList(head);
        int circleLen = linkedList.getCircleLength(head);
        System.out.println("length of list circle is: " + circleLen);
       /* head = util.createCycleList(10, 6);
        util.printList(head);
        circleLen =linkedList.getCircleLength(head);
        System.out.println("length of list circle is: " + circleLen);*/


    }

}
