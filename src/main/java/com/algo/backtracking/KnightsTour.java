package com.algo.backtracking;

public class KnightsTour {

    static int[] xPath = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] yPath = { 1, 2, 2, 1, -1, -2, -2, -1 };


    public static void main(String[] args) {
        int N = 8;
        findKnightsTour(N);
    }

    private static void findKnightsTour(int N) {
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = 0;
            }
        }
        visited[0][0]   =   1;
        findKnightsTourUtil(N, visited, 0, 0, 1);
    }

    private static boolean findKnightsTourUtil(int N, int[][] visited, int row, int col, int move) {

        if (move == N * N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(visited[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("All Done");
            return true;
        } else {
            for (int i = 0; i < N; i++) {
                int newRow = row + xPath[i];
                int newCol = col + yPath[i];
                if (isValid(newRow, newCol, visited)) {
                    move++;
                    visited[newRow][newCol] = move;
                    if (findKnightsTourUtil(N, visited, newRow, newCol, move)) {
                        return true;
                    }
                    move--;
                    visited[newRow][newCol] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isValid(int x, int y, int[][] visited) {
        return ((x >= 0) && (x < 8) && (y >= 0) && (y < 8) && visited[x][y] == 0);
    }
}
