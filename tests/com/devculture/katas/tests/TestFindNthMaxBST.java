package com.devculture.katas.tests;

import com.devculture.katas.structs.BST;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Test find Nth max in BST.
 */
public class TestFindNthMaxBST {

    private BST bst;

    // helper method to test both algorithm in parallel.
    private void testFindNthMaxImpl(int expectedResult, BST bst, int n) throws RuntimeException {
        RuntimeException e1 = null, e2 = null;
        try {
            assertEquals(expectedResult, FindNthMaxBST.findNthMaxByStackTraversal(bst, n));
        } catch (RuntimeException ex) {
            e1 = ex;
        }
        try {
            assertEquals(expectedResult, FindNthMaxBST.findNthMaxByRecursiveTraversal(bst, n));
        } catch (RuntimeException ex) {
            e2 = ex;
        }
        if (e1 != null && e2 != null && e1.getClass() == e2.getClass()) {
            throw e1;
        }
    }

    // helper method to find sorted arraylist.
    private int[] sortedValues(Integer[] values) {
        int[] clone = new int[values.length];
        for (int i=0; i<values.length; i++) {
            clone[i] = values[i];
        }
        Arrays.sort(clone);
        return clone;
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionWhenPassingInNullBST() {
        testFindNthMaxImpl(0, bst, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionWhenPassingInEmptyBST() {
        testFindNthMaxImpl(0, new BST(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionWhenPassingInNegativeN() {
        bst = new BST();
        bst.insert(5);
        testFindNthMaxImpl(0, bst, -5);
    }

    @Test
    public void canFindNthMax() {
        Integer[] values = {35, 25, 4, 1, 7, 6, 100, 5, 88, 107, 112, 33};
        int[] clone = sortedValues(values);
        bst = new BST();
        bst.insert(values);

        // validate all N values.
        for (int i=0; i<values.length; i++) {
            testFindNthMaxImpl(clone[values.length-1-i], bst, i);
        }
    }

    @Test
    public void canReturnSmallestValueIfNExceedsBSTSize() {
        Integer[] values = {35, 25, 4, 1, 7, 6, 100, 5, 88, 107, 112, 33};
        int[] clone = sortedValues(values);
        bst = new BST();
        bst.insert(values);
        final int minValue = bst.getMin().getValue();
        final int size = bst.size();
        // smallest value.
        testFindNthMaxImpl(minValue, bst, size - 1);
        // N exceeds bst.size().
        testFindNthMaxImpl(minValue, bst, size);
    }
}
