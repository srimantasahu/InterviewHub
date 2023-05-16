package com.kvvssut.interviews.problemsolving.advanced;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossibleNQueens {

    public static void main(String[] args) {
        PrintAllPossibleNQueens object = new PrintAllPossibleNQueens();

        List<List<String>> results = object.solveNQueens(4);

        System.out.println(results);
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> solutions = new ArrayList<>();

        solveNQueens(board, n, 0, 0, solutions);

        return solutions;
    }

    private void solveNQueens(int[][] board, int n, int i, int j, List<List<String>> solutions) {

        if (safe(board, n, i, j)) {
            board[i][j] = 1;
            i = i + 1;
            if (i == n) {
                // found a solution
                solutions.add(printBoard(board));
                // resetting previous set val
                board[i-1][j] = 0;
                // proceeding further
                solveNQueens(board, n, i-1, j+1, solutions);
            } else {
                solveNQueens(board, n, i, 0, solutions);
            }
        } else if (j == n) {
            i = i - 1;
            if (i == -1) {
                // process ends here
            } else {
                for (int k = 0; k < n; k++) {
                    if (board[i][k] == 1) {
                        board[i][k] = 0;
                        solveNQueens(board, n, i, k + 1, solutions);
                    }
                }
            }
        } else {
            solveNQueens(board, n, i, j + 1, solutions);
        }

    }

    private boolean safe(int[][] board, int n, int x, int y) {
        if (x >= n || y >= n) {
            return false;
        }

        int idx = x, idy = y;

        // check vertically
        while (idx > 0) {
            if (board[--idx][y] == 1) {
                return false;
            }
        }

        // check left diagonally
        idx = x;
        while (idx > 0 && idy > 0) {
            if (board[--idx][--idy] == 1) {
                return false;
            }
        }

        // check right diagonally
        idx = x;
        idy = y;
        while (idx > 0 && idy < n - 1) {
            if (board[--idx][++idy] == 1) {
                return false;
            }
        }

        return true;
    }


    private List<String> printBoard(int[][] board) {
        List<String> allRows = new ArrayList<>();

        for (int[] row : board) {
            allRows.add(printRow(row));
        }

        return allRows;
    }

    private String printRow(int[] row) {
        StringBuilder res = new StringBuilder();

        for (int j : row) {
            res.append(j == 1 ? 'Q' : '.');
        }

        return res.toString();
    }

}
