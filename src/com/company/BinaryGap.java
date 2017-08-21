package com.company;

import java.util.Arrays;

/**
 * Created by olegosipenko on 31.07.17.
 */
public class BinaryGap {
    private static final int N = 15;

    public static void main(String[] args) {
        System.out.print(solution(N));
    }

    private static int solution(int N) {
        return Arrays.stream(Integer.toBinaryString(N).split("1+"))
                .mapToInt(String::length)
                .max().orElse(0);
    }
}
