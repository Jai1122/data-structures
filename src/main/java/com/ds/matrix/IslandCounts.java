package com.ds.matrix;

public class IslandCounts {

    private static int countIslands(int[][] matrix){

        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]){
                    count++;
                    checkNeighbours(matrix,i,j,visited);
                }
            }
        }

        return count;
    }


    private static boolean[][] checkNeighbours(int[][] mat, int i, int j, boolean[][] visited){

        int[] rowsToCheck = new int[] {-1,-1,-1,0,0,1,1,1};
        int[] colsToCheck = new int[] {-1,0,1,-1,1,-1,0,1};

        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            if(isSafe(mat, i+rowsToCheck[k], j+colsToCheck[k],visited))
                checkNeighbours(mat,i+rowsToCheck[k],j+colsToCheck[k],visited);
        }
        return visited;
    }

    private static boolean isSafe(int[][] mat, int i, int j, boolean[][] visited){
        return ((i>=0) && (i< mat.length) && (j>=0) && (j< mat.length)
            && (!visited[i][j]) && mat[i][j] == 1);
    }

    public static void main(String[] args) {
        int mat[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println(countIslands(mat));
    }
}
