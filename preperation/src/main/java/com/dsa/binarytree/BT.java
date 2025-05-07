package com.dsa.binarytree;

import java.util.*;

public class BT {
    public static void main(String[] args) {

    }
    static TreeNode findSuccessor(TreeNode node, int key){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(node.left!=null)q.offer(node.left);
            if (node.right!=null)q.offer((node.right));
            if(temp.value == key) break;
        }
        return q.peek();
    }

    static List<List<Integer>> zigzagTraversal(TreeNode node){
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        boolean reversed = false;
        q.offer(node);
        while (!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                if (!reversed) {
                    TreeNode temp = q.pollFirst();
                    level.add(temp.value);
                    if (temp.left!= null)q.offerLast(temp.left);
                    if (temp.right!=null)q.offerLast(temp.right);
                } else {
                    TreeNode temp = q.pollLast();
                    level.add(temp.value);
                    if(temp.right != null) q.addFirst(temp.right);
                    if(temp.left != null) q.addFirst(temp.left);
                }
            }
            reversed = !reversed;
            res.add(level);
        }
        return res;
    }
}
