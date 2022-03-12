package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

public class KnightsTour {

    final static int boardLength = 8;
    final static int[][] board = new int[boardLength][boardLength];

    final static int possibleMoves = 8;
    final static int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    final static int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    static {
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                board[x][y] = -1;
            }
        }
    }

    public static void main(String[] args) {
        final boolean solved = solveKnightsTour(0, 0, 0);

        if (solved) {
            for (int x = 0; x < boardLength; x++) {
                for (int y = 0; y < boardLength; y++) {
                    System.out.print(String.format("%3d", board[x][y]));
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("Solution doesn't exist!");
        }
    }

    private static boolean solveKnightsTour(int moveIndex, int row, int col) {

        // set move index to the current coordinates
        board[row][col] = moveIndex;

        if (moveIndex == boardLength * boardLength - 1) {
            return true;
        } else {
            for (int i = 0; i < possibleMoves; i++) {

                if (((row + moveX[i] >= 0 && row + moveX[i] < boardLength)
                        && (col + moveY[i] >= 0 && col + moveY[i] < boardLength)
                        && (board[row + moveX[i]][col + moveY[i]] == -1))) {

                    if (solveKnightsTour(moveIndex + 1, row + moveX[i], col + moveY[i])) {
                        return true;
                    }
                }
            }
        }

        // if solution not found, revert back
        board[row][col] = -1;

        return false;
    }

}
