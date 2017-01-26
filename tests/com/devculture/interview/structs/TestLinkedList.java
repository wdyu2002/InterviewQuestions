package com.devculture.interview.structs;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

    private LinkedList list;

    @Before
    public void init() {
        list = new LinkedList();
    }

    @Test
    public void canCheckEmpty() {
        assertTrue(list.empty());
        list.append(new LinkedList.Node(1));
        assertFalse(list.empty());
        list.remove(0);
        assertTrue(list.empty());
    }

    @Test
    public void canCheckSize() {
        list.append(new LinkedList.Node(1));
        list.append(new LinkedList.Node(3));
        list.insert(new LinkedList.Node(2), 1);
        assertEquals(list.size(), 3);
    }

    @Test
    public void canAppend() {
        list.append(new LinkedList.Node(1));
        assertTrue(list.size() == 1);
    }

    @Test
    public void canInsertAtIndex() {
        list.append(new LinkedList.Node(1));
        list.append(new LinkedList.Node(3));

        list.insert(new LinkedList.Node(2), 1);
        assertEquals(list.get(0).getValue(), 1);
        assertEquals(list.get(1).getValue(), 2);
        assertEquals(list.get(2).getValue(), 3);

        list.insert(new LinkedList.Node(0), 0);
        assertEquals(list.get(0).getValue(), 0);
        assertEquals(list.get(1).getValue(), 1);
        assertEquals(list.get(2).getValue(), 2);
        assertEquals(list.get(3).getValue(), 3);
    }

    @Test
    public void canGetFromIndex() {
        list.append(new LinkedList.Node(1));
        list.append(new LinkedList.Node(2));
        list.append(new LinkedList.Node(3));
        assertEquals(list.get(0).getValue(), 1);
        assertEquals(list.get(1).getValue(), 2);
        assertEquals(list.get(2).getValue(), 3);
    }

    @Test
    public void canRemoveFromIndex() {
        list.append(new LinkedList.Node(1));
        list.append(new LinkedList.Node(2));
        list.append(new LinkedList.Node(3));
        list.remove(1);
        assertEquals(list.get(0).getValue(), 1);
        assertEquals(list.get(1).getValue(), 3);
    }

    /**
     * Make sure string representation matches expectations.
     */
    @Test
    public void canBeRepresentedWithString() {
        assertEquals(list.toString(), "");
        list.append(new LinkedList.Node(1));
        assertEquals(list.toString(), "1,");
        list.append(new LinkedList.Node(2));
        assertEquals(list.toString(), "1,2,");
        list.append(new LinkedList.Node(3));
        assertEquals(list.toString(), "1,2,3,");
    }

    @Test(expected = AssertionError.class)
    public void canThrowExceptionWhenRemovingFromEmptyList() {
        list.remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionWhenPassingNegativeIndicesToInsert() {
        list.insert(new LinkedList.Node(1), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionWhenPassingNegativeIndicesToGet() {
        list.append(new LinkedList.Node(1));
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionWhenPassingNegativeIndicesToRemove() {
        list.append(new LinkedList.Node(1));
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canThrowExceptionWhenGetFromEmptyList() {
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canThrowExceptionWhenGettingNodeGtSize() {
        list.append(new LinkedList.Node(1));
        list.get(5);
    }
}
