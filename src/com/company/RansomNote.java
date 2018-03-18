package com.company;

import java.util.HashMap;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.
 * <p>
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers describing the respective values of  (the number of words in the magazine) and  (the number of words in the ransom note).
 * The second line contains  space-separated strings denoting the words present in the magazine.
 * The third line contains  space-separated strings denoting the words present in the ransom note.
 * <p>
 * Constraints
 * <p>
 * <p>
 * .
 * Each word consists of English alphabetic letters (i.e.,  to  and  to ).
 * The words in the note and magazine are case-sensitive.
 * Output Format
 * <p>
 * Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.
 * <p>
 * Sample Input 0
 * <p>
 * 6 4
 * give me one grand today night
 * give one grand today
 * Sample Output 0
 * <p>
 * Yes
 * Sample Input 1
 * <p>
 * 6 5
 * two times three is not four
 * two times two is four
 * Sample Output 1
 * <p>
 * No
 * Explanation 1
 * <p>
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {
    private static final String YES = "Yes";
    private static final String NO = "No";

    public static void main(String[] args) {
        System.out.println(YES.equals(isReplica(6, 4,
                new String[]{"give", "me", "one", "grand", "today", "night"}, new String[]{"give", "one", "grand", "today"})));
        System.out.println(NO.equals(isReplica(6, 5,
                new String[]{"two", "times", "three", "is", "not", "four"}, new String[]{"two", "times", "two", "is", "four"})));
    }

    private static String isReplica(int m, int n, String[] magazine, String[] ransom) {
        if (n > m) return NO;

        if (checkTheDictionary(ransom, fillTheDictionary(magazine))) return NO;
        return YES;
    }

    private static boolean checkTheDictionary(String[] ransom, HashMap<String, Integer> magazineDictionary) {
        for (String word : ransom) {
            int value = magazineDictionary.computeIfPresent(word, (s, integer) -> integer - 1);
            if (value == -1) return true;
        }
        return false;
    }

    private static HashMap<String, Integer> fillTheDictionary(String[] magazine) {
        HashMap<String, Integer> magazineDictionary = new HashMap<>();
        for (String word : magazine) {
            magazineDictionary.computeIfPresent(word, (s, integer) -> integer++);
            magazineDictionary.putIfAbsent(word, 1);
        }
        return magazineDictionary;
    }
}
