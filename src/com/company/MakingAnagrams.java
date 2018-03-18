package com.company;

import java.util.Arrays;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * <p>
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?
 * <p>
 * Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
 * <p>
 * This challenge is also available in the following translations:
 * <p>
 * Chinese
 * Russian
 * Input Format
 * <p>
 * The first line contains a single string, .
 * The second line contains a single string, .
 * <p>
 * Constraints
 * <p>
 * <p>
 * It is guaranteed that  and  consist of lowercase English alphabetic letters (i.e.,  through ).
 * Output Format
 * <p>
 * Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.
 * <p>
 * Sample Input
 * <p>
 * cde
 * abc
 * Sample Output
 * <p>
 * 4
 * Explanation
 * <p>
 * We delete the following characters from our two strings to turn them into anagrams of each other:
 * <p>
 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 * We must delete  characters to make both strings anagrams, so we print  on a new line.
 *
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */
public class MakingAnagrams {
    public static void main(String[] args) {
        System.out.println(numberNeeded("cde", "abc"));
    }

    private static int numberNeeded(String first, String second) {
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        int counter = 0, i = 0, j = 0;
        for (; ; ) {
            if (i >= a.length) {
                counter += b.length - j;
                break;
            }
            if (j >= b.length) {
                counter += a.length - i;
                break;
            }

            if (a[i] > b[j]) {
                counter++;
                j++;
            } else if (b[j] > a[i]) {
                counter++;
                i++;
            } else {
                i++;
                j++;
            }

        }
        return counter;
    }
}
