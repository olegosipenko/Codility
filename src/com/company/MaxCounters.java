package com.company;

import java.util.Arrays;

public class MaxCounters {
    private static final int[] INPUT = new int[]{3, 4, 4, 6, 1, 4, 4};
    private static final int K = 5;
    private static final int[] OUTPUT = new int[]{3, 2, 2, 4, 2};

    public static void main(String[] args) {
        System.out.println(Arrays.equals(solution(K, INPUT), OUTPUT));
    }

    private static int[] solution(int N, int[] A) {
        int[] answer = new int[N];
        int max = 0;
        int lastUpdate = 0;
        for (int a : A) {
            if (a == N + 1) {
                lastUpdate = max;
            } else {
                if (answer[a - 1] < lastUpdate) {
                    answer[a - 1] = lastUpdate + 1;
                } else {
                    answer[a - 1]++;
                }
                if (answer[a - 1] > max) {
                    max = answer[a - 1];
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] < lastUpdate) {
                answer[i] = lastUpdate;
            }
        }
        return answer;
    }
}
