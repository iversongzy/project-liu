package com.lgt.datastructure.linkedlist;

public class NewSingleLinkList {
    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = node;
    }

    public void addByOrder(Node node) {
        Node temp = head;
        // flag标志添加的编号是否存在
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
            if (temp.next.num > node.num) {
                break;
            } else if (temp.next.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("Duplicate num!");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void del(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num == node.num) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("No Find!");
        }
    }

    public void update(Node node) {
        if (head.next == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            //遍历完链表
            if (temp == null) {
                break;
            }
            if (temp.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.println("No Find!");
        }
    }

    public void show() {
        Node temp = head.next;
        if (temp == null) {
            System.out.println("list is empty");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero4 = new Node(4, "林冲", "豹子头");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero5 = new Node(4, "入云龙", "公孙胜");

        //创建要给链表
        NewSingleLinkList singleLinkedList = new NewSingleLinkList();


        //加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.update(hero5);
        singleLinkedList.del(hero1);
        singleLinkedList.show();

    }
}

