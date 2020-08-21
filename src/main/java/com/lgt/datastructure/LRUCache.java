package com.lgt.datastructures;

import java.util.HashMap;

public class LRUCache {
    private Node head;
    private Node end;
    //缓存上限
    private int limit;
    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() > limit) {
                String oldNode = removeNode(head);
                hashMap.remove(oldNode);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
    }

    //刷新被访问的节点位置
    private void refreshNode(Node node) {
        if (node == end) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private String removeNode(Node node) {
        if (node == head && node == end) {
            //删除唯一节点
            head = null;
            end = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    //尾部插入节点
    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    class Node {
        public String key;
        public String value;
        public Node pre;
        public Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001", "User1");
        lruCache.put("002", "User1");
        lruCache.put("003", "User1");
        lruCache.put("004", "User1");
        lruCache.put("005", "User1");
        lruCache.get("002");
        lruCache.put("004", "User2 Update");
        lruCache.put("006", "User6");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}
