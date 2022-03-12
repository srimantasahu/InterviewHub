package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

public class NQueens {

    private static final int boardLength = 8; // No of Queens

    private static final int[][] chessBoard;

    static {
        chessBoard = new int[boardLength][boardLength];

        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                chessBoard[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        final boolean solved = solveNQueens(0);

        if (solved) {
            for (int x = 0; x < boardLength; x++) {
                for (int y = 0; y < boardLength; y++) {
                    System.out.print(String.format("%3d", chessBoard[x][y]));
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("Solution doesn't exist!");
        }
    }

    private static boolean solveNQueens(int col) {

        if (col == boardLength) {
            return true;
        }

        for (int x = 0; x < boardLength; x++) {
            if (isSafe(x, col)) {

                // set current (x,y) coordinates
                chessBoard[x][col] = 1;

                if (solveNQueens(col + 1)) {
                    return true;
                }

                // if solution not found, reset it
                chessBoard[x][col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int row, int col) {

        // check for queen on left side
        for (int y = 0; y < col; y++) {
            if (chessBoard[row][y] == 1) {
                return false;
            }
        }

        // check for queen on upper left diagonal
        for (int x = row - 1, y = col - 1; x >= 0 && y >= 0; x--, y--) {
            if (chessBoard[x][y] == 1) {
                return false;
            }
        }

        // check for queen on lower left diagonal
        for (int x = row + 1, y = col - 1; x < boardLength && y >= 0; x++, y--) {
            if (chessBoard[x][y] == 1) {
                return false;
            }
        }

        return true;
    }

}
