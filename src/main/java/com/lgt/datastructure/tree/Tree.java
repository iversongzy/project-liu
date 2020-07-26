package com.lgt.datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public static void preOrderTraveralWithStack(TreeNode node) {
        TreeNode treeNode = node;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.value);
        inOrderTraveral(node.rightChild);
    }

    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(node.value);
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if(node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }
    private static class TreeNode {
        int value;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
        TreeNode binaryTree = createBinaryTree(integers);
        System.out.println("preOrder");
        preOrderTraveral(binaryTree);
        System.out.println("preOrderWithStack");
        preOrderTraveralWithStack(binaryTree);
        System.out.println("inOrder");
        inOrderTraveral(binaryTree);
        System.out.println("postOrder");
        postOrderTraveral(binaryTree);
        System.out.println("levelOrder");
        levelOrderTraversal(binaryTree);
    }
}
