package com.devculture.interview.structs;

/**
 * Basic stack implementation built over a linked list.
 *
 */
public class LinkedListStack {

    private final LinkedList list = new LinkedList();

    // remove last element inserted.
    int pop() {
        if (list.empty()) {
            throw new IllegalStateException("Cannot pop an empty stack.");
        }
        return list.remove(list.size() - 1).getValue();
    }

    // peek returns the value of the last linked list element.
    int peek() {
        // view the last element.
        if (list.empty()) {
            throw new IllegalStateException("Cannot peek into empty stack.");
        }
        return list.get(list.size()-1).getValue();
    }

    void push(int n) {
        list.append(new LinkedList.Node(n));
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
