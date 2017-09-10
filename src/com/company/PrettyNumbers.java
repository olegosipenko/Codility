package com.company;

import java.util.stream.IntStream;

public class PrettyNumbers {

    private static final int IN1 = 10000;
    private static final int IN2 = 100;

    public static void main(String[] args) {
        System.out.println(count(IN1));
        System.out.println(count(IN2));
    }

    private static int count(int N) {
        return IntStream.range(1, N)
                .mapToObj(String::valueOf)
                .filter(s -> s.chars().distinct().toArray().length < s.length())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
