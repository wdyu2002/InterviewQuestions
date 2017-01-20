package com.devculture.interview.structs;

/**
 * Created by dyu on 1/19/17.
 */
public class LinkedListStack {

    // note: stacks are first-in last out.
    // this means that we need to always remove the LAST element in the linked list.
    private final LinkedList list = new LinkedList();

    // remove last element inserted.
    public void pop() {
        if (list.empty()) {
            throw new IllegalStateException("Cannot pop an empty stack.");
        }
        list.remove(list.size()-1);
    }

    // peek returns the value of the last linked list element.
    public int peek() {
        // view the last element.
        if (list.empty()) {
            throw new IllegalStateException("Cannot peek into empty stack.");
        }
        return list.get(list.size()-1).getValue();
    }

    public void push(int n) {
        list.append(new LinkedList.Node(n));
    }

    public int size() {
        return list.size();
    }

    public void print() {
        list.print();
    }

}
