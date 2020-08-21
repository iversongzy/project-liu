package com.lgt.datastructure.linkedlist;

public class NewNode {
    int value;
    String name;
    NewNode pre;
    NewNode next;

    public NewNode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewNode{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
