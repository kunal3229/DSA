package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {

    public static List<Integer> bfsOfGraph(int v, List<List<Integer>> graph){
        boolean[] visited = new boolean[v];
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for (int neighbour : graph.get(node)){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
        return res;
    }

    public static List<Integer> dfsOfGraph(int v, List<List<Integer>> graph){
        boolean[] visited = new boolean[v];
        List<Integer> res = new ArrayList<>();
        dfs(0, graph, visited, res);
        return res;
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> res) {
        visited[node] = true;
        res.add(node);

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, graph, visited, res);
            }
        }
    }
}
