package com.company;

import java.util.Arrays;

public class MaxProductOfThree {
    private static final int[] INPUT1 = {-3, 1, 2, -2, 5, 6};
    private static final int[] INPUT2 = {-5, 5, -5, 4};
    private static final int ANSWER1 = 60;
    private static final int ANSWER2 = 125;

    public static void main(String[] args) {
        System.out.println(ANSWER1 == solution(INPUT1));
        System.out.println(ANSWER2 == solution(INPUT2));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        return Math.max(A[len - 1] * A[len - 2] * A[len - 3],
                A[0] * A[1] * A[len - 1]);
    }
}
