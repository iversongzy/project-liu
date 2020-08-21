package com.lgt.datastructure;

public class ArrayPermutation {
    private int[] array;
    private int[] permutation;

    public ArrayPermutation(int[] array, int[] permutation) {
        this.array = array;
        this.permutation = permutation;
    }

    public void doPermutation() {
        for (int i = 0; i < array.length; i++) {
            int change = relocate(i);
            int temp = array[change];
            makeShift(array,i,change);
            array[i] = temp;
        }
    }

    private int relocate(int index) {
        int change = permutation[index];
        int shift = 0;
        for (int i = 0; i < index; i++) {
            if(permutation[i]>change) {
                shift++;
            }
        }
        return change+shift;
    }

    private void makeShift(int[] array,int start, int end) {
        for (int i = end; i > start; i--) {
            array[i] = array[i-1];
        }
    }

    public int[] getPermutation() {
        return array;
    }

    public static void main(String[] args) {
        ArrayPermutation  ap = new ArrayPermutation(new int[]{1,2,3,4,5,6}, new int[] {3,1,5,4,0,2});
        ap.doPermutation();
        int[] result = ap.getPermutation();
        System.out.println("after permutation is: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+ " ");
        }
    }
}
