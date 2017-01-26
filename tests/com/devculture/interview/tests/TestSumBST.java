package com.devculture.interview.tests;

import com.devculture.interview.structs.BST;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test SUM BST methods, recursive and via stack.
 */
public class TestSumBST {

    private BST bst;

    // helper method to run both tests simultaneously.
    private void sumBST(BST bst, int expected) {
        assertEquals(expected, SumBST.sumBSTByRecursiveTraversal(bst));
        assertEquals(expected, SumBST.sumBSTByStackTraversal(bst));
    }

    @Test
    public void sumEmptyBST() {
        sumBST(bst, 0);
        sumBST(new BST(), 0);
    }

    @Test
    public void sumSingleElementBST() {
        bst = new BST();
        bst.insert(99);
        sumBST(bst, 99);
    }

    @Test
    public void sumBalancedBST() {
        bst = new BST();
        bst.insert(66, 33, 99);
        sumBST(bst, 198);
    }

    @Test
    public void sumRightUnbalancedBST() {
        bst = new BST();
        bst.insert(1, 2, 3, 4, 5);
        sumBST(bst, 15);
    }

    @Test
    public void sumLeftUnbalancedBST() {
        bst = new BST();
        bst.insert(5, 4, 3, 2, 1);
        sumBST(bst, 15);
    }

    @Test
    public void sumRandomBSTs() {
        bst = new BST();
        bst.insert(35, 25, 4, 1, 7, 6, 100, 5, 88, 107, 112, 33);
        sumBST(bst, 523);

        bst = new BST();
        bst.insert(5, 25, 0, 100, 75, 70, 20, 15, 35, 10, 15, 65, 50, 80, 90, 95, 30, -100);
        sumBST(bst, 665);
    }
}
