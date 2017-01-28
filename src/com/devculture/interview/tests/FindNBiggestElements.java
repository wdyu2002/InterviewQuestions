package com.devculture.interview.tests;

import com.devculture.interview.structs.DOMElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindNBiggestElements {

    /**
     * Returns N largest elements in the sub-tree, not include the head element input.
     *
     * The returned list should be sorted alphabetically by the DOMElement's ids.
     */
    static List<DOMElement> findNBiggestDOMElements(DOMElement head, int n) {
        List<DOMElement> results = new ArrayList<>();
        // if no head element passed, or element has no children.
        if (head == null || head.getChildren().size() == 0 || n <= 0) {
            return results;
        }

        // stack traversal (BFS).
        Stack<DOMElement> stack = new Stack<>();
        stack.push(head);
        while(!stack.empty()) {
            List<DOMElement> children = stack.pop().getChildren();
            for (DOMElement e : children) {
                stack.push(e);
                if (!results.contains(e)) {
                    results.add(e);
                }
            }
        }

        // check if we need to remove elements.
        if (n < results.size()) {
            // sort elements from smallest to largest.
            List<DOMElement> list = new ArrayList<>(results);
            list.sort((DOMElement e1, DOMElement e2) -> {
                if (e1.getValue() < e2.getValue()) {
                    return 1;
                } else if (e1.getValue() > e2.getValue()) {
                    return -1;
                }
                return 0;
            });

            // remove redundant elements.
            for (int i=n; i<list.size(); i++) {
                results.remove(list.get(i));
            }
        }

        return results;
    }
}
