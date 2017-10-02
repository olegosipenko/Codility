package com.company;

import static com.company.Peaks.getPeaks;

public class Flags {
    private static final int[] I1 = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
    private static final int A1 = 3;

    public static void main(String[] args) {
        System.out.println(A1 == solution(I1));
    }

    private static int solution(int[] A) {
        int[] peaks = getPeaks(A);
        if (peaks.length > 0) {
            int totalDistance = 0;
            for (int i = 1; i < peaks.length; i++) {
                totalDistance += (peaks[i] - peaks[i - 1]);
            }

            for (int i = peaks.length; i > 0; i--) {
                int expectedDistance = i * (i - 1);
                if (totalDistance >= expectedDistance) {
                    return i;
                }
            }
            return 1;
        } else {
            return 0;
        }
    }
}
