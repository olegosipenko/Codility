package com.company;

import java.util.Arrays;

public class Sieve {

    public static void main(String[] args) {
        for (int i = 0; i < sieve(17).length; i++) {
            System.out.printf("%d %b\n", i, sieve(17)[i]);
        }
    }

    private static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, 2, n + 1, true);
        int i = 2;
        while (i * i <= n) {
            if (sieve[i]) {
                int k = i * i;
                while (k <= n) {
                    sieve[k] = false;
                    k += i;
                }
            }
            i++;
        }
        return sieve;
    }
}
