package com.company;

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
        int[] peaks = getPeaks(A);

        if (peaks.length == 0) {
            return 0;
        } else {
            if (peaks.length == 1) {
                return 1;
            } else {
                int answer = 0;

                for (int i = peaks.length; i >= 1; i--) {
                    boolean hasPeakInEveryBlock = true;
                    if (A.length % i != 0) continue;
                    int blockSize = A.length / i;
                    for (int j = 0; j < i; j++) {
                        boolean inBlock = peakInBlock(peaks[j], blockSize * j, blockSize * j + blockSize);
                        if (!inBlock) {
                            hasPeakInEveryBlock = false;
                        }
                    }
                    if (hasPeakInEveryBlock) {
                        answer = i;
                        break;
                    }
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

    public static int[] getPeaks(int[] A) {
        int[] temp = new int[A.length];
        int j = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (isPeak(A, i)) {
                temp[j] = i;
                j++;
            }
        }
        int[] peaks = new int[j];
        System.arraycopy(temp, 0, peaks, 0, peaks.length);
        System.out.println(peaks.length);
        return peaks;
    }
}
