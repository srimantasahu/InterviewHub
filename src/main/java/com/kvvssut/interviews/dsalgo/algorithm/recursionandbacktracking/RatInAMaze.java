package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

public class RatInAMaze {

    final static int mazeLength = 4;

    final static int[][] mazeMatrix = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
    };

    final static int[][] solutionMatrix = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    public static void main(String[] args) {
        final boolean solved = solveRatInAMaze(0, 0);

        if (solved) {
            for (int x = 0; x < mazeLength; x++) {
                for (int y = 0; y < mazeLength; y++) {
                    System.out.print(String.format("%2d", solutionMatrix[x][y]));
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("Solution doesn't exist!");
        }
    }

    private static boolean solveRatInAMaze(int row, int col) {

        // set current (x,y) coordinates
        solutionMatrix[row][col] = 1;

        if ((row == mazeLength - 1) && (col == mazeLength - 1)) {
            return true;
        }

        if ((row + 1 < mazeLength) && mazeMatrix[row + 1][col] == 1) {
            if (solveRatInAMaze(row + 1, col)) {
                return true;
            }
        }

        if ((col + 1 < mazeLength) && mazeMatrix[row][col + 1] == 1) {
            if (solveRatInAMaze(row, col + 1)) {
                return true;
            }
        }

        // if solution not found, reset it
        solutionMatrix[row][col] = 0;

        return false;
    }

}
