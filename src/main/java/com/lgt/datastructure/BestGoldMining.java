package com.lgt.datastructures;

public class BestGoldMining {
    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println("The Best Mining is :" + getBestGoldMining(w, g.length, p, g));
        System.out.println("The Best Mining is :" + getBestGoldMining1(w, p, g));
        System.out.println("The Best Mining is :" + getBestGoldMining2(w, p, g));
    }

    private static int getBestGoldMining2(int w, int[] p, int[] g) {
        int[] resultTable = new int[w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    resultTable[j] = Math.max(resultTable[j], resultTable[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return resultTable[w];
    }

    private static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        //w工人数量  n可选金矿数量
        if (w == 0 || n == 0) {
            return 0;
        }
        //p金矿开采所需工人数
        if (w < p[n - 1]) {
            return getBestGoldMining(w, n - 1, p, g);
        }
        //金矿储量
        return Math.max(getBestGoldMining(w, n - 1, p, g), getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1]);
    }

    private static int getBestGoldMining1(int w, int[] p, int[] g) {
        int[][] resultTable = new int[g.length + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] = Math.max(resultTable[i - 1][j], resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return resultTable[g.length][w];
    }

}
