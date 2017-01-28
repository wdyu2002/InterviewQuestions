package com.devculture.katas.tests;

import com.devculture.katas.structs.BST;
import com.devculture.katas.structs.BSTNode;
import java.util.*;

public class FindNthMaxBST {

    static class Counter {
        int count;
        Counter(int count) {
            this.count = count;
        }
    }

    /**
     * @return returns the node if it happens to be the nTh maximum. else, null.
     */
    static BSTNode findNthMax(BSTNode node, Counter counter) {
        if (node == null) {
            throw new IllegalArgumentException("Null nodes are not appropriate");
        }

        BSTNode result;
        BSTNode left = node.getLeft();
        BSTNode right = node.getRight();

        if (right != null) {
            result = findNthMax(right, counter);
            if (result != null) {
                return result;
            }
        }

        // decrement the count & check if this is the node we're looking for.
        if (counter.count-- == 0) {
            return node;
        }

        if (left != null) {
            result = findNthMax(left, counter);
            if (result != null) {
                return result;
            }
        }

        // none found.
        return null;
    }

    static int findNthMaxByRecursiveTraversal(BST bst, int nThMaximumValue) {
        if (nThMaximumValue < 0) {
            throw new IllegalArgumentException("cannot find negative n");
        }
        if (bst == null) {
            throw new IllegalArgumentException("bst is null");
        }
        if (bst.getHead() == null) {
            throw new IllegalArgumentException("bst has no nodes");
        }
        if (nThMaximumValue >= bst.size()) {
            return bst.getMin().getValue();
        }
        BSTNode node = findNthMax(bst.getHead(), new Counter(nThMaximumValue));
        return node != null ? node.getValue() : -999;
    }

    static int findNthMaxByStackTraversal(BST bst, int nThMaximumValue) {
        if (nThMaximumValue < 0) {
            throw new IllegalArgumentException("cannot find negative n");
        }
        if (bst == null) {
            throw new IllegalArgumentException("bst is null");
        }
        if (bst.getHead() == null) {
            throw new IllegalArgumentException("bst has no nodes");
        }

        BSTNode top = null, left, right;
        BSTNode head = bst.getHead();
        Stack<BSTNode> stack = new Stack<>();
        Set<BSTNode> visited = new HashSet<>();

        stack.push(head);
        while (!stack.empty()) {
            top = stack.peek();
            left = top.getLeft();
            right = top.getRight();

            if (right != null && !visited.contains(right)) {
                stack.push(right);
                visited.add(right);
                continue;
            }

            stack.pop();
            if (nThMaximumValue-- == 0) {
                return top.getValue();
            }

            if (left != null && !visited.contains(left)) {
                stack.push(left);
                visited.add(left);
            }
        }

        return top != null ? top.getValue() : head.getValue();
    }
}
