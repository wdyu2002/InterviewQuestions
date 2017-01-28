package com.devculture.katas.structs;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedListStack {

    private LinkedListStack stack = null;

    @Before
    public void init() {
        stack = new LinkedListStack();
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

    /**
     * Make sure toString's string representation matches excepted state.
     */
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

    /**
     * Make sure the code throws an exception when we pop an empty stack.
     */
    @Test(expected = IllegalStateException.class)
    public void throwsExceptionWhenPoppingEmpty() {
        assertNotNull(stack);
        stack.pop();
    }

    /**
     * Make sure the code throws an exception when we peek an empty stack.
     */
    @Test(expected = IllegalStateException.class)
    public void throwsExceptionWhenPeekingEmpty() {
        assertNotNull(stack);
        stack.peek();
    }
}
