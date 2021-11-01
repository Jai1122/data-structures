package com.ds.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {

    static class QItem{
        int distance;
        int row;
        int col;

        public QItem(int dist, int row, int col){
            this.distance = dist;
            this.row = row;
            this.col = col;
        }
    }

    private static int calculateMinDistance(char[][] mat){
        QItem sourceItem = new QItem(0,0,0);

        firstloop:
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j] == 's'){
                    sourceItem.row = i;
                    sourceItem.col = j;
                    break firstloop;
                }
            }
        }

        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(0, sourceItem.row ,sourceItem.col));
        boolean[][] visited = new boolean[mat.length][mat.length];
        visited[sourceItem.row][sourceItem.col] = true;

        while(!queue.isEmpty()){
            QItem temp = queue.poll();
            if(mat[temp.row][temp.col] == 'd'){
                return temp.distance;
            }

            //up
            if(isValid(mat,temp.row-1,temp.col,visited)){
                queue.add(new QItem(temp.distance+1, temp.row-1, temp.col));
                visited[temp.row-1][temp.col] = true;
            }

            //left
            if(isValid(mat,temp.row,temp.col-1,visited)){
                queue.add(new QItem(temp.distance+1, temp.row,temp.col-1));
                visited[temp.row][temp.col-1] = true;
            }

            //right
            if(isValid(mat,temp.row, temp.col+1,visited)){
                queue.add(new QItem(temp.distance+1, temp.row,temp.col+1));
                visited[temp.row][temp.col+1] = true;
            }
            //down
            if(isValid(mat,temp.row+1,temp.col,visited)){
                queue.add(new QItem(temp.distance+1, temp.row+1,temp.col));
                visited[temp.row+1][temp.col] = true;
            }
        }
        return -1;
    }

    private static boolean isValid(char[][] mat, int i, int j, boolean[][] visited){
        return ((i>=0) && (i<mat.length) && (j>=0) && (j<mat.length)
                && !visited[i][j] && mat[i][j]!='0');
    }

    public static void main(String[] args) {
        char[][] grid = { { '0', '*', '0', 's' },
                { '*', '0', '*', '*' },
                { '0', '*', '*', '*' },
                { 'd', '*', '*', '*' } };
        System.out.println(calculateMinDistance(grid));

    }
}
