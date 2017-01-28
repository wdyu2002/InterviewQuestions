package com.devculture.interview.tests;

import com.devculture.interview.structs.DOMElement;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Note: the objective is to find the biggest (by element.value) N elements in the 'sub-tree'.
 * In other words, do not include the head element as part of the results.
 */
public class TestFindNBiggestElements {

    /**
     *                    h(7)
     *                 /  |   \
     *                /   |    \
     *               /    |     \
     *            1(8)   2(6)   3(9)
     *          /  |    |  \    \   \
     *         /   |    |   \    \   \
     *       4(1) 5(2) 6(9) 7(9) 8(5)  9(6)
     *       /     |    |         |    |   \
     *      /      |    |         |    |    \
     *    10(2)  11(3) 12(5)   13(12) 14(9) 15(7)
     */
    private final int[] values = new int[]{ 7, 8, 6, 9, 1, 2, 9, 9, 5, 6, 2, 3, 5, 12, 9, 7 };
    private DOMElement[] e = new DOMElement[values.length];

    @Before
    public void init() {
        for (int i=0; i<e.length; i++) {
            e[i] = new DOMElement(Integer.toString(i), values[i]);
        }
        e[0].addChildren(e[1], e[2], e[3]);
        e[1].addChildren(e[4], e[5]);
        e[2].addChildren(e[6], e[7]);
        e[3].addChildren(e[8], e[9]);
        e[4].addChildren(e[10]);
        e[5].addChildren(e[11]);
        e[6].addChildren(e[12]);
        e[8].addChildren(e[13]);
        e[9].addChildren(e[14], e[15]);
    }

    /**
     * Helper method to sort the list of elements by ids.
     */
    private List<DOMElement> sortById(List<DOMElement> elements) {
        // sort results by name for testing.
        elements.sort((DOMElement e1, DOMElement e2) -> {
            int id1 = Integer.parseInt(e1.getId());
            int id2 = Integer.parseInt(e2.getId());
            if (id1 < id2) {
                return -1;
            } else if (id1 > id2) {
                return 1;
            }
            return 0;
        });
        return elements;
    }

    /**
     * Helper method to convert list of elements into a string for test validation by string comparison.
     */
    private String asString(List<DOMElement> elements) {
        StringBuilder buf = new StringBuilder();
        sortById(elements).forEach((DOMElement e) -> {
            buf.append(e.toString()).append(',');
        });
        return buf.toString();
    }

    @Test
    public void canFindNBiggestElements() {
        List<DOMElement> results;

        results = FindNBiggestElements.findNBiggestDOMElements(e[0], 1);
        assertEquals("13(12),", asString(results));
    }

    @Test
    public void canReturnAllElementsWhenNIsLargerThanSubTree() {
        List<DOMElement> results;
        results = FindNBiggestElements.findNBiggestDOMElements(e[0], 20);
        assertEquals("1(8),2(6),3(9),4(1),5(2),6(9),7(9),8(5),9(6),10(2),11(3),12(5),13(12),14(9),15(7),", asString(results));

        results = FindNBiggestElements.findNBiggestDOMElements(e[1], 20);
        assertEquals("4(1),5(2),10(2),11(3),", asString(results));

        results = FindNBiggestElements.findNBiggestDOMElements(e[3], 20);
        assertEquals("8(5),9(6),13(12),14(9),15(7),", asString(results));

        results = FindNBiggestElements.findNBiggestDOMElements(e[5], 20);
        assertEquals("11(3),", asString(results));
    }

    @Test
    public void canReturnEmptyListWhenNIs0() {
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[0], 0).size() == 0);
    }

    @Test
    public void canReturnEmptyListWhenHeadHasNoChildren() {
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[7], 0).size() == 0);
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[10], 0).size() == 0);
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[11], 0).size() == 0);
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[12], 0).size() == 0);
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[13], 0).size() == 0);
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[14], 0).size() == 0);
        assertTrue(FindNBiggestElements.findNBiggestDOMElements(e[15], 0).size() == 0);
    }

}
