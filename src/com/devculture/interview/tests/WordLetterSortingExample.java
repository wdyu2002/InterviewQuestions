package com.devculture.interview.tests;

import java.util.*;
import java.util.stream.Collectors;

 /**
 * Given a word like steeppe, re-order such that:
 *
 * letters that only appear once is first.
 * letters that have duplicates are pushed to the end of the word, but in the same appearance order.
 *
 * ie. steeppe => steeepp.
 *     apple => alepp.
 */
class WordLetterSortingExample {

    static class Char {
        final char c;
        final int firstAppearanceIndex;
        int count;

        Char(char c, int firstAppearanceIndex, int count) {
            this.c = c;
            this.firstAppearanceIndex = firstAppearanceIndex;
            this.count = count;
        }

        void incrementCount() {
            count++;
        }

        @Override
        public String toString() {
            char[] tmp = new char[count];
            for (int i=0; i<count; i++) {
                tmp[i] = c;
            }
            return new String(tmp);
        }
    }

    static String sort1(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Null is not a valid string");
        }

        if (input.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(input.length());
        Map<Character, Char> map = new HashMap<>();

        // Use map to 'look-up' char count & first index. this info is later used to sort1 the results.
        // O(n)
        // Arrays.stream(input.toCharArray())
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            Char p = map.get(c);
            if (p == null) {
                map.put(c, new Char(c, i, 1));
            } else {
                p.incrementCount();
            }
        }

        // O(n)
        List<Char> list = map.values().stream().collect(Collectors.toList());

        // Assuming merge-sort1.
        // O(n log n)
        list.sort((Char d1, Char d2) -> {
            if ((d1.count == 1 && d2.count == 1) || (d1.count != 1 && d2.count != 1)) {
                if (d1.firstAppearanceIndex < d2.firstAppearanceIndex) {
                    return -1;
                } else if (d1.firstAppearanceIndex > d2.firstAppearanceIndex) {
                    return 1;
                }
            } else if (d1.count == 1) {
                // d1.count == 1 && d2.count != 1
                return -1;
            } else {
                // d1.count != 1 && d2.count == 1
                return 1;
            }
            return 0;
        });

        // O(n)
        list.forEach((Char s) -> builder.append(s.toString()));

        return builder.toString();
    }

    /**
     * Second sorting algorithm utilizing 2-d linkedLists.
     *
     */
    static String sort2(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Null is not a valid string");
        }

        if (input.length() == 0) {
            return "";
        }

        // 2-d linked list of characters.
        StringBuilder builder = new StringBuilder(input.length());
        LinkedList<LinkedList<Character>> ll = new LinkedList<>();

        // O(n^2)
        outer:
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            // Search through existing outer linkedList for the character, and append another character if found.
            for (LinkedList<Character> l : ll) {
                if (l.get(0) == c) {
                    l.add(c);
                    continue outer;
                }
            }
            // If character was not found, insert a new entry into the outer linkedList.
            LinkedList<Character> l = new LinkedList<>();
            l.add(c);
            ll.add(l);
        }

        // Concatenate the chars into the output string.
        // O(n^2) .. or is it technically O(n).
        ll.forEach((LinkedList<Character> l) -> {
            if (l.size() == 1) l.forEach(builder::append);
        });

        // O(n^2) .. or is it technically O(n).
        ll.forEach((LinkedList<Character> l) -> {
            if (l.size() > 1) l.forEach(builder::append);
        });

        return builder.toString();
    }

    /**
     * Third sorting algorithm that separates the count into single & dupe buckets.
     *
     */
    static String sort3(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Null is not a valid string");
        }

        if (input.length() == 0) {
            return "";
        }

        char[] tmp = input.toCharArray();
        StringBuilder builder = new StringBuilder(input.length());
        Map<Character, Integer> count = new HashMap<>();
        LinkedList<Character> single = new LinkedList<>();
        LinkedList<Character> dupes = new LinkedList<>();

        // count.
        // O(n)
        for (char c : tmp) {
            Integer i = count.get(c);
            if (i != null) {
                count.put(c, i+1);
            } else {
                count.put(c, 1);
            }
        }

        // sort1.
        // O(2n)
        for (char c : tmp) {
            Integer i = count.remove(c);
            if (i != null) {
                if (i == 1) {
                    single.add(c);
                    continue;
                }
                while (i-- > 0) {
                    dupes.add(c);
                }
            }
        }

        // collect.
        // O(n)
        single.forEach(builder::append);
        dupes.forEach(builder::append);
        return builder.toString();
    }

}
