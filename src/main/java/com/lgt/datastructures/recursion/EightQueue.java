package com.lgt.datastructures.recursion;

public class EightQueue {
    //表示共有多少个皇后
    private int max = 8;
    //保存皇后的位置
    private int[] array = new int[max];

    private static int count = 0;
    private static int judgeCount = 0;

    /**
     * 放置第n个皇后
     *
     * @param n n个皇后
     */

    private void check(int n) {
        if (n == max) {
            show();
            return;
        }
        //依次放入，判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                //不冲突就放下一个皇后
                check(n + 1);
            }
            //如果冲突，继续执行array[n] = i;，后移直到找到这一行中不冲突的位置
        }
    }

    /**
     * 当放置第n个皇后时，检测与之前是否有冲突
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        //判断第n个皇后是否和n-1个皇后在同一列；判断是否在一个斜线；判断是否在同一行
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void show() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount);
    }
}
