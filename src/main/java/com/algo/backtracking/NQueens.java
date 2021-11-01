package com.algo.backtracking;

public class NQueens {
    static int N = 0;

    public static void main(String[] args) {

        int[][] board = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        N = board.length;
        placeNQueens(board);
    }

    private static void placeNQueens(int[][] board) {
        placeNQueensUtil(board, 0);
    }

    private static boolean placeNQueensUtil(int[][] soln, int col) {

        if (col >= N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(soln[i][j] + " ,");
                }
                System.out.println();
            }
            return true;
        } else {
            for (int i = 0; i < N; i++) {
                if (isSafe(i, col, soln)) {
                    soln[i][col] = 1;
                    if (placeNQueensUtil(soln, col + 1))
                        return true;
                }
                soln[i][col] = 0;

            }

        }
        return false;
    }

    // As we are going col by col,  we need
    //       to check only left side for attacking queens
    private static boolean isSafe(int row, int col, int[][] soln) {

        int i, j;

        for (i = 0; i < col; i++) {
            if (soln[row][i] == 1)
                return false;
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (soln[i][j] == 1)
                return false;
        }

        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (soln[i][j] == 1)
                return false;
        }

        return true;
    }
}
