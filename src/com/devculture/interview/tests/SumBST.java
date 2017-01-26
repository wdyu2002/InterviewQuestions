package com.devculture.interview.tests;

import com.devculture.interview.structs.BST;
import com.devculture.interview.structs.BSTNode;
import java.util.Stack;

public class SumBST {

    private static int sumBSTNode(BSTNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.getValue();
        BSTNode left = node.getLeft();
        BSTNode right = node.getRight();
        if (left != null) {
            sum += sumBSTNode(left);
        }
        if (right != null) {
            sum += sumBSTNode(right);
        }
        return sum;
    }

    // sums up all the values in a bst.
    static int sumBSTByRecursiveTraversal(BST bst) {
        // base cases.
        if (bst == null) {
            return 0;
        }
        return sumBSTNode(bst.getHead());
    }

    // sums up all the values in a bst.
    static int sumBSTByStackTraversal(BST bst) {
        // base cases.
        if (bst == null || bst.getHead() == null) {
            return 0;
        }
        // traverse using stack.
        Stack<BSTNode> stack = new Stack<>();
        BSTNode head = bst.getHead();
        int sum = head.getValue();
        stack.push(head);
        while (!stack.empty()) {
            BSTNode node = stack.pop();
            BSTNode left = node.getLeft();
            BSTNode right = node.getRight();
            if (left != null) {
                sum += left.getValue();
                stack.push(left);
            }
            if (right != null) {
                sum += right.getValue();
                stack.push(right);
            }
        }
        return sum;
    }
}
