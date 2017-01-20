package com.devculture.interview.structs;

/**
 * Created by dyu on 1/19/17.
 */
public class BSTNode {

    // basic BST implementation with just BSTNode class defined.
    private BSTNode left;
    private BSTNode right;
    private final int value;
    // for stack/queue implementation we need to keep track of nodes that were visited previously.
    private boolean visited;

    public BSTNode(int value) {
        this.value = value;
    }

    // insert another node.
    public void insert(BSTNode n) {
        if (n.value < value) {
            // insert left
            if (left != null) {
                left.insert(n);
            } else {
                left = n;
            }
        } else if (n.value > value) {
            // insert right
            if (right != null) {
                right.insert(n);
            } else {
                right = n;
            }
        } else {
            System.out.printf("Inserting duplicate node with value: %d\n", value);
        }
    }

    // traverse smallest to greatest
    public void print() {
        if (left != null) {
            left.print();
        }
        System.out.println(value);
        if (right != null) {
            right.print();
        }
    }

    // traverse largest to smallest
    public void printInReverse() {
        if (right != null) {
            right.printInReverse();
        }
        System.out.println(value);
        if (left != null) {
            left.printInReverse();
        }
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}