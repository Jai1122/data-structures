package com.algo.backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] arr = new int[9][9];
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        if (fillSudoKuUtil(board,board.length)){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    private static boolean fillSudoKuUtil(int[][] board, int n) {

        boolean isEmpty = true;
        int row = -1;
        int col = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
                break;
        }
        if (isEmpty)
            return true;

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (fillSudoKuUtil(board, n)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {

        //Row clash
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return false;
        }

        //Column Clash
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }

        //Box clash
        int sqrt = (int) Math.sqrt(board.length);
        int rowBoxStart = row - (row % sqrt);
        int colBoxStart = col - (col % sqrt);

        for (int i = rowBoxStart; i < rowBoxStart + sqrt; i++) {
            for (int j = colBoxStart; j < colBoxStart + sqrt; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
