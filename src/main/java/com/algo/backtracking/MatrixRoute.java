package com.algo.backtracking;

public class MatrixRoute {

    static int R = 3;
    static int C = 10;

    static class Pair{
        boolean found;
        int val;

        public Pair(boolean found, int x){
            this.found = found;
            this.val = x;
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
        findLongestPath(mat,0,0,1,7);
    }

    private static void findLongestPath(int[][] mat, int fromI, int fromJ, int toI, int toJ){
        boolean[][] visited = new boolean[R][C];
        Pair p = findLongestPathUtil(mat,fromI,fromJ,toI,toJ,visited);
        if(p.found)
            System.out.println("Found "+p.val);
        else
            System.out.println("Nahh");

    }

    private static Pair findLongestPathUtil(int[][] mat, int fromI, int fromJ, int toI, int toJ, boolean[][] visited) {
        if(fromI == toI && fromJ == toJ)
            return new Pair(true,0);

        if(fromI < 0 || fromI >= R || fromJ < 0 || fromJ >= C || mat[fromI][fromJ] == 0 || visited[fromI][fromJ]){
            return new Pair(false, Integer.MAX_VALUE);
        }

        visited[fromI][fromJ] = true;

        int res = Integer.MIN_VALUE;

        //left from current cell
        Pair p = findLongestPathUtil(mat, fromI-1, fromJ,toI,toJ,visited);
        if(p.found)
            res = Math.max(p.val,res);

        //Right from current cell
        p = findLongestPathUtil(mat,fromI+1, fromJ, toI, toJ,visited);

        if(p.found)
            res = Math.max(p.val,res);

        //Up from current cell
        p = findLongestPathUtil(mat,fromI,fromJ-1,toI,toJ,visited);

        if (p.found)
            res = Math.max(p.val,res);

        //Down from current cell
        p = findLongestPathUtil(mat,fromI,fromJ+1,toI,toJ,visited);

        if (p.found)
            res = Math.max(p.val, res);

        visited[fromI][fromJ] = false;

        if(res != Integer.MIN_VALUE)
            return new Pair(true,res+1);
        else
            return new Pair(false, Integer.MAX_VALUE);
    }
}
