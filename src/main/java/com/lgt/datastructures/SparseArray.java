package com.lgt.datastructures;

public class SparseArray {
    private int[][] originArray2SparseArray(int[][] originArray) {
        int[][] sparseArray = new int[3][3];
        int count = 1;
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[i].length; j++) {
                if (originArray[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originArray[i][j];
                    count++;
                }
            }
        }
        sparseArray[0][0] = originArray.length;
        sparseArray[0][1] = originArray[0].length;
        sparseArray[0][2] = count;
        return sparseArray;
    }

    private int[][] sparseArray2OriginArray(int[][] sparseArray) {
        int[][] originArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            originArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return originArray;
    }

    private void showOriginArray(int[][] array) {
        for (int[] row : array) {
            for (int column : row) {
                System.out.format("%d\t", column);
            }
            System.out.println();
        }
    }

    private void showSparseArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.format("%d\t%d\t%d\t\n", array[i][0], array[i][1], array[i][2]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        SparseArray sparseArray = new SparseArray();
        int[][] sparseArray1 = sparseArray.originArray2SparseArray(chessArr1);
        sparseArray.showOriginArray(chessArr1);
        sparseArray.showSparseArray(sparseArray1);
        sparseArray.showOriginArray(sparseArray.sparseArray2OriginArray(sparseArray1));
    }
}
