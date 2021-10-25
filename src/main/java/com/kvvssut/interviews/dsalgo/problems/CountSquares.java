package com.kvvssut.interviews.dsalgo.problems;

class CountSquares {

    public static void main(String[] args) {
        System.out.println(new CountSquares().countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
    }

    public int countSquares(int[][] matrix) {
        int sum = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            sum += matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j]));
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

}