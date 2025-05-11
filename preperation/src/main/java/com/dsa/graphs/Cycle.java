package com.dsa.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cycle {
    public boolean unDirectedCycleDfs(int v, List<List<Integer>> adj){
        boolean[] visited = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]){
                if (dfsUndirected(i, -1, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsUndirected(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if (dfsUndirected(neighbour, node, visited, adj)) return true;
            }
            else if(neighbour != parent)return true;
        }
        return false;
    }

    public boolean unDirectedCycleBfs(int v, List<List<Integer>> adj){
        boolean[] visited = new boolean[v];

        for (int i=0; i<v; i++){
            if(!visited[i]){
                if (bfsUndirected(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean bfsUndirected(int node, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node, -1});

        visited[node] = true;

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int curr = pair[0];
            int parent = pair[1];

            for (int neighbour : adj.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.offer(new int[]{neighbour, parent});
                }
                else if(neighbour != parent) return true; //cycle found
            }
        }
        return false;
    }
}
