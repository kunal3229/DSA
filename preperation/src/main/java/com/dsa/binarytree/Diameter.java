package com.dsa.binarytree;

public class Diameter {

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root){
        height(root);
        return diameter;
    }
    int height(TreeNode node){
        if(node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int die = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, die);

        return Math.max(leftHeight, rightHeight)+1;
    }


}
