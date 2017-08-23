package com.company;

import java.util.Arrays;

public class Triangle {
    private static final int[] INPUT1 = {10, 2, 5, 1, 8, 20};
    private static final int[] INPUT2 = {10, 50, 5, 1};
    private static final int[] INPUT3 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

    public static void main(String[] args) {
        System.out.println(solution(INPUT1) > solution(INPUT2));
        System.out.println(solution(INPUT3) > solution(INPUT2));
    }

    private static int solution(int[] A) {
        int k = A.length - 2;
        Arrays.sort(A);
        for (int i = 0; i < k; i++) {
            if (((long) A[i] + (long) A[i+1]) > (long) A[i+2]) {
                return 1;
            }
        }
        return 0;
    }
}
