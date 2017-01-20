package com.devculture.interview.structs;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestArrayStack {

    private ArrayStack stack = null;

    @Before
    public void createStack() {
        stack = new ArrayStack();
    }

    /**
     * Make sure we can do a basic push to stack.
     */
    @Test
    public void canPushToStack() {
        assertNotNull(stack);
        stack.push(15);
        assertTrue(stack.size() == 1);
    }

    /**
     * Make sure we can do a push multiple elements to stack.
     */
    @Test
    public void canPushMultipleToStack() {
        assertNotNull(stack);
        stack.push(15);
        stack.push(25);
        stack.push(35);
        assertTrue(stack.size() == 3);
    }

    /**
     * Make sure we can push more than initial array size.
     * Make sure our expansion is always 2x previous array size.
     */
    @Test
    public void canPushMoreThanInitialArraySizeToStack() {
        assertNotNull(stack);
        StringBuilder buf = new StringBuilder();
        int maxSize = stack.getCurrentMaxSize();
        for (int i=0; i<=maxSize; i++) {
            stack.push(i);
            buf.append(Integer.toString(i)).append(',');
        }
        assertTrue(maxSize + 1 == stack.size());
        assertTrue(maxSize * 2 == stack.getCurrentMaxSize());
        assertEquals(stack.toString(), buf.toString());
    }

    /**
     * Make sure we can pop from stack and retrieve the value from the popped element.
     */
    @Test
    public void canPopFromStack() {
        assertNotNull(stack);
        stack.push(15);
        assertTrue(stack.size() == 1);
        assertTrue(15 == stack.pop());
        assertTrue(stack.size() == 0);
    }

    /**
     * Make sure we can pop from stack with 2 elements.
     */
    @Test
    public void canPopFromStackWith2Elements() {
        assertNotNull(stack);
        stack.push(15);
        stack.push(25);
        assertTrue(stack.size() == 2);
        assertTrue(25 == stack.pop());
        assertTrue(stack.size() == 1);
        assertTrue(15 == stack.pop());
        assertTrue(stack.size() == 0);
    }

    /**
     * Make sure we can peek stack without affecting stack size.
     */
    @Test
    public void canPeekStack() {
        assertNotNull(stack);
        stack.push(15);
        assertTrue(stack.peek() == 15);
        assertTrue(stack.size() == 1);
        stack.push(25);
        assertTrue(stack.peek() == 25);
        assertTrue(stack.size() == 2);
    }

    @Test
    public void canBeRepresentedWithString() {
        assertNotNull(stack);
        stack.push(1);
        assertEquals(stack.toString(), "1,");
        stack.push(2);
        assertEquals(stack.toString(), "1,2,");
        stack.push(3);
        assertEquals(stack.toString(), "1,2,3,");
        stack.push(4);
        assertEquals(stack.toString(), "1,2,3,4,");
        stack.push(5);
        assertEquals(stack.toString(), "1,2,3,4,5,");
        stack.push(6);
        assertEquals(stack.toString(), "1,2,3,4,5,6,");
    }
}
