package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your dataset of integers in non-decreasing order, then:
 * <p>
 * If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted dataset ,  is the median.
 * If your dataset contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted dataset ,  is the median.
 * Given an input stream of  integers, you must perform the following task for each  integer:
 * <p>
 * Add the  integer to a running list of integers.
 * Find the median of the updated list (i.e., for the first element through the  element).
 * Print the list's updated median on a new line. The printed value must be a double-precision number scaled to decimal place (i.e.,  format).
 * Input Format
 * <p>
 * The first line contains a single integer, , denoting the number of integers in the data stream.
 * Each line  of the  subsequent lines contains an integer, , to be added to your list.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * After each new integer is added to the list, print the list's updated median on a new line as a single double-precision number scaled to  decimal place (i.e.,  format).
 * <p>
 * Sample Input
 * <p>
 * 6
 * 12
 * 4
 * 5
 * 3
 * 8
 * 7
 * Sample Output
 * <p>
 * 12.0
 * 8.0
 * 5.0
 * 4.5
 * 5.0
 * 6.0
 * <p>
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
 */
public class RunningMedian {

    private static final int[] INPUT1 = {12, 4, 5, 3, 8, 7};
    private static final int[] INPUT2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        printMedian(INPUT1);
        printMedian(INPUT2);
    }

    private static void printMedian(int[] i) {
        ArrayList<Integer> a = new ArrayList<>(i.length);
        for (int a_i = 0; a_i < i.length; a_i++) {
            int insertPosition = Collections.binarySearch(a, i[a_i]);
            if (insertPosition < 0) {
                insertPosition = Math.abs(insertPosition) - 1;
            }
            a.add(insertPosition, i[a_i]);
            double median = 0;
            if (a_i == 0) {
                median = a.get(a_i);
            } else if (a_i % 2 != 0) {
                median = (a.get(a_i / 2 + 1) + a.get(a_i /2)) / 2.0;
            } else {
                median = a.get((a_i + 1) / 2);
            }
            System.out.printf("%.1f", median);
            System.out.print("\n");
        }
    }
}
