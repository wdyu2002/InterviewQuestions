package com.devculture.interview.structs;

/**
 * Created by dyu on 1/19/17.
 */
public class LinkedList {

    public static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }

        public int getValue() {
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

    public boolean empty() {
        return head == null;
    }

    public void append(Node n) {
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
    public void insert(Node n, int index) {
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
    public void remove(int index) {
        assertHeadExists();
        assertPositiveIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            // index > 0
            Node prev = get(index-1);
            prev.next = prev.next == null ? null : prev.next.next;
        }
        size--;
    }

    // value at index
    public Node get(int index) {
        assertHeadExists();
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
    public int size() {
        return size;
    }

    public void print() {
        if (head == null) {
            return;
        }

        Node result = head;
        do {
            System.out.print(result.value + ", ");
            result = result.next;
        } while (result != null);
        System.out.println();
    }

}
