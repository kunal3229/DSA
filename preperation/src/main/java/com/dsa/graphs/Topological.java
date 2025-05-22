package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Topological {

    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<v; i++){
            if (vis[i] == 0){
                dfsTopo(i, vis, stack, adj);
            }
        }

        int[] ans = new int[v];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.peek();
            stack.pop();
        }
        return ans;
    }

    private static void dfsTopo(int node, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int neighbour : adj.get(node)){
            if (vis[neighbour] == 0){
                dfsTopo(neighbour, vis, stack, adj);
            }
        }
        stack.push(node);
    }
}
