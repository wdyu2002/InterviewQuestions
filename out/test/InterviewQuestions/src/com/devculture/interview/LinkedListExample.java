package com.devculture.interview;

import com.devculture.interview.structs.LinkedList;

/**
 * Created by dyu on 1/19/17.
 */
public class LinkedListExample implements Runnable {

    public void run() {
        LinkedList ll = new LinkedList();

        ll.append(new LinkedList.Node(1));
        ll.get(0);

        ll.append(new LinkedList.Node(2));
        ll.get(0);
        ll.get(1);

        ll.append(new LinkedList.Node(3));
        ll.get(0);
        ll.get(1);
        ll.get(2);

        ll.append(new LinkedList.Node(4));
        ll.get(0);
        ll.get(1);
        ll.get(2);
        ll.get(3);

        ll.append(new LinkedList.Node(5));
        ll.get(0);
        ll.get(1);
        ll.get(2);
        ll.get(3);
        ll.get(4);

        ll.insert(new LinkedList.Node(6), 0); // 6,1,2,3,4,5
        ll.print();
        ll.insert(new LinkedList.Node(7), 1); // 6,7,1,2,3,4,5
        ll.print();
        ll.insert(new LinkedList.Node(8), 2); // 6,7,8,1,2,3,4,5
        ll.print();
        ll.insert(new LinkedList.Node(9), 3); // 6,7,8,9,1,2,3,4,5
        ll.print();
        ll.remove(0); // 7,8,9,1,2,3,4,5
        ll.print();
        ll.remove(1); // 7,9,1,2,3,4,5
        ll.print();
        ll.remove(2); // 7,9,2,3,4,5
        ll.print();

        // remove all.
        while (!ll.empty()) {
            ll.remove(0);
            ll.print();
        }
    }
}
