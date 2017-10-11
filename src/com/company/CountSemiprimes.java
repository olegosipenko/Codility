package com.company;

import java.util.Arrays;

public class CountSemiprimes {
    private static final int[] P1 = {1, 4, 16};
    private static final int[] Q1 = {26, 10, 20};
    private static final int N1 = 26;
    private static final int[] A1 = {10, 4, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.equals(A1, solution(N1, P1, Q1)));
    }

    private static int[] solution(int N, int[] P, int[] Q) {
        int[] answer = new int[P.length];

        int[] semiPrimes = getSemiPrimes(N);

        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            for (int j = P[i]; j <= Q[i]; j++) {
                count += semiPrimes[j];
            }
            answer[i] = count;
        }
        return answer;
    }

    private static int[] getSemiPrimes(int N) {
        int[] semiPrimes = new int[N + 1];
        int j = 2;
        while (j * j < N) {
            if (semiPrimes[j] == 0) {
                int k = j * j;
                while (k <= N) {
                    if (isSemiPrime(semiPrimes, k)) {
                        semiPrimes[k] = 1;
                    }
                    k += j;
                }
            }
            j++;
        }
        return semiPrimes;
    }

    private static boolean isSemiPrime(int[] semiPrimes, int k) {
        return semiPrimes[k] == 0 && countFactors(k) == 2;
    }

    private static int countFactors(int x) {
        int n = x;
        int factors = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors++;
                n /= i;
            }
        }
        return factors;
    }
}
