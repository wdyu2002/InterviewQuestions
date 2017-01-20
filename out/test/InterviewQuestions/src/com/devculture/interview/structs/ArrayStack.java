package com.devculture.interview.structs;

/**
 * Basic stack implementation built over an array.
 * Internal array with initial size of 5. The stack must be able to handle array expansion when pushing new
 * elements into an already full stack.
 *
 */
public class ArrayStack {

    private static final int INITIAL_ARRAY_SIZE = 5;

    /**
     * Internal array.
     */
    private int[] tmp = new int[INITIAL_ARRAY_SIZE];

    /**
     * Size of stack. Number of elements.
     */
    private int size = 0;

    /**
     * @return Size of stack. Number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * @return Maximum size of internal array before an array expansion is needed.
     */
    public int getCurrentMaxSize() {
        return tmp.length;
    }

    /**
     * Pushes an integer onto the stack.
     * @param n integer value.
     */
    public void push(int n) {
        if (size >= tmp.length) {
            // expand array if size > max.
            int[] old = tmp;
            tmp = new int[old.length * 2];
            System.arraycopy(old, 0, tmp, 0, old.length);
        }
        tmp[size++] = n;
    }

    /**
     * Removes the top integer from the stack.
     * @return integer value removed from stack.
     */
    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Cannot pop an empty stack.");
        }
        // reset the value, decrement the size.
        int value = tmp[--size];
        tmp[size] = 0;
        return value;
    }

    /**
     * View top integer value of the stack without removal.
     * @return integer value at the top of the stack.
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Cannot peek into empty stack.");
        }
        return tmp[size-1];
    }

    /**
     * @return string of stack elements, comma delimited.
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<size; i++) {
            buf.append(Integer.toString(tmp[i])).append(',');
        }
        return buf.toString();
    }
}
