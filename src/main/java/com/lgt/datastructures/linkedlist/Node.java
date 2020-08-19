package com.lgt.datastructures.linkedlist;

class Node {
    int num;
    String name;
    String nickname;
    Node next;

    public Node(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
