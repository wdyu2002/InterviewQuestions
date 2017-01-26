package com.devculture.interview.structs;

import java.util.Stack;

/**
 * BST implementation with BSTNodes.
 */
class BST {

    private BSTNode head;

    public BSTNode getHead() {
        return head;
    }

    void insert(Integer value) {
        BSTNode node = new BSTNode(value);
        if (head == null) {
            head = node;
        } else {
            head.insert(node);
        }
    }

    void insert(Integer ... values) {
        for (Integer value : values) {
            insert(value);
        }
    }

    BSTNode getMax() {
        if (head == null) {
            return null;
        }
        BSTNode tmp = head;
        while (tmp.getRight() != null) {
            tmp = tmp.getRight();
        }
        return tmp;
    }

    BSTNode getMin() {
        if (head == null) {
            return null;
        }
        BSTNode tmp = head;
        while (tmp.getLeft() != null) {
            tmp = tmp.getLeft();
        }
        return tmp;
    }

    int size() {
        return (head == null) ? 0 : head.size();
    }
}
