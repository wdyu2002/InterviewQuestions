package com.devculture.katas.structs;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBSTNode {

    private BSTNode head = null;

    @Before
    public void init() {
        head = new BSTNode(25);
    }

    /**
     * Make sure head node has a value as expected.
     */
    @Test
    public void canHoldValue() {
        assertNotNull(head);
        assertEquals(head.getValue(), 25);
    }

    /**
     * Make sure we can insert to head a smaller child.
     */
    @Test
    public void canInsertSmallerChild() {
        assertNotNull(head);
        head.insert(new BSTNode(15));
        // since head is 25, child is 15, expecting left-insertion.
        assertEquals(head.getLeft().getValue(), 15);
    }

    /**
     * Make sure we can insert to head a larger child.
     */
    @Test
    public void canInsertLargerChild() {
        assertNotNull(head);
        head.insert(new BSTNode(35));
        // since head is 25, child is 35, expecting right-insertion.
        assertEquals(head.getRight().getValue(), 35);
    }

    /**
     * Make sure nothing happens when we insert the same element.
     */
    @Test
    public void canIgnoreInsertionOfSame() {
        assertNotNull(head);
        head.insert(new BSTNode(25));
        // dupe. insertion ignored.
        assertNull(head.getLeft());
        assertNull(head.getRight());
    }

    /**
     * Make sure we can insert to left and left->left.
     */
    @Test
    public void canInsertTwoSmallerNodes() {
        assertNotNull(head);
        head.insert(new BSTNode(15));
        head.insert(new BSTNode(10));
        assertEquals(head.getLeft().getValue(), 15);
        assertEquals(head.getLeft().getLeft().getValue(), 10);
    }

    /**
     * Make sure we can insert to right and right->right.
     */
    @Test
    public void canInsertTwoLargerNodes() {
        assertNotNull(head);
        head.insert(new BSTNode(35));
        head.insert(new BSTNode(40));
        assertEquals(head.getRight().getValue(), 35);
        assertEquals(head.getRight().getRight().getValue(), 40);
    }

    /**
     * Make sure we can insert to left and right.
     */
    @Test
    public void canInsertSmallerAndLargerNodes() {
        assertNotNull(head);
        head.insert(new BSTNode(15));
        head.insert(new BSTNode(35));
        assertEquals(head.getLeft().getValue(), 15);
        assertEquals(head.getRight().getValue(), 35);
    }

    /**
     * Make sure we can create a balanced tree.
     */
    @Test
    public void canRecursivelyInsertNodes() {
        assertNotNull(head);
        // insert to left leaf.
        head.insert(new BSTNode(15)); // head->left
        head.insert(new BSTNode(10)); // head->left->left
        head.insert(new BSTNode(20)); // head->left->right
        // insert to right leaf.
        head.insert(new BSTNode(35)); // head->right
        head.insert(new BSTNode(30)); // head->right->left
        head.insert(new BSTNode(40)); // head->right->right

        assertEquals(head.getLeft().getLeft().getValue(), 10);
        assertEquals(head.getLeft().getValue(), 15);
        assertEquals(head.getLeft().getRight().getValue(), 20);
        assertEquals(head.getRight().getLeft().getValue(), 30);
        assertEquals(head.getRight().getValue(), 35);
        assertEquals(head.getRight().getRight().getValue(), 40);
    }

    /**
     * Make sure string representation matches expectations.
     */
    @Test
    public void canBeRepresentedWithString() {
        assertNotNull(head);

        // insert to left leaf..

        // head->left
        head.insert(new BSTNode(15));
        assertEquals(head.toString(), "15,25,");

        // head->left->left
        head.insert(new BSTNode(10));
        assertEquals(head.toString(), "10,15,25,");

        // head->left->right
        head.insert(new BSTNode(20));
        assertEquals(head.toString(), "10,15,20,25,");

        // insert to right leaf..

        // head->right
        head.insert(new BSTNode(35));
        assertEquals(head.toString(), "10,15,20,25,35,");

        // head->right->left
        head.insert(new BSTNode(30));
        assertEquals(head.toString(), "10,15,20,25,30,35,");

        // head->right->right
        head.insert(new BSTNode(40));
        assertEquals(head.toString(), "10,15,20,25,30,35,40,");

        // check left leaf.
        assertEquals(head.getLeft().toString(), "10,15,20,");

        // check right leaf.
        assertEquals(head.getRight().toString(), "30,35,40,");

        // check left->left leaf.
        assertEquals(head.getLeft().getLeft().toString(), "10,");

        // check left->right leaf.
        assertEquals(head.getLeft().getRight().toString(), "20,");

        // check right->left leaf.
        assertEquals(head.getRight().getLeft().toString(), "30,");

        // check right->right leaf.
        assertEquals(head.getRight().getRight().toString(), "40,");
    }
}
