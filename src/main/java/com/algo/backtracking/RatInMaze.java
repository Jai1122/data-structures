package com.algo.backtracking;

public class RatInMaze {


    static int[] xPath = {1, 0, -1, 0};
    static int[] yPath = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        int N = maze.length;
        solveMaze(N, maze);
    }

    private static void solveMaze(int N, int[][] maze) {
        int[][] soln = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                soln[i][j] = 0;
            }
        }

        soln[0][0] = 1;
        solveMazeUtil(0,0, maze,soln,N);
    }

    private static boolean solveMazeUtil(int row, int col, int[][] maze, int[][] soln, int N) {

        if(row == N-1 && col == N-1 && maze[row][col] == 1 && soln[row][col] == 1){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(soln[i][j]+", ");
                }
                System.out.println();
            }
            return true;
        }else {
            for (int i = 0; i < xPath.length; i++) {
                int nextX   =   row + xPath[i];
                int nextY   =   col + yPath[i];
                if(isValid(nextX, nextY, N, soln, maze)){
                    System.out.println("Processing "+nextX+", "+nextY);
                    soln[nextX][nextY] = 1;
                    if(solveMazeUtil(nextX,nextY, maze, soln,N)){
                        return true;
                    }
                    soln[nextX][nextY] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int N, int[][] soln, int[][] maze){
        return ((x >= 0) && (x < N) && (y >= 0) && (y < N) && soln[x][y] == 0 && maze[x][y] == 1);
    }
}
