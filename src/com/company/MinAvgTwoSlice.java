package com.company;

import java.util.Arrays;

public class MinAvgTwoSlice {
    private static final int[] INPUT = {4, 2, 2, 5, 1, 5, 8};
    private static final int[] TI1 = {-3, -5, -8, -4, -10};
    private static final int[] TI2 = {5, 6, 3, 4, 9};
    private static final int ANSWER = 1;
    private static final int A1 = 2;
    private static final int A2 = 2;

    public static void main(String[] args) {
        System.out.println(solution(INPUT) == ANSWER);
        System.out.println(solution(TI1) == A1);
        System.out.println(solution(TI2) == A2);
    }

    private static int solution(int[] A) {
        if (A.length == 2) return 0;
        float lowestAverage = Integer.MAX_VALUE;
        int answer = A.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 2; j < i + 4 && j <= A.length; j++) {
                int[] slice = Arrays.copyOfRange(A, i, j);
                int sum = 0;
                for (int k : slice) {
                    sum += k;
                }
                float average = sum / ((float) slice.length);
                if ((average == lowestAverage && i < answer) || (average < lowestAverage)) {
                    lowestAverage = average;
                    answer = i;
                }
            }
        }
        return answer;
    }
}
