package com.company;

public class MaxProfit {
    private static final int[] I1 = {23171, 21011, 21123, 21366, 21013, 21367};
    private static final int[] I2 = {};
    private static final int[] I3 = {8, 9, 3, 6, 1, 2};
    private static final int A1 = 356;
    private static final int A2 = 0;
    private static final int A3 = 3;

    public static void main(String[] args) {
        System.out.println(A1 == solution(I1));
        System.out.println(A2 == solution(I2));
        System.out.println(A3 == solution(I3));
    }

    private static int solution(int[] A) {
        if (A.length <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for (int a : A) {
            if (a > max) {
                max = a;
            }
            if (a < min) {
                profit = Math.max(max - min, profit);
                min = a;
                max = a;
            }
        }
        return Math.max(max - min, profit);
    }

    private static int quadraticSolution(int[] A) {
        int maxProfit = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int profit = A[j] - A[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
