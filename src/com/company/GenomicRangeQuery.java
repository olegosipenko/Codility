package com.company;

import java.util.Arrays;

public class GenomicRangeQuery {

    private static final String SEQ = "CAGCCTA";
    private static final int[] I1 = {2, 5, 0};
    private static final int[] I2 = {4, 5, 6};
    private static final int[] ANSWER = {2, 4, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.equals(ANSWER, solution(SEQ, I1, I2)));
    }

    private static int[] solution(String S, int[] P, int[] Q) {
        int A[] = new int[S.length() + 1];
        int C[] = new int[S.length() + 1];
        int G[] = new int[S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            A[i + 1] = A[i] + (S.charAt(i) == 'A' ? 1 : 0);
            C[i + 1] = C[i] + (S.charAt(i) == 'C' ? 1 : 0);
            G[i + 1] = G[i] + (S.charAt(i) == 'G' ? 1 : 0);
        }

        for (int i = 0; i < P.length; i++) {
            int a = A[Q[i] + 1] - A[P[i]];
            int c = C[Q[i] + 1] - C[P[i]];
            int g = G[Q[i] + 1] - G[P[i]];
            P[i] = a > 0 ? 1 : c > 0 ? 2 : g > 0 ? 3 : 4;
        }
        return P;
    }
}
