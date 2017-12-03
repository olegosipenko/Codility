package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OddNumbers {
    private static final int I1 = 2;
    private static final int I2 = 5;
    private static final int[] A = new int[]{3, 5};

    public static void main(String[] args) {
        System.out.println(Arrays.equals(A, oddNumbers(I1, I2)));
    }

    private static int[] oddNumbers(int l, int r) {
        return IntStream.rangeClosed(l, r)
                .filter(value -> value % 2 != 0)
                .toArray();
    }
}
