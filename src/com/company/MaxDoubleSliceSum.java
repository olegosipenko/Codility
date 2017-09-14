package com.company;

public class MaxDoubleSliceSum {
    private static final int[] INPUT = {3, 2, 6, -1, 4, 5, -1, 2};
    private static final int[] INPUT2 = {5, 5, 5};
    private static final int[] INPUT3 = {5, 17, 0, 3};
    private static final int[] I4 = {0, 10, -5, -2, 0};
    private static final int[] I5 = {-8, 10, 20, -5, -7, -4};
    private static final int[] I6 = {6, 1, 5, 6, 4, 2, 9, 4};
    private static final int ANSWER = 17;
    private static final int ANSWER2 = 0;
    private static final int A3 = 17;
    private static final int A4 = 10;
    private static final int A5 = 30;
    private static final int A6 = 26;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
        System.out.println(ANSWER2 == solution(INPUT2));
        System.out.println(A3 == solution(INPUT3));
        System.out.println(A4 == solution(I4));
        System.out.println(A5 == solution(I5));
        System.out.println(A6 == solution(I6));
    }

    private static int solution(int[] A) {
        if (A.length == 3) return 0;

        int maxSum = MaxSlice.sum(A);
        if (maxSum == 0) return 0;

        int left = 0;
        int right = A.length - 1;

        do {
            left++;
        } while ((maxSum - A[left]) >= maxSum);
        do {
            right--;
        } while ((maxSum - A[right]) >= maxSum);


        int maxSumDup = maxSum;

        for (int i = 0; i < left; i++) {
            maxSum -= A[i];
        }
        for (int i = right + 1; i <= A.length - 1; i++) {
            maxSum -= A[i];
        }
        if (maxSum > maxSumDup) {
            maxSum = maxSumDup;
        }

        if ((right - left) <= 1) {
            return maxSum;
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (A[i] < minValue) {
                minValue = A[i];
            }
        }

        return maxSum - minValue;
    }
}
