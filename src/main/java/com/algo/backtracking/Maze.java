package com.algo.backtracking;

public class Maze {
    public static void main(String[] args) {
        int[][] maze = {
                { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
                { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
                { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
                { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
                { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
                { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
                { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
                { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
                { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
        };
        printPath(maze, 0, 0, "");
    }

    private static void printPath(int[][] maze, int i, int j, String ans) {
        // If we reach the center cell
        if (i == maze.length/2 && j==maze.length/2){

            // Make the final answer, Print the
            // final answer and Return
            ans += "("+i+", "+j+") -> MID";
            System.out.println(ans);
            return;
        }

        // If the element at the current position
        // in maze is 0, simply Return as it has
        // been visited before.
        if (maze[i][j]==0){
            return;
        }

        // If element is non-zero, then note
        // the element in variable 'k'
        int k = maze[i][j];

        // Mark the cell visited by making the
        // element 0. Don't worry, the element
        // is safe in 'k'
        maze[i][j]=0;

        // Make recursive calls in all 4
        // directions pro-actively i.e. if the next
        // cell lies in maze or not. Right call
        if (j+k<maze.length){
            printPath(maze, i, j+k, ans+"("+i+", "+j+") -> ");
        }

        // down call
        if (i+k<maze.length){
            printPath(maze, i+k, j, ans+"("+i+", "+j+") -> ");
        }

        // left call
        if (j-k>0){
            printPath(maze, i, j-k, ans+"("+i+", "+j+") -> ");
        }

        // up call
        if (i-k>0){
            printPath(maze, i-k, j, ans+"("+i+", "+j+") -> ");
        }

        // Unmark the visited cell by substituting
        // its original value from 'k'
        maze[i][j] = k;
    }
}
