package com.lgt.datastructure.linkedlist;

public class Josepfu {
    // 创建一个first节点,当前没有编号
    private Node first = null;

    public void makeCircleSingleLinkedList(int num) {
        if (num < 1) {
            System.out.println("input value error!");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Node currentNode = null;
        for (int i = 0; i < num; i++) {
            Node node = new Node(i + 1, "", "");
            if (i == 0) {
                first = node;
                // 构成环
                first.next = first;
                //让curNode指向第一个node
                currentNode = first;
            } else {
                currentNode.next = node;
                node.next = first;
                currentNode = node;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("No value!");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Node node = first;
        while (true) {
            System.out.println(node);
            if (first.equals(node.next)) {
                break;
            }
            node = node.next;
        }
    }

    /**
     * @param startNum 表示从第几个数开始数
     * @param countNum 表示数几下
     * @param total    表示最初有几个数
     */
    public void count(int startNum, int countNum, int total) {
        if (first == null || startNum < 1 || startNum > total) {
            System.out.println("input parameter error!");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Node helper = first;
        // 让helper指向最后节点
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }
        //报数前，先让 first 和  helper 移动 k - 1次
        for (int i = 0; i < startNum - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //报数时，让first 和 helper 指针同时的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) {
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //这时first指向的节点，就是要出圈的节点
            System.out.println("out: " + first.num);
            //这时将first指向的节点出圈
            first = first.next;
            helper.next = first;
        }
        System.out.println("last one: " + first.num);
    }


    public static void main(String[] args) {
        Josepfu josepfu = new Josepfu();
        josepfu.makeCircleSingleLinkedList(5);
        josepfu.show();
        josepfu.count(1, 2, 5);
    }
}
