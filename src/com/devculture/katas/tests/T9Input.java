package com.devculture.katas.tests;

import java.util.*;

/**
 * T9 (text-on-9-keys) was a method of text input on 9 keys 2-9. Each key represented a different set of letters,
 * 2 (abc), 3 (def), 4 (ghi), 5 (jkl), 6 (mno), 7 (pqrs), 8 (tuv), 9 (wxyz). If a person hits 2 followed immediately
 * by another 2, the letter changes from 'a' to 'b'. Hitting 3 2's rapidly resulted in 'c'. If a person pauses between
 * hitting 2, and follows it with hitting 2 twice rapidly, the result is 'ab'.
 *
 * In this assignment a pause will be denoted by the character ';', that is:
 *
 * 222 => c
 * 2;22 => ab
 * 22;2 => ba
 * 222; => c
 *
 * No pause needs to be between 2 numbers being pressed for the two letters to be both displayed, that is:
 *
 * 233 => ae
 * 232 => ada
 * 2;3;2 => ada (note: the pause is unnecessary because 2 != 3, and 3 != 2)
 *
 * Note that typing 2 a fourth time, just cycles back to 'a'.
 * Note that there is no capital letters in this exercise.
 *
 * The object of this problem is: given a string of 2-9, and ; characters. Figure out what words they represent.
 */
@SuppressWarnings("WeakerAccess")
public class T9Input {

    public static String getWord(String input) {
        StringBuilder buf = new StringBuilder();
        char[] tmp = input.toCharArray();
        char last = '\0';
        int repeat = 0;
        for (char c : tmp) {
            repeat = c == last? repeat+1 : 0;
            if (c != ';') {
                if (repeat > 0) buf.deleteCharAt(buf.length()-1);
                buf.append(getChar(c, repeat));
            }
            last = c;
        }
        return buf.toString();
    }

    /**
     * This approach is a bit easier to implement but would take more memory & is slower to run.
     * The idea is that we know inputs are split by ; and runs.
     */
    public static String getWordBySplitting(String input) {
        StringBuilder buf = new StringBuilder();
        // first split by delimiter.
        String[] splits = input.split(";");
        // next, split by runs of the same letters.
        List<Object[]> list = new ArrayList<>();
        for (String split : splits) {
            for (char c : split.toCharArray()) {
                if (list.isEmpty() || (char) list.get(list.size()-1)[0] != c) {
                    // if stack is empty, add the char with count 0.
                    // if stack is !empty, and last char is not the same as this char, add the char with count 0.
                    list.add(new Object[] {c, 0});
                } else {
                    // stack is !empty && this is a repeat char.
                    Object[] tmp = list.get(list.size()-1);
                    tmp[1] = (Integer)tmp[1] + 1;
                }
            }
            // empty stack after each split is parsed.
            while (!list.isEmpty()) {
                Object[] tmp = list.remove(0);
                buf.append(getChar((char) tmp[0], (int) tmp[1]));
            }
        }
        // pop from top and then reverse before returning the final string.
        return buf.toString();
    }

    /**
     * This function should return the proper character after the person presses the same number key n times.
     */
    public static char getChar(char character, int nTimes) {
        if (nTimes < 0) {
            throw new IllegalArgumentException("N must be greater than 0.");
        }
        switch (character) {
            case '2': // abc
                return (char) ('a' + (nTimes%3));
            case '3': // def
                return (char) ('d' + (nTimes%3));
            case '4': // ghi
                return (char) ('g' + (nTimes%3));
            case '5': // jkl
                return (char) ('j' + (nTimes%3));
            case '6': // mno
                return (char) ('m' + (nTimes%3));
            case '7': // pqrs
                return (char) ('p' + (nTimes%4));
            case '8': // tuv
                return (char) ('t' + (nTimes%3));
            case '9': // wxyz
                return (char) ('w' + (nTimes%4));
            default:
                throw new IllegalArgumentException("Illegal character input to getChar(" + character + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(getWord("2")); // a
        System.out.println(getWord("22")); // b
        System.out.println(getWord("222")); // c
        System.out.println(getWord("2222")); // a
        System.out.println(getWord("2;222")); // ac
        System.out.println(getWord("22;22")); // bb
        System.out.println(getWord("222;2")); // ca
        System.out.println(getWord("2222;")); // a
        System.out.println(getWord(";;2222")); // a
        System.out.println(getWord(";2;2;2;2;")); // aaaa
        System.out.println(getWord("27;755533")); // apple
    }
}
