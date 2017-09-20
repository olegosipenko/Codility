package com.company;

public class CountFactors {
    private static final int I1 = 24;
    private static final int I2 = 1;
    private static final int A1 = 8;
    private static final int A2 = 1;
    private static final int I3 = 9;
    private static final int A3 = 3;

    public static void main(String[] args) {
        System.out.println(A1 == solution(I1));
        System.out.println(A2 == solution(I2));
        System.out.println(A3 == solution(I3));
    }

    private static int solution(int N) {
        long d = 1;
        int factorsCount = 0;
        long lastFactor = 0;
        while (d * d <= N) {
            if (N % d == 0) {
                factorsCount += 2;
            }
            lastFactor = d;
            d++;
        }
        if (lastFactor * lastFactor == N) {
            factorsCount--;
        }
        return factorsCount;
    }
}
