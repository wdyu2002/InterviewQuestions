package com.devculture.interview.structs;

import java.util.ArrayList;
import java.util.List;

public class DOMElement {
    private String id;
    private int value;
    private List<DOMElement> children = new ArrayList<>();

    public DOMElement(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public void addChildren(DOMElement ... children) {
        for (DOMElement child : children) {
            if (!this.children.contains(child)) {
                this.children.add(child);
            }
        }
    }

    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public List<DOMElement> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(id);
        buf.append('(');
        buf.append(Integer.toString(value));
        buf.append(')');
        return buf.toString();
    }
}
