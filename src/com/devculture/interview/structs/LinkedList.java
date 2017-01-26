package com.devculture.interview.structs;

/**
 * Basic linked list implementation.
 */
public class LinkedList {

    static class Node {
        private final int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        /*
        public boolean hasNext() {
            return next != null;
        }
        */

        int getValue() {
            return value;
        }
    }

    private int size = 0;
    private Node head;

    private void assertHeadExists() {
        if (head == null) {
            throw new AssertionError("Cannot call get when head is null.");
        }
    }

    private void assertPositiveIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Cannot get element with negative index.");
        }
    }

    boolean empty() {
        return head == null;
    }

    void append(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node result = head;
            while (result.next != null) {
                result = result.next;
            }
            result.next = n;
        }
        size++;
    }

    // insert at index
    void insert(Node n, int index) {
        assertPositiveIndex(index);
        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            Node prev = get(index-1);
            n.next = prev.next;
            prev.next = n;
        }
        size++;
    }

    // remove at index
    Node remove(int index) {
        assertHeadExists();
        assertPositiveIndex(index);
        Node result;
        if (index == 0) {
            result = head;
            head = head.next;
        } else {
            // index > 0
            Node prev = get(index-1);
            result = prev.next;
            prev.next = prev.next == null ? null : prev.next.next;
        }
        size--;
        return result;
    }

    // value at index
    Node get(int index) {
        // assertHeadExists();
        assertPositiveIndex(index);
        int n = index;
        Node result = head;
        while (n-- > 0 && result != null) {
            result = result.next;
        }
        if (result == null) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        return result;
    }

    // return size of linked list.
    int size() {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder buf = new StringBuilder();
        Node result = head;
        do {
            buf.append(result.value).append(',');
            result = result.next;
        } while (result != null);
        return buf.toString();
    }
}
