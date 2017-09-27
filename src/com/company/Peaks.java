package com.company;

import java.util.ArrayList;

public class Peaks {

    private static final int[] I1 = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
    private static final int[] I2 = {0, 1, 0, 0, 1, 0, 0, 1, 0};
    private static final int A1 = 3;
    private static final int A2 = 3;

    public static void main(String[] args) {
        System.out.println(A1 == solution(I1));
        System.out.println(A2 == solution(I2));
    }

    private static int solution(int[] A) {
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (isPeak(A, i)) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) {
            return 0;
        } else {
            if (peaks.size() == 1) {
                return 1;
            } else {
                int answer = 0;

                for (int i = 1; i <= peaks.size(); i++) {
                    boolean hasPeakInEveryBlock = true;
                    if (A.length % i != 0) continue;
                    int blockSize = A.length / i;
                    System.out.println(i + " blocksize= " + blockSize);
                    for (int j = 0; j < i; j++) {
                        System.out.println("    peak= " + peaks.get(j));
                        System.out.println("    blockStart= " + (blockSize * j) + " blockEnd= " + (blockSize * j + blockSize));
                        boolean inBlock = peakInBlock(peaks.get(j), blockSize * j, blockSize * j + blockSize);
                        System.out.println("    " + inBlock);
                        if (!inBlock) {
                            hasPeakInEveryBlock = false;
                        }
                        System.out.println("    " + hasPeakInEveryBlock);
                    }
                    if (hasPeakInEveryBlock) {
                        answer = i;
                    }
                    System.out.println(i + " answer= " + answer);
                }
                return answer;
            }
        }
    }

    private static final boolean peakInBlock(int peakPosition, int blockStart, int blockEnd) {
        return blockStart <= peakPosition && peakPosition <= blockEnd;
    }

    private static final boolean isPeak(int[] A, int i) {
        return A[i] > A[i - 1] && A[i] > A[i + 1];
    }
}
