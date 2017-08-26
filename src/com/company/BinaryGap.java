package com.company;

import java.util.Arrays;

/**
 * Created by olegosipenko on 31.07.17.
 */
public class BinaryGap {
    private static final int N = 15;
    private static final int N1 = 6;
    private static final int N2 = 20;
    private static final int N3 = 16;

    public static void main(String[] args) {
        System.out.println(solution(N));
        System.out.println(0 == solution(N1));
        System.out.println(1 == solution(N2));
        System.out.println(0 == solution(N3));
    }

    private static int solution(int N) {
        if ((N & (N - 1)) == 0) return 0;
        String binary = Integer.toBinaryString(N);
        while (binary.charAt(binary.length() - 1) != '1') {
            binary = binary.substring(0, binary.length() - 1);
        }
        int length = Arrays.stream(binary.split("1+"))
                .mapToInt(String::length)
                .max().orElse(0);

        return length;
    }
}
