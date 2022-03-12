package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueensPossibility {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line), board[][] = new int[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }

        if (nQueens(board, n)) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not possible");
        }

    }

    public static boolean nQueens(int[][] board, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (isAlreadySet(i, j, board, n)) {
                    continue;
                }
                board[i][j] = 1;
                if (nQueens(board, n - 1)) {
                    return true;
                }
                board[i][j] = 0;
            }
        }
        return false;
    }

    private static boolean isAlreadySet(int i, int j, int[][] board, int n) {
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] == 1) {
                return true;
            }
        }

        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == 1) {
                return true;
            }
        }

        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board.length; l++) {
                if (((k + l == i + j) || (k - l == i - j)) && (board[k][l] == 1)) {
                    return true;
                }
            }
        }

        return false;
    }

}
