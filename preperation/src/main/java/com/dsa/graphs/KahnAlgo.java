package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological sort with indegree and bfs
public class KahnAlgo {

    static int[] kahnAlgo(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];

        // find indegree for all the nodes
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Put all the nodes with indgree as 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] topo = new int[v];
        int i = 0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;

            for (int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) q.offer(neighbour);
            }
        }
        return topo;
    }
}
