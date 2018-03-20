package com.company;

import java.util.HashMap;
import java.util.Map;

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

        return enoughDictionary(buildDictionary(magazine), buildDictionary(ransom)) ? YES : NO;
    }

    private static HashMap<String, Integer> buildDictionary(String[] strings) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String word : strings) {
            words.putIfAbsent(word, 0);
            words.computeIfPresent(word, (w, i) -> i + 1);
        }
        return words;
    }

    private static boolean enoughDictionary(HashMap<String, Integer> dic1, HashMap<String, Integer> dic2) {
        if (dic2.size() > dic1.size()) return false;
        for (Map.Entry<String, Integer> entry: dic2.entrySet()) {
            if (!dic1.containsKey(entry.getKey()) || dic1.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
