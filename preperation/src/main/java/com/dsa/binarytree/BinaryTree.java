package com.dsa.binarytree;

import org.aspectj.weaver.patterns.ScopeWithTypeVariables;

import java.util.Scanner;

public class BinaryTree {

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the rot node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left of "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        boolean right = scanner.nextBoolean();
        if (right){
            System.out.println("Enter the value of the right of "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }
}
