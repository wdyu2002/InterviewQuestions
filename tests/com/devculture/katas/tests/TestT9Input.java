package com.devculture.katas.tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestT9Input {

    @Test
    public void testGetChar() {
        char[][] set = {
                {'a','b','c'}, // 2
                {'d','e','f'}, // 3
                {'g','h','i'}, // 4
                {'j','k','l'}, // 5
                {'m','n','o'}, // 6
                {'p','q','r', 's'}, // 7
                {'t','u','v'}, // 8
                {'w','x','y', 'z'}, // 9
        };

        // cycle through [2, 9] * n[0-4].
        for (int i=2; i<=9; i++) {
            for (int j=0; j<5; j++) {
                assertEquals(set[i-2][j%set[i-2].length], T9Input.getChar((char) ('0' + i), j));
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCharException() {
        T9Input.getChar(';', 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCharExceptionForNegativeN() {
        T9Input.getChar('2', -1);
    }

    @Test
    public void testPauses() {
        assertEquals("ac", T9Input.getWord("2;222"));
        assertEquals("bb", T9Input.getWord("22;22"));
        assertEquals("ca", T9Input.getWord("222;2"));
        assertEquals("a", T9Input.getWord("2222;"));
        assertEquals("a", T9Input.getWord(";;2222"));
        assertEquals("aaaa", T9Input.getWord(";2;2;2;2;"));
    }

    @Test
    public void testWords() {
        assertEquals("apple", T9Input.getWord("27;755533"));
        assertEquals("banana", T9Input.getWord("22;2662662"));
        assertEquals("banana", T9Input.getWord("22;2;66;2;66;;2"));
        assertEquals("phone", T9Input.getWord("744666;6633"));
        assertEquals("mississippi", T9Input.getWord("64447777;77774447777;77774447;7444"));
        assertEquals("mississippi", T9Input.getWord("6;444;7777;7777;444;7777;7777;444;7;7;444;"));

        assertEquals("apple", T9Input.getWordBySplitting("27;755533"));
        assertEquals("banana", T9Input.getWordBySplitting("22;2662662"));
        assertEquals("banana", T9Input.getWordBySplitting("22;2;66;2;66;;2"));
        assertEquals("phone", T9Input.getWordBySplitting("744666;6633"));
        assertEquals("mississippi", T9Input.getWordBySplitting("64447777;77774447777;77774447;7444"));
        assertEquals("mississippi", T9Input.getWordBySplitting("6;444;7777;7777;444;7777;7777;444;7;7;444;"));
    }
}
