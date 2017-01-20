package com.devculture.interview;

import com.devculture.interview.structs.BSTNode;

import java.util.Stack;

/**
 * Created by dyu on 1/18/17.
 */
public class BSTExample implements Runnable {

    /**
     * prints the Nth largest node in the bst tree starting at head
     * @param h - head of bst
     * @param n - nth node from end (largest), 0 is largest node
     */
    public BSTNode findNthNodeFromEnd(BSTNode h, int n) {
        int counter = 0;

        Stack<BSTNode> stack = new Stack<>();
        stack.push(h);
        while (!stack.empty()) {
            BSTNode t = stack.peek();

            if (t.getRight() != null && !t.getRight().isVisited()) {
                stack.push(t.getRight());
                continue;
            }

            stack.pop();
            // prevents the node from being pushed onto the stack again.
            t.setVisited(true);

            // found the n-th.
            if (n == counter++) {
                return t;
            }

            if (t.getLeft() != null && !t.getLeft().isVisited()) {
                stack.push(t.getLeft());
                continue;
            }
        }

        return null;
    }

    public BSTNode createBST() {
        // BST head. this creates an unbalanced tree.
        BSTNode head = new BSTNode(25);
        head.insert(new BSTNode(35));
        head.insert(new BSTNode(20));
        // head.insert(new BSTNode(25));
        head.insert(new BSTNode(15));
        head.insert(new BSTNode(21));
        head.insert(new BSTNode(30));
        head.insert(new BSTNode(37));
        head.insert(new BSTNode(40));
        head.insert(new BSTNode(18));
        return head;
    }

    public void run() {
        BSTNode head = createBST();

        // print smallest to largest.
        System.out.println("-- print --");
        head.print();

        // print largest to smallest.
        System.out.println("-- print in reverse --");
        head.printInReverse();

        // find nth node from end.
        System.out.println("-- print nth node from end --");
        for (int n=0; n<10; n++) {
            BSTNode node = findNthNodeFromEnd(createBST(), n);
            if (node == null) {
                System.out.println(n + "th node from the end does not exist.");
            } else {
                System.out.println(n + "th node from the end: " + node.getValue());
            }
        }
    }

}
