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
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
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
                boolean hasPeakInEveryBlock = true;
                for (int j = 2; j < peaks.size(); j++) {
                    if (A.length % j != 0) continue;
                    answer = j;
                    int step = A.length / j;
                    for (int i = 0; i < peaks.size(); i++) {
                        if (i * step <= peaks.get(i) && peaks.get(i) <= i * step + step) {
                            break;
                        } else {
                            hasPeakInEveryBlock = false;
                        }
                    }
                    if (hasPeakInEveryBlock) {
                        answer++;
                    }
                }
                return answer == 0 ? peaks.size() : answer;
            }
        }
    }
}
