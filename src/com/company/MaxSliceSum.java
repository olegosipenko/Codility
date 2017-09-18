package com.company;

public class MaxSliceSum {
    private static final int[] I1 = {5, -7, 3, 5, -2, 4, -1};
    private static final int[] I2 = {3, 2, 6, -1, 4, 5, -1, 2};
    private static final int[] I3 = {3, 2, -6, 4, 0};
    private static final int[] I4 = {-10};
    private static final int A1 = 10;
    private static final int A2 = 20;
    private static final int A3 = 5;
    private static final int A4 = -10;


    public static void main(String[] args) {
        System.out.println(A1 == solution(I1));
        System.out.println(A2 == solution(I2));
        System.out.println(A3 == solution(I3));
        System.out.println(A4 == solution(I4));
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
        if (maxEnding == 0 && maxSliceSum == 0) {
            int maxValue = Integer.MIN_VALUE;
            for (int a: A) {
                maxValue = Math.max(maxValue, a);
            }
            return maxValue;
        }
        return maxSliceSum;
    }
}
