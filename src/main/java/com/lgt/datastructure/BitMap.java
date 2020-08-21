package com.lgt.datastructures;

public class BitMap {
    private long[] words;
    private int size;

    public BitMap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1) + 1)];
    }

    public boolean gitBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("more than bitmap value");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("more than bitmap value");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    private int getWordIndex(int i) {
        return i >> 6;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.gitBit(126));
        System.out.println(bitMap.gitBit(75));
    }
}
