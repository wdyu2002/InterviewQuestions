package com.devculture.katas.structs;

/**
 * BST implementation with BSTNodes.
 */
public class BST {

    private BSTNode head;

    public BSTNode getHead() {
        return head;
    }

    public void insert(Integer value) {
        BSTNode node = new BSTNode(value);
        if (head == null) {
            head = node;
        } else {
            head.insert(node);
        }
    }

    public void insert(Integer ... values) {
        for (Integer value : values) {
            insert(value);
        }
    }

    public BSTNode getMax() {
        if (head == null) {
            return null;
        }
        BSTNode tmp = head;
        while (tmp.getRight() != null) {
            tmp = tmp.getRight();
        }
        return tmp;
    }

    public BSTNode getMin() {
        if (head == null) {
            return null;
        }
        BSTNode tmp = head;
        while (tmp.getLeft() != null) {
            tmp = tmp.getLeft();
        }
        return tmp;
    }

    public int size() {
        return (head == null) ? 0 : head.size();
    }
}
