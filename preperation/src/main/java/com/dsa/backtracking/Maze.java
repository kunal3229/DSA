package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
//        System.out.println(count(3, 3));
//        path(3, 3, "");
//        System.out.println(pathList("", 3, 3));
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
//        pathRestrictions(maze, "", 0, 0);
//        pathAll(maze, "", 0, 0);
        allPath(maze, "", path, 0, 0, 0);
    }
    static int count(int r, int c){
        if (r == 1 || c == 1) return 1;
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }
    static void path(int r, int c, String path){
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if(r > 1) path(r-1, c, path+'D');
        if (c > 1)path(r, c-1, path+'R');
    }
    static ArrayList<String> pathList(String p, int r, int c){
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> res = new ArrayList<>();
        if(r > 1) res.addAll(pathList(p + 'D', r-1, c ));
        if(c > 1) res.addAll(pathList(p + 'R', r, c-1));

        return res;
    }
    static ArrayList<String> pathDiagonal(String p, int r, int c){
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        if (r > 1 && c > 1)res.addAll(pathDiagonal(p+'O', r-1, c-1));
        if(r > 1) res.addAll(pathDiagonal(p + 'D', r-1, c ));
        if(c > 1) res.addAll(pathDiagonal(p + 'R', r, c-1));

        return res;
    }
    static void pathRestrictions(boolean[][] maze, String p, int r, int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) return;
        if(r < maze.length-1) pathRestrictions(maze, p+'D', r+1, c);
        if(c < maze[0].length-1) pathRestrictions(maze, p+'R', r, c+1);
    }
    static void pathAll(boolean[][] maze, String p, int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c])return;
        maze[r][c] = false;

        if (r < maze.length-1) pathAll(maze, p+'D', r + 1, c);
        if (c < maze[0].length-1) pathAll(maze, p+'R', r, c + 1);
        if (r > 0) pathAll(maze, p+'U', r-1, c);
        if (c > 0) pathAll(maze, p+'L', r, c-1);

        maze[r][c] = true;
    }
    static void allPath(boolean[][] maze, String p, int[][] path, int step, int r, int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c])return;

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length-1) allPath(maze, p+'D', path, step+1, r + 1, c);
        if (c < maze[0].length-1) allPath(maze, p+'R',path, step+1, r, c + 1);
        if (r > 0) allPath(maze, p+'U',path, step+1, r-1, c);
        if (c > 0) allPath(maze, p+'L',path, step+1, r, c-1);

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
