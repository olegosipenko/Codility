package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinAbsSlice {
    private static final int[] INPUT = {2, -4, 6, -3, 9};
    private static final int ANSWER = 1;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
    }

    private static int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int[] slice = Arrays.copyOfRange(A, i, j);
                int sum = Math.abs(IntStream.of(slice).boxed().mapToInt(Integer::intValue).sum());
                if (sum < min) {
                    min = sum;
                }
            }
        }
        return min;
    }
}
