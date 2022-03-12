package com.kvvssut.interviews.dsalgo.problems;

class CheckStraightLine {

    public static void main(String[] args) {
        System.out.println(new CheckStraightLine().checkStraightLine(new int[][]{{1, 3}, {4, 7}, {-2, -1}}));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        float slope = (coordinates[1][1] - coordinates[0][1]) / (float) (coordinates[1][0] - coordinates[0][0]);

        for (int i = 1; i < coordinates.length - 1; i++) {
            if ((coordinates[i + 1][1] - coordinates[i][1]) / (float) (coordinates[i + 1][0] - coordinates[i][0]) != slope) {
                return false;
            }
        }

        return true;
    }
}