package com.company;

public class MaxSlice {
    private static final int[] INPUT = {5, -7, 3, 5, -2, 4, -1};
    private static final int[] INPUT2 = {3, 2, 6, -1, 4, 5, -1, 2};
    private static final int ANSWER = 10;


    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
        System.out.println(solution(INPUT2));
    }

    private static int solution(int[] A) {
        return sum(A);
    }

    public static int sum(int[] A) {
        int maxEnding = 0;
        int maxSliceSum = 0;
        for (int a : A) {
            maxEnding = Math.max(0, maxEnding + a);
            maxSliceSum = Math.max(maxSliceSum, maxEnding);
        }
        return maxSliceSum;
    }
}
