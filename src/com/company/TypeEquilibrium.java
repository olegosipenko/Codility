package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TypeEquilibrium {

    private static final int[] b = new int[]{3, 1, 2, 4, 3};
    private static final int[] c = new int[]{-1000, 1000};
    private static final int[] d = new int[]{5, 6, 2, 4, 1};

    public static void main(String[] args) {
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
    }

    public static int solution(int[] A) {
        int sum = 0, diff = 0, answer = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        for (int i = 1; i < A.length; i++) {
            diff += A[i - 1];
            sum -= A[i - 1];
            int possibleAnswer = Math.abs(diff - sum);
            if (i == 1) {
                answer = Math.abs(possibleAnswer);
            } else {
                if (Math.abs(possibleAnswer) < answer) {
                    answer = Math.abs(possibleAnswer);
                }
            }
        }
        return answer;
    }
}
