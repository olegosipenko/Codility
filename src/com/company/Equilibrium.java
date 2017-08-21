package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Equilibrium {

    private static final int[] A = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};

    public static void main(String[] args) {
        int[] sides = new int[2];
        int result = IntStream.range(0, A.length)
                .filter(value -> {
                    if (value > 0) {
                        sides[0] = IntStream.of(Arrays.copyOfRange(A, 0, value)).reduce(0, (left, right) -> left + right);
                    }
                    if (value < A.length - 1) {
                        sides[1] = IntStream.of(Arrays.copyOfRange(A, value + 1, A.length)).reduce(0, ((left, right) -> left + right));
                    }
                    return sides[0] == sides[1];
                }).findFirst().orElse(-1);
        System.out.print(result);
    }
}
