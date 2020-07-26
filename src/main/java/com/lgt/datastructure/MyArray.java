package com.lgt.datastructure;

public class MyArray {
    private int size;
    private int[] arr;

    public MyArray(int capacity) {
        this.arr = new int[capacity];
        size = 0;
    }

    public void insert(int element, int index) {
        //判断边界条件
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index of input is error!");
        }
        //如果数组已满就对数组进行扩容
        if (size >= arr.length) {
            resize();
        }
        //将要插入位置后面的元素向后移，尾部插入不进入循环
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        //插入元素
        arr[index] = element;
        size++;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index of input is error!");
        }
        //在移动之前先保存被删的数据
        int deletedElement = arr[index];
        //将被删位置以后的数据都向前移一位
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return deletedElement;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MyArray myArrays = new MyArray(3);
        myArrays.insert(3, 0);
        myArrays.insert(2, 1);
        myArrays.insert(1, 2);
        myArrays.insert(4, 1);
        myArrays.delete(1);
        myArrays.show();
    }
}
