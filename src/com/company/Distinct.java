package com.company;

import java.util.Arrays;

public class Distinct {

    private static final int[] INPUT = {2, 1, 1, 2, 3, 1};
    private static final int[] INPUT2 = {-1, -2, -3, -1, -2};
    private static final int ANSWER = 3;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
        System.out.println(ANSWER == solution(INPUT2));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        int answer = 0;
        int current = Integer.MIN_VALUE;
        for (int a : A) {
            if (a > current) {
                current = a;
                answer++;
            }
        }
        return answer;
    }
}
