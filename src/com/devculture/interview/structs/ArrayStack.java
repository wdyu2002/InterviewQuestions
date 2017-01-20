package com.devculture.interview.structs;

/**
 * Created by dyu on 1/19/17.
 */
public class ArrayStack {

    // stack implementation built over an array. initial size of array is 5. must handle array expansion.
    private int[] tmp = new int[5];
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(int n) {
        if (size >= tmp.length) {
            // expand array.
            int[] old = tmp;
            tmp = new int[old.length * 2];
            System.arraycopy(old, 0, tmp, 0, old.length);
        }
        tmp[size++] = n;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Cannot pop an empty stack.");
        }
        // reset the value, decrement the size.
        int value = tmp[--size];
        tmp[size] = 0;
        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Cannot peek into empty stack.");
        }
        return tmp[size-1];
    }

    public void print() {
        for (int i=0; i<size; i++) {
            System.out.print(tmp[i] + ", ");
        }
        if (size > 0) {
            System.out.println();
        }
    }
}
