package com.devculture.katas.structs;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBST {

    private BST bst;

    @Before
    public void init() {
        bst = new BST();
    }

    @Test
    public void canInsert() {
        assertNull(bst.getHead());
        bst.insert(10);
        assertNotNull(bst.getHead());
        bst.insert(5,20);
        assertNotNull(bst.getHead().getLeft());
        assertNotNull(bst.getHead().getRight());
    }

    @Test
    public void canFindMax() {
        assertNull(bst.getMax());
        bst.insert(35,20,15,3,35,21,27,30);
        assertEquals(35, bst.getMax().getValue());
        bst.insert(100);
        assertEquals(100, bst.getMax().getValue());
    }

    @Test
    public void canFindMin() {
        assertNull(bst.getMin());
        bst.insert(35,20,15,3,35,21,27,30);
        assertEquals(3, bst.getMin().getValue());
        bst.insert(1);
        assertEquals(1, bst.getMin().getValue());
    }

    @Test
    public void canRetrieveHead() {
        bst.insert(1,2,3,4,5);
        assertEquals(1, bst.getHead().getValue());

        bst = new BST();
        bst.insert(2,3,4,5,1);
        assertEquals(2, bst.getHead().getValue());

        bst = new BST();
        bst.insert(3,4,5,1,2);
        assertEquals(3, bst.getHead().getValue());
    }

    @Test
    public void canDetermineSize() {
        assertEquals(0, bst.size());
        bst.insert(35);
        assertEquals(1, bst.size());
        bst.insert(20);
        assertEquals(2, bst.size());
        bst.insert(15);
        assertEquals(3, bst.size());
        bst.insert(3);
        assertEquals(4, bst.size());
        // duplicate node. size should not increase.
        bst.insert(35);
        assertEquals(4, bst.size());
        bst.insert(21);
        assertEquals(5, bst.size());
    }
}
