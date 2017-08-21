package com.company;

import java.util.stream.IntStream;

/**
 * Created by olegosipenko on 31.07.17.
 */
public class OddOccurrences {
    private static final int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};

    public static void main(String[] args) {
        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        return IntStream.of(A)
                .reduce((left, right) -> left ^ right)
                .getAsInt();
    }
}
