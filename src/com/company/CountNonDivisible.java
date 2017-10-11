package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class CountNonDivisible {
    private static final int[] I1 = {3, 1, 2, 3, 6};
    private static final int[] A1 = {2, 4, 3, 2, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.equals(A1, solution(I1)));
    }

    private static int[] solution(int[] A) {
        int[] counts = new int[A.length];
        int j = 0;
        for (int i : A) {
            counts[j++] = (int) IntStream.of(A)
                    .filter(x -> getFactors(i).noneMatch(y -> y == x))
                    .filter(x -> i != x)
                    .count();
        }
        return counts;
    }

    private static IntStream getFactors(int x) {
        return IntStream.range(1, x + 1).filter(i -> x % i == 0);
    }
}
