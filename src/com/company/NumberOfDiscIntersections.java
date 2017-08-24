package com.company;

import java.util.Arrays;

public class NumberOfDiscIntersections {
    private static final int[] INPUT = {1, 5, 2, 1, 4, 0};
    private static final int ANSWER = 11;

    public static void main(String[] args) {
        System.out.println(ANSWER == bfSolution(INPUT));
    }

    private static int bfSolution(int[] A) {
        if (A.length <= 1) return 0;
        int answer = 0;
        for (int j = 0; j < A.length - 1; j++) {
            for (int k = j + 1; k < A.length; k++) {
                if ((k - j) <= ((long) A[j] + (long) A[k])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
