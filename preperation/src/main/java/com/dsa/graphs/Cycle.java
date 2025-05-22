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

    public boolean hasCycleDirected(int v, List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i=0; i<v; i++){
            if (!visited[i]){
                if (dfsCyclic(i,adj, visited, recStack))return true;
            }
        }
        return false;
    }

    private boolean dfsCyclic(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbour : adj.get(node)){
            if (!visited[neighbour]) {
                if (dfsCyclic(neighbour, adj, visited, recStack)) return true;
            }
            else if(recStack[neighbour]) return true;
        }
        recStack[node] = false;
        return false;
    }

    public boolean cycleDirectedBfs(int v, List<List<Integer>> adj){
        int[] indegree = new int[v];

        for (int i=0; i<v; i++){
            for (int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<v; i++){
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for (int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) q.offer(neighbour);
            }
        }
        return count != v;
    }
}
